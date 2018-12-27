package com.xin.activity.handler.responseBeans;

import com.xin.activity.core.ResponseBean;
import lombok.Builder;
import lombok.Data;

/**
 * @author three
 * @since 2018/12/27 10:53
 * <p>
 *
 * </p>
 */
@Builder
@Data
public class NotFoundResponseBean implements ResponseBean {
    private String message;
}
