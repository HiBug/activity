package com.xin.activity.helper;

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

    public Master getCheckedMasterByMobile(String mobile) {

        return null;
    }
}
