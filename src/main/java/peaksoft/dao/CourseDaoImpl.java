package peaksoft.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.model.Course;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CourseDaoImpl implements CourseDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveCourse(Course course) {
            entityManager.merge(course);
    }

    @Override
    public List<Course> getAllCourse(long id) {
        return entityManager.createQuery("SELECT c FROM Course c where c.company.id=:id", Course.class).setParameter("id", id).getResultList();
    }

    @Override
    public Course getById(long id) {
        return entityManager.find(Course.class, id);
    }

    @Override
    public void deleteCourseById(long id) {
        Course course = getById(id);
        if (course != null) {
            entityManager.remove(course);
        }
    }

    @Override
    public void updateCourse(Course course) {
        entityManager.merge(course);
    }

    @Override
    public Course getCourseByName(String name, long id) {
        return entityManager.createQuery("SELECT c FROM Course c where  c.name like: name and c.company.id=:id", Course.class).setParameter("name", name).setParameter("id",id).getSingleResult();
    }
}
