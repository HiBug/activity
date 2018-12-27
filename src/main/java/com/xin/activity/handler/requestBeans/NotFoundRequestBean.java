package com.xin.activity.handler.requestBeans;

import com.xin.activity.core.RequestBean;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author three
 * @since 2018/12/27 11:40
 * <p>
 *
 * </p>
 */
@Data
public class NotFoundRequestBean implements RequestBean {
    private String code;
}
