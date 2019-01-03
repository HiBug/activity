package com.xin.activity.helper;

import com.xin.activity.common.ErrorCodeEnum;
import com.xin.activity.core.BizException;
import com.xin.activity.handler.requestBeans.CourseEntityBean;
import com.xin.activity.model.Course;
import com.xin.activity.model.CourseInfo;
import com.xin.activity.model.Master;
import com.xin.activity.repository.CourseInfoRepository;
import com.xin.activity.repository.CourseRepository;
import com.xin.activity.util.BeanUtil;
import com.xin.activity.util.DateUtil;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.xin.activity.common.ErrorCodeEnum.course_occupied;
import static com.xin.activity.common.ErrorCodeEnum.student_appointment_date_illegal;

/**
 * @author three
 * @since 2019/1/2 11:48
 * <p>
 *
 * </p>
 */
@Component
@Log4j2
public class CourseHelper {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private MasterHelper masterHelper;

    @Autowired
    private CourseInfoRepository courseInfoRepository;

    public Course getById(Long id) throws BizException {
        Course course = courseRepository.getOne(id);
        checkCourse(course);
        return course;
    }

    /**
     * 校验该时间是否在课程区间
     *
     * @param date
     * @throws BizException
     */
    public void checkDate(Date date, Long masterId) throws BizException {
        List<Course> courses = courseRepository.queryByMasterIdAndDate(masterId, date);
        if (CollectionUtils.isNotEmpty(courses)) {
            ErrorCodeEnum.course_exist.throwException();
        }
    }

    public void editCourse(List<CourseEntityBean> beans, Long courseId) throws BizException {
        Course course = getById(courseId);
        Master master = masterHelper.getMasterById(course.getMasterId());

        int studentCntOneDay = master.getStudentCountOneDay();
        //删除老的课程安排
        courseInfoRepository.deleteAllByCourseId(course.getId());

        List<CourseInfo> infos = beans.stream()
                .filter(bean -> bean.getRank() <= studentCntOneDay)
                .filter(bean -> DateUtil.addDays(bean.getDate(), -1).before(course.getEndDate())
                        && DateUtil.addDays(bean.getDate(), 1).after(course.getStartDate()))
                .map(bean -> {
                    CourseInfo info = BeanUtil.buildBean(bean, CourseInfo.class);
                    info.setWeek(DateUtil.getWeekRank(info.getDate()));
                    info.setCourseId(course.getId());
                    return info;
                }).collect(Collectors.toList());
        courseInfoRepository.saveAll(infos);
    }

    public void editCourseSingle(CourseEntityBean bean, Course course, Integer studentCntOneDay) throws BizException {
        if (bean.getRank() > studentCntOneDay) {
            course_occupied.throwException();
        }
        Date appointmentDate = bean.getDate();
        if (course.getEndDate().before(appointmentDate)
                || appointmentDate.before(course.getStartDate())) {
            student_appointment_date_illegal.throwException();
        }

        CourseInfo info = BeanUtil.buildBean(bean, CourseInfo.class);
        info.setWeek(DateUtil.getWeekRank(info.getDate()));
        info.setCourseId(course.getId());

        courseInfoRepository.save(info);

    }


    private void checkCourse(Course course) throws BizException {
        CheckHelper.checkNull(course, ErrorCodeEnum.course_null);
    }
}
