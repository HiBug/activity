package com.xin.activity.handler;

import com.xin.activity.common.FunctionCode;
import com.xin.activity.core.BaseResponse;
import com.xin.activity.core.BizException;
import com.xin.activity.core.DefaultRequestBean;
import com.xin.activity.core.Handler;
import com.xin.activity.helper.MasterHelper;
import com.xin.activity.model.Master;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author three
 * @since 2018/12/29 11:36
 * <p>
 *
 * </p>
 */
@Service(FunctionCode.studentApplyList)
public class StudentApplyListHandler implements Handler<DefaultRequestBean> {
    @Autowired
    private MasterHelper masterHelper;

    @Override
    public BaseResponse handle(DefaultRequestBean request, String openId) throws BizException {
        //找到教练
        Master master = masterHelper.getMasterByOpenId(openId);

        return null;
    }
}
