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
public enum RegisterType implements EnumBase {
    student("0", "学员"),
    master("1", "教练"),
    defaultType("", "");

    private String value;
    private String desc;

    @JsonValue
    public String getValue() {
        return value;
    }

    RegisterType(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }
}
