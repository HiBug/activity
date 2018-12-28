package com.xin.activity.core;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author three
 * @since 2018/12/28 14:52
 * <p>
 *
 * </p>
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BizException extends Exception {
    private String code;
    private String msg;

    public BaseResponse buildResponse() {
        BaseResponse response = new BaseResponse();
        response.setCode(this.code);
        response.setMsg(this.msg);
        return response;
    }
}
