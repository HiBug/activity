package com.xin.activity.handler;

import com.alibaba.fastjson.JSON;
import com.xin.activity.common.ErrorCodeEnum;
import com.xin.activity.common.FunctionCode;
import com.xin.activity.core.BaseResponse;
import com.xin.activity.core.Handler;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

/**
 * @author three
 * @since 2018/12/27 10:41
 * <p>
 *
 * </p>
 */
@Service(FunctionCode.notFound)
@Log4j2
public class NotFoundHandler implements Handler<NotFoundRequestBean> {
    @Override
    public BaseResponse handle(NotFoundRequestBean request) {
        log.info("function:{},request:{}", FunctionCode.notFound, JSON.toJSONString(request));
        return ErrorCodeEnum.error.buildResponse(NotFoundResponseBean.builder().hello("e").build());
    }

}
