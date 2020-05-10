package com.steppedua.dropauto.repository;

import com.steppedua.dropauto.domain.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursesRepository extends JpaRepository<Courses, Long> {
}
