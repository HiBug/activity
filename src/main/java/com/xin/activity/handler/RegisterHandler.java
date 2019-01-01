package com.xin.activity.handler;

import com.xin.activity.common.ErrorCodeEnum;
import com.xin.activity.common.FunctionCode;
import com.xin.activity.common.RegisterType;
import com.xin.activity.common.StudentStatus;
import com.xin.activity.core.BaseResponse;
import com.xin.activity.core.BizException;
import com.xin.activity.core.Handler;
import com.xin.activity.handler.requestBeans.RegisterRequestBean;
import com.xin.activity.helper.MasterHelper;
import com.xin.activity.helper.SchoolHelper;
import com.xin.activity.helper.StudentHelper;
import com.xin.activity.model.Master;
import com.xin.activity.model.School;
import com.xin.activity.model.Student;
import com.xin.activity.repository.MasterRepository;
import com.xin.activity.repository.StudentRepository;
import com.xin.activity.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * @author three
 * @since 2019/1/1 14:59
 * <p>
 *
 * </p>
 */
@Service(FunctionCode.register)
public class RegisterHandler implements Handler<RegisterRequestBean> {

    @Autowired
    private SchoolHelper schoolHelper;

    @Autowired
    private MasterHelper masterHelper;

    @Autowired
    private StudentHelper studentHelper;

    @Autowired
    private MasterRepository masterRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public BaseResponse handle(@Validated RegisterRequestBean request, String openId) throws BizException {

        RegisterType registerType = request.getRegisterType();
        if (RegisterType.master.equals(registerType)) {
            //教练注册
            registerMaster(request, openId);
        } else if (RegisterType.student.equals(registerType)) {
            //学员注册
            registerStudent(request, openId);
        } else {
            ErrorCodeEnum.param_error.throwException();
        }

        return ErrorCodeEnum.success.buildResponse();
    }


    //教练注册
    private void registerMaster(RegisterRequestBean request, String openId) throws BizException {
        //查找学校
        School school = schoolHelper.getById(request.getSchoolId());
        //校验手机号是否注册
        masterHelper.existsByMobile(request.getMobile());
        //注册
        Master master = BeanUtil.buildBean(request, Master.class);
        if (master == null) {
            ErrorCodeEnum.error.throwException();
        }
        master.setMobile(request.getMobile());
        master.setSchoolId(school.getId());
        master.setOpenId(openId);

        masterRepository.save(master);
    }

    //学员注册
    private void registerStudent(RegisterRequestBean request, String openId) throws BizException {

        //查找教练
        Master master = masterHelper.getMasterByMobile(request.getMasterMobile());
        //校验手机号是否注册
        studentHelper.existsByMobile(request.getMobile());
        //注册
        Student student = BeanUtil.buildBean(request, Student.class);
        if (student == null) {
            ErrorCodeEnum.error.throwException();
        }
        student.setSchoolId(master.getSchoolId());
        student.setMasterId(master.getId());
        student.setStatus(StudentStatus.todo);
        student.setOpenId(openId);
        studentRepository.save(student);
    }
}
