package com.xin.activity.handler.requestBeans;

import com.xin.activity.common.StudentStatus;
import com.xin.activity.core.DefaultPageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author three
 * @since 2018/12/27 19:30
 * <p>
 *
 * </p>
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class StudentListRequestBean extends DefaultPageRequest {
    private StudentStatus type;
}
