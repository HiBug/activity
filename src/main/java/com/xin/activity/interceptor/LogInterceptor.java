package com.xin.activity.interceptor;

import com.alibaba.fastjson.JSON;
import com.xin.activity.common.ErrorCodeEnum;
import com.xin.activity.core.BaseRequest;
import com.xin.activity.core.BaseResponse;
import com.xin.activity.core.BizException;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author three
 * @since 2018/12/27 14:29
 * <p>
 *
 * </p>
 */
@Component
@Aspect
@Log4j2
public class LogInterceptor {

    @Pointcut("execution(* com.xin.activity.core.Route.route(..))")
    public void pointCut() {
    }

    @Around("pointCut()")
    public BaseResponse log(ProceedingJoinPoint proceedingJoinPoint) {

        BaseRequest  request = (BaseRequest) proceedingJoinPoint.getArgs()[0];
        BaseResponse response;
        try {
            response = (BaseResponse) proceedingJoinPoint.proceed();
        } catch (BizException be) {
            response = be.buildResponse();
        } catch (Throwable t) {
            log.error("error:", t);
            response = ErrorCodeEnum.error.buildResponse();
        }
        log.info("request:{},response:{}", JSON.toJSONString(request), JSON.toJSONString(response));
        return response;
    }
}
