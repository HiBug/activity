package com.xin.activity.core;

import com.alibaba.fastjson.JSON;
import com.xin.activity.common.FunctionEnum;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author three
 * @since 2018/12/26 23:25
 * <p>
 *
 * </p>
 */
@RestController
@SuppressWarnings("unchecked")
public class Route implements ApplicationContextAware {

    private Map<String, Handler> mappedFunction;

    @RequestMapping(value = "route", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public BaseResponse route(@RequestBody @Validated BaseRequest request) throws BizException {
        FunctionEnum functionEnum = request.getFunction();
        Handler      handler      = mappedFunction.get(functionEnum.getCode());
        RequestBean  requestBean  = JSON.parseObject(JSON.toJSONString(request.getParam()), functionEnum.getRequestBeanClass());
        return handler.handle(requestBean, request.getOpenId());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        mappedFunction = applicationContext.getBeansOfType(Handler.class);
    }
}
