package peaksoft.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.dao.CourseDao;
import peaksoft.dto.RequestCourse;
import peaksoft.model.Course;

import java.util.List;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    private CourseDao courseDao;

    public CourseServiceImpl(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    @Override
    public void saveCourse(Course course) {
       courseDao.saveCourse(course);
    }

    @Override
    public List<Course> getAllCourse(long id) {
        return courseDao.getAllCourse(id);
    }

    public Course getById(long id){
        return courseDao.getById(id);
    }

    @Override
    public void deleteCourse(long id) {
        courseDao.deleteCourseById(id);
    }

    @Override
    public void updateCourse(Course course) {
        courseDao.updateCourse(course);
    }

    @Override
    public Course getCourseByName(String name,long id) {
        return courseDao.getCourseByName(name,id);
    }

    @Override
    public Course courseRequest(RequestCourse requestCourse) {
        Course course = new Course();
        course.setName(requestCourse.getName());
        course.setDuration(requestCourse.getDuration());
        return course;
    }


}
