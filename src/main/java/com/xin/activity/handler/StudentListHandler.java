package com.xin.activity.handler;

import com.xin.activity.common.ErrorCodeEnum;
import com.xin.activity.common.FunctionCode;
import com.xin.activity.core.BaseResponse;
import com.xin.activity.core.BizException;
import com.xin.activity.core.Handler;
import com.xin.activity.handler.requestBeans.StudentListRequestBeanBean;
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
 * @since 2018/12/27 19:34
 * <p>
 *
 * </p>
 */
@Service(FunctionCode.studentList)
public class StudentListHandler implements Handler<StudentListRequestBeanBean> {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private MasterHelper masterHelper;

    @Override
    public BaseResponse handle(StudentListRequestBeanBean request, String openId) throws BizException {

        //找到教练
        Master master = masterHelper.getMasterByOpenId(openId);
        //找到学生
        Page<Student> students = studentRepository.queryByStatusAndMasterId(request.getStatus(),
                master.getId(),
                PageRequest.of(request.getPage(), request.getSize(),
                        Sort.by(Sort.Order.desc("crtTime"))));
        return ErrorCodeEnum.success.buildResponse(
                StudentListResponseBean.builder()
                        .page(BeanUtil.buildPage(students, StudentBean.class))
                        .build());
    }
}
