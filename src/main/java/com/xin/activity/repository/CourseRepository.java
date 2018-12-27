package com.xin.activity.repository;

import com.xin.activity.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author three
 * @since 2018/12/26 22:42
 * <p>
 *
 * </p>
 */
@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
