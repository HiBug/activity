package com.xin.activity.repository;

import com.xin.activity.model.School;
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
public interface SchoolRepository extends JpaRepository<School, Long> {


}
