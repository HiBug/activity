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
    student_appointment_date_illegal("2002", "约车时间不在教练规定范围内"),
    student_status_todo("2003", "教练审批过后才可以选课"),
    student_status_limit("2004", "你被教练限制选课，请与教练联系"),


    school_null("3001", "该驾校不存在，请重新选择"),

    course_null("4001", "课程不存在或已删除，请重新选择"),
    course_exist("4002", "该时间段课程已经存在，请查看课程列表"),
    course_occupied("4003", "该位置已被其他学员抢先了"),
    course_delete_illegal("4004", "课程已经开始不可删除"),


    param_error("9001", "参数校验失败"),
    mobile_exist("9002", "该手机号已经注册"),
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
