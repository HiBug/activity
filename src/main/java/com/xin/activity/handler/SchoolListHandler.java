package com.xin.activity.handler;

import com.xin.activity.common.ErrorCodeEnum;
import com.xin.activity.common.FunctionCode;
import com.xin.activity.core.BaseResponse;
import com.xin.activity.core.DefaultPageRequest;
import com.xin.activity.core.Handler;
import com.xin.activity.handler.responseBeans.SchoolListResponseBean;
import com.xin.activity.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

/**
 * @author three
 * @since 2018/12/27 15:03
 * <p>
 *
 * </p>
 */
@Service(FunctionCode.schoolList)
public class SchoolListHandler implements Handler<DefaultPageRequest> {

    @Autowired
    private SchoolRepository schoolRepository;

    @Override
    public BaseResponse handle(DefaultPageRequest request, String openId) {

        return ErrorCodeEnum.success.buildResponse(
                SchoolListResponseBean.builder().list(
                        schoolRepository.findAll(
                                PageRequest.of(request.getPage(), request.getSize(),
                                        Sort.by(Sort.Order.desc("updTime"))))
                                .stream()
                                .map(school ->
                                        SchoolListResponseBean.SchoolBean.builder()
                                                .id(school.getId())
                                                .name(school.getName())
                                                .build()
                                ).collect(Collectors.toList()))
                        .build());
    }
}
