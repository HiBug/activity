package com.xin.activity.helper;

import com.xin.activity.common.StudentStatus;
import com.xin.activity.core.DefaultPageRequestBean;
import com.xin.activity.core.DefaultPageResponse;
import com.xin.activity.handler.responseBeans.StudentBean;
import com.xin.activity.repository.StudentRepository;
import com.xin.activity.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

/**
 * @author three
 * @since 2018/12/29 11:39
 * <p>
 *
 * </p>
 */
@Component
public class StudentHelper {
    @Autowired
    private StudentRepository studentRepository;

    DefaultPageResponse<StudentBean> queryStudent(DefaultPageRequestBean pageRequest, Long masterId, StudentStatus studentStatus) {
        return BeanUtil.buildPage(
                studentRepository.queryByStatusAndMasterId(
                        studentStatus,
                        masterId,
                        PageRequest.of(pageRequest.getPage(), pageRequest.getSize(),
                                Sort.by(Sort.Order.desc("crtTime")))), StudentBean.class);

    }
}
