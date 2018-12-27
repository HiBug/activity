package com.xin.activity.util;

import com.xin.activity.core.DefaultPageResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;

import java.util.stream.Collectors;

/**
 * @author three
 * @since 2018/12/27 18:10
 * <p>
 *
 * </p>
 */
@Log4j2
public class BeanUtil extends BeanUtils {
    public static <T> T buildBean(Object source, Class<T> target) {
        try {
            T result = target.newInstance();
            copyProperties(source, result);
            return result;
        } catch (Exception e) {
            log.info("buildBean error:", e);
            return null;
        }
    }

    public static <T, S> DefaultPageResponse<T> buildPage(Page<S> source, Class<T> target) {
        return DefaultPageResponse.<T>builder()
                .first(source.isFirst())
                .last(source.isLast())
                .list(source.getContent().stream()
                        .map(s -> buildBean(s, target))
                        .collect(Collectors.toList()))
                .totalPages(source.getTotalPages())
                .page(source.getPageable().getPageNumber() + 1)
                .build();
    }
}
