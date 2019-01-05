package com.xin.activity.repository;

import com.xin.activity.model.CourseInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

/**
 * @author three
 * @since 2018/12/26 23:23
 * <p>
 *
 * </p>
 */
@Repository
public interface CourseInfoRepository extends JpaRepository<CourseInfo, Long> {

    @Modifying
    void deleteAllByCourseId(Long id);


}
