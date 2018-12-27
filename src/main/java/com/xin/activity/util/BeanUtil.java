package com.xin.activity.util;

import org.springframework.beans.BeanUtils;

/**
 * @author three
 * @since 2018/12/27 18:10
 * <p>
 *
 * </p>
 */
public class BeanUtil extends BeanUtils {
    public static <T> T buildBean(Object source, Class<T> target) {
        try {
            T result = target.newInstance();
            copyProperties(source, result);
            return result;
        } catch (Exception e) {
            return null;
        }
    }
}
