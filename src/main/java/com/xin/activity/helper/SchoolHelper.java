package com.xin.activity.helper;

import com.xin.activity.common.ErrorCodeEnum;
import com.xin.activity.core.BizException;
import com.xin.activity.model.School;
import com.xin.activity.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author three
 * @since 2019/1/1 15:01
 * <p>
 *
 * </p>
 */
@Component
public class SchoolHelper {
    @Autowired
    private SchoolRepository schoolRepository;

    public School getById(Long id) throws BizException {
        School school = schoolRepository.getOne(id);
        checkSchool(school);
        return school;
    }

    private void checkSchool(School school) throws BizException {
        CheckHelper.checkNull(school, ErrorCodeEnum.school_null);
    }
}
