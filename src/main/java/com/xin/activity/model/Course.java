package com.xin.activity.model;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

/**
 * @author three
 * @since 2018/12/26 22:39
 * <p>
 *
 * </p>
 */
@Entity
@Data
@DynamicInsert
@DynamicUpdate
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long    id;
    private String  schoolId;
    private String  masterId;
    private Date    startDate;
    private Date    endDate;
    private Integer courseRank;
    private String  weather;
    private String  memo;
    @Column(insertable = false, updatable = false)
    private Date    crtTime;
    @Column(insertable = false, updatable = false)
    private Date    updTime;

}
