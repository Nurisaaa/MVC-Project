package peaksoft.dao;
import peaksoft.model.Course;
import peaksoft.model.Group;

import java.util.List;

public interface CourseDao {
    void saveCourse(Course course);
    List<Course> getAllCourse(long id);
    Course getById(long id);
    void deleteCourseById(long id);
    void updateCourse(Course course);
    Course getCourseByName(String name, long id);
}
