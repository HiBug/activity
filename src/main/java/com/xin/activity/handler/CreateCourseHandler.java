package com.xin.activity.handler;

import com.xin.activity.common.ErrorCodeEnum;
import com.xin.activity.common.FunctionCode;
import com.xin.activity.core.BaseResponse;
import com.xin.activity.core.BizException;
import com.xin.activity.core.Handler;
import com.xin.activity.handler.requestBeans.CreateCourseRequestBean;
import com.xin.activity.helper.CourseHelper;
import com.xin.activity.helper.MasterHelper;
import com.xin.activity.model.Course;
import com.xin.activity.model.Master;
import com.xin.activity.repository.CourseRepository;
import com.xin.activity.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * @author three
 * @since 2019/1/3 9:06
 * <p>
 *
 * </p>
 */
@Service(FunctionCode.createCourse)
public class CreateCourseHandler implements Handler<CreateCourseRequestBean> {
    @Autowired
    private CourseHelper courseHelper;

    @Autowired
    private MasterHelper masterHelper;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public BaseResponse handle(@Validated CreateCourseRequestBean request, String openId) throws BizException {
        Master master = masterHelper.getMasterByOpenId(openId);
        //校验这个时间段是否已经有了课程
        courseHelper.checkDate(request.getStartDate(), master.getId());

        //创建课程
        Course course = courseRepository.save(buildCourse(master, request));
        //创建课程详情
        courseHelper.editCourse(request.getList(), course.getId());

        return ErrorCodeEnum.success.buildResponse();
    }

    private Course buildCourse(Master master, CreateCourseRequestBean request) {

        Course course = new Course();
        course.setMasterId(master.getId());
        course.setSchoolId(master.getSchoolId());
        course.setMemo(request.getMemo());
        course.setStartDate(request.getStartDate());
        course.setEndDate(DateUtil.addDays(course.getStartDate(), master.getPeriodOneCourse()));
        return course;
    }
}
