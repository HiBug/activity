package com.xin.activity.handler;

import com.xin.activity.common.ErrorCodeEnum;
import com.xin.activity.common.FunctionCode;
import com.xin.activity.core.BaseResponse;
import com.xin.activity.core.BizException;
import com.xin.activity.core.Handler;
import com.xin.activity.handler.requestBeans.EditCourseRequestBean;
import com.xin.activity.helper.CourseHelper;
import com.xin.activity.helper.MasterHelper;
import com.xin.activity.model.Course;
import com.xin.activity.model.Master;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author three
 * @since 2019/1/2 11:46
 * <p>
 *
 * </p>
 */
@Service(FunctionCode.editCourse)
public class EditCourseHandler implements Handler<EditCourseRequestBean> {
    @Autowired
    private CourseHelper courseHelper;

    @Autowired
    private MasterHelper masterHelper;

    @Override
    public BaseResponse handle(EditCourseRequestBean request, String openId) throws BizException {
        //课程归属校验
        checkCourse(request.getCourseId(), openId);
        //更改课程
        courseHelper.editCourse(request.getList(), request.getCourseId());
        return ErrorCodeEnum.success.buildResponse();
    }

    private void checkCourse(Long courseId, String openId) throws BizException {
        //判断课程归属该教练
        Course course = courseHelper.getById(courseId);
        Master master = masterHelper.getMasterByOpenId(openId);
        if (course.getMasterId().equals(master.getId())) {
            ErrorCodeEnum.master_not_permit.throwException();
        }
    }
}
