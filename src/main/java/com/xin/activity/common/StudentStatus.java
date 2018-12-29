package com.xin.activity.common;

import com.alibaba.fastjson.annotation.JSONType;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.xin.activity.deserializer.EnumDeserializer;
import lombok.Getter;
import org.apache.commons.lang.StringUtils;

import java.util.stream.Stream;

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
    doing("0", "学习中"),
    done("1", "已毕业"),
    quit("2", "退学"),
    defaultType("", "");
    private String value;
    private String desc;

    StudentStatus(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    @JsonCreator
    public static StudentStatus getByCode(String value) {
        return Stream.of(StudentStatus.values())
                .filter(type -> StringUtils.equals(type.getValue(), value))
                .findAny()
                .orElse(defaultType);
    }
}
