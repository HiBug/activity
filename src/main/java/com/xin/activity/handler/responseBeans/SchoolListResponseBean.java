package com.xin.activity.handler.responseBeans;

import com.xin.activity.core.ResponseBean;
import com.xin.activity.model.School;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author three
 * @since 2018/12/27 15:01
 * <p>
 *
 * </p>
 */
@Data
@Builder
public class SchoolListResponseBean implements ResponseBean {
    private List<SchoolBean> list;

    @Data
    @Builder
    public static class SchoolBean {
        private Long   id;
        private String name;
    }
}
