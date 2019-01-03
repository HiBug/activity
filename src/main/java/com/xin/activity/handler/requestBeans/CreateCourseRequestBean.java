package com.xin.activity.handler.requestBeans;

import com.xin.activity.core.RequestBean;
import lombok.Data;

import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

/**
 * @author three
 * @since 2019/1/2 11:36
 * <p>
 *
 * </p>
 */
@Data
public class CreateCourseRequestBean implements RequestBean {
    private Date                   startDate;
    private List<CourseEntityBean> list;
    @Size(max = 500)
    private String                 memo;
}
