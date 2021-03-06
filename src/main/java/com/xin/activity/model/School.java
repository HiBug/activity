package com.xin.activity.model;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

/**
 * @author three
 * @since 2018/12/26 23:11
 * <p>
 *
 * </p>
 */
@Entity
@Data
@DynamicInsert
@DynamicUpdate
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long    id;
    private String  name;
    private String  mobile;
    private Integer teacherCount;
    private Integer studentCount;

    @Column(insertable = false, updatable = false)
    private Date crtTime;
    @Column(insertable = false, updatable = false)
    private Date updTime;
}
