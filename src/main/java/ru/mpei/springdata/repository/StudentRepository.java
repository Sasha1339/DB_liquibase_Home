package ru.mpei.springdata.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.mpei.springdata.domain.GroupOfStudent;
import ru.mpei.springdata.domain.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

   // @EntityGraph(attributePaths = {"course"})
    @Transactional(readOnly = true)
    List<Student> findStudentByGroupOfStudent_Id(long group_id);

//    @EntityGraph(attributePaths = {"grade"})
//    @Query("select s from Student s where s.groupOfStudent =: group_id")
//    @Transactional(readOnly = true)
//    List<Student> findStudentByGroupOfStudent_Id_grade(@Param("group_id") long group_id);



    List<Student> findStudentByIdIsGreaterThan(long id);
}
