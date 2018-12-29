package com.xin.activity.repository;

import com.xin.activity.common.StudentStatus;
import com.xin.activity.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author three
 * @since 2018/12/26 23:23
 * <p>
 *
 * </p>
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Page<Student> queryByStatusAndMasterId(StudentStatus status, Long masterId, Pageable page);
}
