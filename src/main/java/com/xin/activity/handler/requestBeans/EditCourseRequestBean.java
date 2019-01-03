package com.xin.activity.handler.requestBeans;

import com.xin.activity.core.RequestBean;
import lombok.Data;

import java.util.List;

/**
 * @author three
 * @since 2019/1/2 11:43
 * <p>
 *
 * </p>
 */
@Data
public class EditCourseRequestBean implements RequestBean {
    private Long                   courseId;
    private List<CourseEntityBean> list;
}
