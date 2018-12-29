package com.xin.activity.core;

import javax.validation.constraints.Max;

/**
 * @author three
 * @since 2018/12/27 15:06
 * <p>
 *
 * </p>
 */

public class DefaultPageRequestBean implements RequestBean {
    private int page = 1;
    @Max(20)
    private int size = 10;

    public int getPage() {
        return page - 1;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
