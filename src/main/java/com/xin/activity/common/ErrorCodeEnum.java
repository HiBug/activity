package com.xin.activity.common;

import com.xin.activity.core.BaseResponse;
import com.xin.activity.core.BizException;
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

    master_null("1001", "这个教练好像不存在"),
    master_not_permit("1002", "您没有操作该学员的权限"),

    student_null("2001", "这个学员不存在"),

    error("9999", "error");

    private String code;
    private String msg;

    ErrorCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public void throwException() throws BizException {
        BizException exception = new BizException();
        exception.setCode(this.getCode());
        exception.setMsg(this.getMsg());
        throw exception;
    }

    public BaseResponse buildResponse() {
        BaseResponse response = new BaseResponse();
        response.setMsg(this.getMsg());
        response.setCode(this.getCode());
        return response;
    }

    public <T extends ResponseBean> BaseResponse<T> buildResponse(T data) {
        BaseResponse<T> response = new BaseResponse<>();
        response.setData(data);
        response.setCode(this.getCode());
        response.setMsg(this.getMsg());
        return response;
    }
}
