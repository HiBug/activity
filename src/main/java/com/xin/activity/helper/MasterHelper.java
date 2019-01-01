package com.xin.activity.helper;

import com.xin.activity.common.ErrorCodeEnum;
import com.xin.activity.core.BizException;
import com.xin.activity.model.Master;
import com.xin.activity.repository.MasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author three
 * @since 2018/12/28 14:50
 * <p>
 *
 * </p>
 */
@Component
public class MasterHelper {
    @Autowired
    private MasterRepository masterRepository;

    /**
     * 根据手机号获取教练
     *
     * @param mobile
     * @return
     * @throws BizException
     */
    public Master getMasterByMobile(String mobile) throws BizException {
        Master master = masterRepository.findByMobile(mobile);
        checkMaster(master);
        return master;
    }

    /**
     * 根据手机号查询是否存在，存在则抛异常
     *
     * @param mobile
     * @throws BizException
     */
    public void existsByMobile(String mobile) throws BizException {
        if (masterRepository.existsAllByMobile(mobile)) {
            ErrorCodeEnum.mobile_exist.throwException();
        }
    }

    public Master getMasterById(Long id) throws BizException {
        Master master = masterRepository.getOne(id);
        checkMaster(master);
        return master;
    }

    public Master getMasterByOpenId(String openId) throws BizException {
        Master master = masterRepository.findByOpenId(openId);
        checkMaster(master);
        return master;
    }

    private void checkMaster(Master master) throws BizException {
        CheckHelper.checkNull(master, ErrorCodeEnum.master_null);
    }
}
