package com.xin.activity.helper;

import com.xin.activity.common.ErrorCodeEnum;
import com.xin.activity.core.BizException;
import com.xin.activity.model.Student;
import com.xin.activity.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author three
 * @since 2018/12/29 11:39
 * <p>
 *
 * </p>
 */
@Component
public class StudentHelper {
    @Autowired
    private StudentRepository studentRepository;

    public Student getById(Long id) throws BizException {
        Student student = studentRepository.getOne(id);
        checkStudent(student);
        return student;
    }

    public Student getByOpenId(String openId) throws BizException {
        Student student = studentRepository.getByOpenId(openId);
        checkStudent(student);
        return student;
    }

    /**
     * 根据手机号查询是否存在，存在则抛异常
     *
     * @param mobile
     * @throws BizException
     */
    public void existsByMobile(String mobile) throws BizException {
        if (studentRepository.existsAllByMobile(mobile)) {
            ErrorCodeEnum.mobile_exist.throwException();
        }
    }

    private void checkStudent(Student student) throws BizException {
        CheckHelper.checkNull(student, ErrorCodeEnum.student_null);
    }
}
