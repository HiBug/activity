package com.xin.activity.handler;

import com.xin.activity.common.ErrorCodeEnum;
import com.xin.activity.common.FunctionCode;
import com.xin.activity.core.BaseResponse;
import com.xin.activity.core.Handler;
import com.xin.activity.handler.requestBeans.NotFoundRequestBean;
import com.xin.activity.handler.responseBeans.NotFoundResponseBean;
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
    public BaseResponse handle(NotFoundRequestBean request, String openId) {
        return ErrorCodeEnum.error.buildResponse(NotFoundResponseBean.builder().message("not found").build());
    }

}
