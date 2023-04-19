package ru.mpei.springdata.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.transaction.annotation.Transactional;
import ru.mpei.springdata.domain.Course;
import ru.mpei.springdata.domain.GroupOfStudent;
import ru.mpei.springdata.domain.Student;
import ru.mpei.springdata.repository.CourseRepository;
import ru.mpei.springdata.repository.GroupRepository;
import ru.mpei.springdata.repository.StudentRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
@org.springframework.stereotype.Service
@AllArgsConstructor
public class Service {
    private final StudentRepository studentRepository;

    private final CourseRepository courseRepository;

    private final GroupRepository groupRepository;
    public List<Course> findAllCourse(){
        return courseRepository.findAll();
    }
    public long findGroupIDByName(String name_group){
        return groupRepository.findGroupOfStudentByName(name_group).get(0).getId();
    }


    public List<Student> findStudentByGroup_Id(long group_id){
        return studentRepository.findStudentByGroupOfStudent_Id(group_id);
    }



    public String formatResult(String name_group){
        Map<String, Float> result = findAverageGradeByCourse(name_group);
        String record = "\n"+"В группе "+String.valueOf(name_group)+" следующие средние баллы по курсам: \n";
        for(String key: result.keySet()){
            if (!Float.isNaN(result.get(key))) {
                record += String.valueOf(key)+": "+String.valueOf(result.get(key))+"\n";
            }
        }
        return record;
    }

    public Map<String, Float> findAverageGradeByCourse(String name_group){
        Map<String, Float> result = new HashMap<>();
        List<Student> stud = new ArrayList<>();
        long group_id = findGroupIDByName(name_group);
        List<Course> courses = findAllCourse();
        int sum;
        int count;
        List<Student> students = findStudentByGroup_Id(group_id);

        for (Course course: courses){
            sum = 0;
            count = 0;
            for(Student student: students){
                for(int i = 0; i < student.getCourse().size(); i++){
                    if (student.getCourse().get(i).getName() == course.getName()){
                        sum += student.getGrade().get(i).getGrade();
                        count++;
                    }
                }

            }
            result.put(String.valueOf(course.getName()), (float)sum/(float)count);
        }
        return result;
    }


}
