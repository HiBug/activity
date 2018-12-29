package com.xin.activity.handler;

import com.xin.activity.common.ErrorCodeEnum;
import com.xin.activity.common.FunctionCode;
import com.xin.activity.core.BaseResponse;
import com.xin.activity.core.DefaultPageRequestBean;
import com.xin.activity.core.Handler;
import com.xin.activity.handler.responseBeans.SchoolListResponseBean;
import com.xin.activity.model.School;
import com.xin.activity.repository.SchoolRepository;
import com.xin.activity.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * @author three
 * @since 2018/12/27 15:03
 * <p>
 *
 * </p>
 */
@Service(FunctionCode.schoolList)
public class SchoolListHandler implements Handler<DefaultPageRequestBean> {

    @Autowired
    private SchoolRepository schoolRepository;

    @Override
    public BaseResponse handle(DefaultPageRequestBean request, String openId) {

        Page<School> schools = schoolRepository.findAll(
                PageRequest.of(request.getPage(), request.getSize(),
                        Sort.by(Sort.Order.desc("updTime"))));

        return ErrorCodeEnum.success.buildResponse(
                SchoolListResponseBean.builder().list(
                        BeanUtil.buildPage(schools, SchoolListResponseBean.SchoolBean.class)
                ).build());
    }
}
