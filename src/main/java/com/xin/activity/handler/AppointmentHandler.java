package com.xin.activity.handler;

import com.xin.activity.common.CourseInfoStatus;
import com.xin.activity.common.ErrorCodeEnum;
import com.xin.activity.common.FunctionCode;
import com.xin.activity.core.BaseResponse;
import com.xin.activity.core.BizException;
import com.xin.activity.core.Handler;
import com.xin.activity.handler.requestBeans.AppointmentRequestBean;
import com.xin.activity.handler.requestBeans.CourseEntityBean;
import com.xin.activity.helper.CourseHelper;
import com.xin.activity.helper.MasterHelper;
import com.xin.activity.helper.StudentHelper;
import com.xin.activity.model.Course;
import com.xin.activity.model.Master;
import com.xin.activity.model.Student;
import com.xin.activity.util.BeanUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * @author three
 * @since 2019/1/3 22:45
 * <p>
 *
 * </p>
 */
@Service(FunctionCode.appointment)
@Log4j2
public class AppointmentHandler implements Handler<AppointmentRequestBean> {

    @Autowired
    private CourseHelper courseHelper;

    @Autowired
    private StudentHelper studentHelper;

    @Autowired
    private MasterHelper masterHelper;

    @Override
    public BaseResponse handle(@Validated AppointmentRequestBean request, String openId) {
        try {
            Course           course  = courseHelper.getById(request.getCourseId());
            Student          student = studentHelper.getByOpenId(openId);
            Master           master  = masterHelper.getMasterById(student.getMasterId());
            CourseEntityBean bean    = BeanUtil.buildBean(request, CourseEntityBean.class);

            //学员检测
            studentHelper.checkForAppointment(student);

            bean.setStudentId(student.getId());
            bean.setStatus(CourseInfoStatus.appointment);
            courseHelper.editCourseSingle(bean, course, master.getStudentCountOneDay());
            return ErrorCodeEnum.success.buildResponse();
        } catch (BizException e) {
            return e.buildResponse();
        } catch (Exception e) {
            log.error("error:", e);
            return ErrorCodeEnum.course_occupied.buildResponse();
        }
    }
}
