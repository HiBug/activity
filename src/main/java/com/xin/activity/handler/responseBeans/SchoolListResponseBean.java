package com.xin.activity.handler.responseBeans;

import com.xin.activity.core.DefaultPageResponse;
import com.xin.activity.core.ResponseBean;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.Page;

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
    private DefaultPageResponse<SchoolBean> page;

    @Data
    public static class SchoolBean {
        private Long   id;
        private String name;
    }
}
