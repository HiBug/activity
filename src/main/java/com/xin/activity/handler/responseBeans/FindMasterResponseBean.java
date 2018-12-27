package com.xin.activity.handler.responseBeans;

import com.xin.activity.core.ResponseBean;
import lombok.Data;

/**
 * @author three
 * @since 2018/12/27 15:53
 * <p>
 *
 * </p>
 */
@Data
public class FindMasterResponseBean implements ResponseBean {
    private Long   id;
    private String realName;
    private String iconUrl;
}
