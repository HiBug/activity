package com.xin.activity.handler;

import com.xin.activity.common.ErrorCodeEnum;
import com.xin.activity.common.FunctionCode;
import com.xin.activity.core.BaseResponse;
import com.xin.activity.core.BizException;
import com.xin.activity.core.Handler;
import com.xin.activity.handler.requestBeans.StudentReviewRequestBean;
import com.xin.activity.helper.MasterHelper;
import com.xin.activity.helper.StudentHelper;
import com.xin.activity.model.Master;
import com.xin.activity.model.Student;
import com.xin.activity.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author three
 * @since 2019/1/1 14:06
 * <p>
 *
 * </p>
 */
@Service(FunctionCode.reviewStudent)
public class StudentReviewHandler implements Handler<StudentReviewRequestBean> {
    @Autowired
    private MasterHelper masterHelper;

    @Autowired
    private StudentHelper studentHelper;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public BaseResponse handle(StudentReviewRequestBean request, String openId) throws BizException {
        //找到教练
        Master master = masterHelper.getMasterByOpenId(openId);

        //找到学员
        Student student = studentHelper.getById(request.getStudentId());

        if (student.getMasterId() != master.getId()) {
            ErrorCodeEnum.master_not_permit.throwException();
        }

        student.setStatus(request.getStatus());

        studentRepository.save(student);

        return ErrorCodeEnum.success.buildResponse();
    }
}
