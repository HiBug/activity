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
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long schoolId;
    private Long masterId;
    private String openId;
    private Integer courseCount;
    private String nickName;
    private String realName;
    private String mobile;
    @Column(insertable = false, updatable = false)
    private Date   crtTime;
    @Column(insertable = false, updatable = false)
    private Date   updTime;
}
