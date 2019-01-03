package com.xin.activity.handler.requestBeans;

import com.xin.activity.common.CourseInfoStatus;
import lombok.Data;

import java.util.Date;

/**
 * @author three
 * @since 2019/1/2 11:38
 * <p>
 *
 * </p>
 */
@Data
public class CourseEntityBean {
    private Date             date;
    private Long             studentId;
    private Integer          rank;
    private CourseInfoStatus status;
}
