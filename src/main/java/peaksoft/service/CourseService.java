package peaksoft.service;

import org.springframework.stereotype.Service;
import peaksoft.dto.RequestCourse;
import peaksoft.model.Course;

import java.util.List;

@Service
public interface CourseService {
    void saveCourse(Course course);
    List<Course> getAllCourse(long id);
    Course getById(long id);
    void deleteCourse(long id);
    void updateCourse(Course course);
    Course getCourseByName(String name,long id);
    Course courseRequest(RequestCourse requestCourse);
}
