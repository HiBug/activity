package com.xin.activity.handler.requestBeans;

import com.xin.activity.core.RequestBean;
import lombok.Data;

/**
 * @author three
 * @since 2019/1/5 14:14
 * <p>
 *
 * </p>
 */
@Data
public class DeleteCourseRequestBean implements RequestBean {
    private Long courseId;
}
