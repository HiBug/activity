package com.xin.activity.handler.responseBeans;

import com.xin.activity.core.DefaultPageResponse;
import com.xin.activity.core.RequestBean;
import lombok.Data;

/**
 * @author three
 * @since 2018/12/29 11:30
 * <p>
 *
 * </p>
 */
@Data
public class StudentApplyListResponseBean implements RequestBean {
    DefaultPageResponse<StudentBean> page;
}
