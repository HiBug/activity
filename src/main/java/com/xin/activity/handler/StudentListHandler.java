package com.xin.activity.handler;

import com.xin.activity.common.ErrorCodeEnum;
import com.xin.activity.common.FunctionCode;
import com.xin.activity.core.BaseResponse;
import com.xin.activity.core.BizException;
import com.xin.activity.core.Handler;
import com.xin.activity.handler.requestBeans.StudentListRequestBean;
import com.xin.activity.handler.responseBeans.StudentListResponseBean;
import com.xin.activity.repository.MasterRepository;
import com.xin.activity.repository.StudentRepository;
import com.xin.activity.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author three
 * @since 2018/12/27 19:34
 * <p>
 *
 * </p>
 */
@Service(FunctionCode.studentList)
public class StudentListHandler implements Handler<StudentListRequestBean> {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private MasterRepository masterRepository;

    @Override
    public BaseResponse handle(StudentListRequestBean request, String openId) throws BizException {

        //找到教练

        //找到学生

        return ErrorCodeEnum.success.buildResponse(BeanUtil.buildBean(studentRepository.getOne(1L), StudentListResponseBean.class));

    }
}
