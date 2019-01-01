package com.xin.activity.handler.responseBeans;

import com.xin.activity.common.StudentStatus;
import lombok.Data;

/**
 * @author three
 * @since 2018/12/29 11:32
 * <p>
 *
 * </p>
 */
@Data
public class StudentBean {
    private Long          id;
    private String        iconUrl;
    private String        realName;
    private String        mobile;
    private StudentStatus status;
}
