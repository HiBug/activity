package com.xin.activity.handler;

import com.xin.activity.common.ErrorCodeEnum;
import com.xin.activity.common.FunctionCode;
import com.xin.activity.common.StudentStatus;
import com.xin.activity.core.*;
import com.xin.activity.handler.responseBeans.StudentBean;
import com.xin.activity.handler.responseBeans.StudentListResponseBean;
import com.xin.activity.helper.MasterHelper;
import com.xin.activity.model.Master;
import com.xin.activity.model.Student;
import com.xin.activity.repository.StudentRepository;
import com.xin.activity.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * @author three
 * @since 2018/12/29 11:36
 * <p>
 *
 * </p>
 */
@Service(FunctionCode.studentApplyList)
public class StudentApplyListHandler implements Handler<DefaultPageRequestBean> {
    @Autowired
    private MasterHelper masterHelper;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public BaseResponse handle(DefaultPageRequestBean request, String openId) throws BizException {
        //找到教练
        Master master = masterHelper.getMasterByOpenId(openId);

        //找到学生
        Page<Student> students = studentRepository.queryByStatusAndMasterId(StudentStatus.todo,
                master.getId(),
                PageRequest.of(request.getPage(), request.getSize(),
                        Sort.by(Sort.Order.desc("crtTime"))));
        return ErrorCodeEnum.success.buildResponse(
                StudentListResponseBean.builder()
                        .page(BeanUtil.buildPage(students, StudentBean.class))
                        .build());
    }
}
