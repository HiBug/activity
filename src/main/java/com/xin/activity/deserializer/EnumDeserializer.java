package com.xin.activity.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONToken;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.xin.activity.common.EnumBase;
import org.apache.commons.lang.StringUtils;

import java.lang.reflect.Type;

/**
 * @author three
 * @since 2018/12/29 10:39
 * <p>
 * enum类型反序列化
 * </p>
 */
@SuppressWarnings("unchecked")
public class EnumDeserializer implements ObjectDeserializer {

    @Override
    public <T> T deserialze(DefaultJSONParser parser, Type type, Object fieldName) {
        final JSONLexer lexer         = parser.lexer;
        final int       token         = lexer.token();
        Class           cls           = (Class) type;
        Object[]        enumConstants = cls.getEnumConstants();
        if (EnumBase.class.isAssignableFrom(cls)) {
            for (Object enumConstant : enumConstants) {
                if (StringUtils.equals(((EnumBase) enumConstant).getValue(), lexer.stringVal())) {
                    return (T) enumConstant;
                }
            }
        } else {
            //没实现EnumBase接口的 默认的按名字或者按ordinal
            if (token == JSONToken.LITERAL_INT) {
                int intValue = lexer.intValue();
                lexer.nextToken(JSONToken.COMMA);

                if (intValue < 0 || intValue > enumConstants.length) {
                    throw new JSONException("parse enum " + cls.getName() + " error, value : " + intValue);
                }
                return (T) enumConstants[intValue];
            } else if (token == JSONToken.LITERAL_STRING) {
                return (T) Enum.valueOf(cls, lexer.stringVal());
            }
        }
        return null;
    }

    @Override
    public int getFastMatchToken() {
        return JSONToken.LITERAL_INT;
    }
}
