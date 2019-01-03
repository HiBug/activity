package com.xin.activity.model;

import com.xin.activity.common.CourseInfoStatus;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

/**
 * @author three
 * @since 2018/12/26 23:08
 * <p>
 *
 * </p>
 */
@Entity
@Data
@DynamicInsert
@DynamicUpdate
@Table(name = "courseinfo")
public class CourseInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long             id;
    private Long             courseId;
    private Long             studentId;
    private Integer          rank;
    private Date             date;
    private String           week;
    private CourseInfoStatus status;
    @Column(insertable = false, updatable = false)
    private Date             crtTime;
    @Column(insertable = false, updatable = false)
    private Date             updTime;
}
