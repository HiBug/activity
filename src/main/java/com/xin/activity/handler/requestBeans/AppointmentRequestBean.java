package com.xin.activity.handler.requestBeans;

import com.xin.activity.core.RequestBean;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author three
 * @since 2019/1/3 22:41
 * <p>
 *
 * </p>
 */
@Data
public class AppointmentRequestBean implements RequestBean {
    @NotNull
    private Long    courseId;
    @NotNull
    private Date    date;
    @NotNull
    private Integer rank;
}
