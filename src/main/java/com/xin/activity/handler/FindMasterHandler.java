package com.xin.activity.handler;

import com.xin.activity.common.ErrorCodeEnum;
import com.xin.activity.common.FunctionCode;
import com.xin.activity.core.BaseResponse;
import com.xin.activity.core.Handler;
import com.xin.activity.handler.requestBeans.FindMasterRequestBean;
import com.xin.activity.handler.responseBeans.FindMasterResponseBean;
import com.xin.activity.model.Master;
import com.xin.activity.repository.MasterRepository;
import com.xin.activity.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author three
 * @since 2018/12/27 16:03
 * <p>
 *
 * </p>
 */
@Service(FunctionCode.findMaster)
public class FindMasterHandler implements Handler<FindMasterRequestBean> {

    @Autowired
    private MasterRepository masterRepository;

    @Override
    public BaseResponse handle(FindMasterRequestBean request, String openId) {
        Master master = masterRepository.findByMobile(request.getMobile());

        return ErrorCodeEnum.success.buildResponse(
                master == null ? new FindMasterResponseBean() :
                        BeanUtil.buildBean(master, FindMasterResponseBean.class));
    }
}
