package ru.mpei.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mpei.springdata.domain.Course;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findCourseByIdIsGreaterThan(long id);
}
