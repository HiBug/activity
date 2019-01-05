package com.xin.activity.handler;

import com.xin.activity.common.ErrorCodeEnum;
import com.xin.activity.common.FunctionCode;
import com.xin.activity.core.BaseResponse;
import com.xin.activity.core.BizException;
import com.xin.activity.core.Handler;
import com.xin.activity.handler.requestBeans.DeleteCourseRequestBean;
import com.xin.activity.helper.CourseHelper;
import com.xin.activity.helper.MasterHelper;
import com.xin.activity.model.Course;
import com.xin.activity.model.Master;
import com.xin.activity.repository.CourseInfoRepository;
import com.xin.activity.repository.CourseRepository;
import com.xin.activity.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

/**
 * @author three
 * @since 2019/1/5 14:15
 * <p>
 * <p>
 * </p)>
 */
@Service(FunctionCode.deleteCourse)
public class DeleteCourseHandler implements Handler<DeleteCourseRequestBean> {

    @Autowired
    private CourseHelper courseHelper;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private MasterHelper masterHelper;

    @Autowired
    private CourseInfoRepository courseInfoRepository;

    @Override
    @Transactional
    public BaseResponse handle(DeleteCourseRequestBean request, String openId) throws BizException {

        Course course = courseHelper.getById(request.getCourseId());

        Master master = masterHelper.getMasterByOpenId(openId);

        if (!course.getMasterId().equals(master.getId())) {
            return ErrorCodeEnum.master_not_permit.buildResponse();
        }
        //已经开始的课程不可以删除
        Date now = new Date();
        if (now.before(DateUtil.addDays(course.getEndDate(), 1)) &&
                course.getStartDate().before(now)) {
            return ErrorCodeEnum.course_delete_illegal.buildResponse();
        }

        //删除课程详情
        courseInfoRepository.deleteAllByCourseId(course.getId());

        //删除课程
        courseRepository.deleteById(course.getId());

        return ErrorCodeEnum.success.buildResponse();
    }
}
