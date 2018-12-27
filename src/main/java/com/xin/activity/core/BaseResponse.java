package com.xin.activity.core;

import lombok.Data;

/**
 * @author three
 * @since 2018/12/26 23:41
 * <p>
 *
 * </p>
 */
@Data
public class BaseResponse<T extends ResponseBean> {
    private String code;
    private String msg;
    private T      data;
}
