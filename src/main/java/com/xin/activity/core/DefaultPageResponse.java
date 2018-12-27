package com.xin.activity.core;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author three
 * @since 2018/12/27 20:14
 * <p>
 *
 * </p>
 */
@Data
@Builder
public class DefaultPageResponse<T> {
    private List<T> list;
    private int     totalPages;
    private int     page;
    private boolean last;
    private boolean first;
}
