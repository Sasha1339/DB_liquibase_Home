package ru.mpei.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.mpei.springdata.domain.GroupOfStudent;

import java.util.List;

public interface GroupRepository extends JpaRepository<GroupOfStudent, Long> {
//    @Transactional(readOnly = true)
//    @Query("select g.id from GroupOfStudent g where g.name = :name")
//    List<GroupOfStudent> findIdbyName(@Param("name") String name);

    List<GroupOfStudent> findGroupOfStudentByName(String name);
}
