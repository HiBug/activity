package com.xin.activity.core;

import com.xin.activity.common.FunctionEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * @author three
 * @since 2018/12/26 23:26
 * <p>
 *
 * </p>
 */
@Data
public class BaseRequest {
    private FunctionEnum function;
    @NotBlank(message = "openId can not be null")
    private String       openId;
    private Object       param;
}
