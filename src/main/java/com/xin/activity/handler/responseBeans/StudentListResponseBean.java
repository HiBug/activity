package com.xin.activity.handler.responseBeans;

import com.xin.activity.core.DefaultPageResponse;
import com.xin.activity.core.ResponseBean;
import lombok.Builder;
import lombok.Data;

/**
 * @author three
 * @since 2018/12/27 19:31
 * <p>
 *
 * </p>
 */
@Data
public class StudentListResponseBean implements ResponseBean {

    private DefaultPageResponse<StudentBean> list;

    @Data
    @Builder
    public static class StudentBean {
        private Long   id;
        private String iconUrl;
        private String realName;
        private String mobile;
    }
}
