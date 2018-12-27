package com.xin.activity.common;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.xin.activity.core.BaseResponse;
import com.xin.activity.core.ResponseBean;
import lombok.Getter;

/**
 * @author three
 * @since 2018/12/27 10:36
 * <p>
 *
 * </p>
 */
@Getter
public enum ErrorCodeEnum {
    success("0000", "ok"),

    error("9999", "error");

    private String code;
    private String msg;

    ErrorCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public <T extends ResponseBean> BaseResponse<T> buildResponse(T data) {
        BaseResponse<T> response = new BaseResponse<>();
        response.setData(data);
        response.setCode(this.getCode());
        response.setMsg(this.getMsg());
        return response;
    }
}
