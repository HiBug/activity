package com.xin.activity.common;

import com.alibaba.fastjson.annotation.JSONType;
import com.fasterxml.jackson.annotation.JsonValue;
import com.xin.activity.deserializer.EnumDeserializer;
import lombok.Getter;


/**
 * @author three
 * @since 2018/12/27 19:18
 * <p>
 *
 * </p>
 */
@Getter
@JSONType(deserializer = EnumDeserializer.class)
public enum StudentStatus implements EnumBase {
    todo("0", "申请中"),
    doing("1", "学习中"),
    done("2", "已毕业"),
    quit("3", "退学"),
    defaultType("", "");

    private String value;
    private String desc;

    @JsonValue
    public String getValue() {
        return value;
    }

    StudentStatus(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }
}
