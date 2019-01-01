package com.xin.activity.helper;

import com.xin.activity.common.ErrorCodeEnum;
import com.xin.activity.core.BizException;

/**
 * @author three
 * @since 2019/1/1 15:02
 * <p>
 *
 * </p>
 */
public class CheckHelper {
    public static <T> void checkNull(T value, ErrorCodeEnum errorCode) throws BizException {
        if (value == null) {
            errorCode.throwException();
        }
    }
}
