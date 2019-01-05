package com.xin.activity.repository;

import com.xin.activity.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author three
 * @since 2018/12/26 22:42
 * <p>
 *
 * </p>
 */
@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query("select course from Course course where course.masterId = :masterId" +
            " and course.startDate <= :date" +
            " and course.endDate >= :date")
    List<Course> queryByMasterIdAndDate(@Param("masterId") Long masterId, @Param("date") Date date);

    @Modifying
    void deleteById(Long id);
}
