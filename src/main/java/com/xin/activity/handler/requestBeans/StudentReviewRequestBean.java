package com.xin.activity.handler.requestBeans;

import com.xin.activity.common.StudentStatus;
import com.xin.activity.core.RequestBean;
import lombok.Data;

/**
 * @author three
 * @since 2019/1/1 14:03
 * <p>
 *
 * </p>
 */
@Data
public class StudentReviewRequestBean implements RequestBean {
    private Long studentId;

    private StudentStatus status;
}

