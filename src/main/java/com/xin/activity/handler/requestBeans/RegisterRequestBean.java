package com.xin.activity.handler.requestBeans;

import com.xin.activity.common.RegisterType;
import com.xin.activity.core.RequestBean;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author three
 * @since 2019/1/1 14:56
 * <p>
 *
 * </p>
 */
@Data
public class RegisterRequestBean implements RequestBean {
    @NotNull
    private RegisterType registerType;
    private String       masterMobile;
    private Long         schoolId;
    private String       mobile;
    @NotBlank
    private String       nickName;
    @NotBlank
    private String       realName;
    @NotBlank
    private String       iconUrl;
}
