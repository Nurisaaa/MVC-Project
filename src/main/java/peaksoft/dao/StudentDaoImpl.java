package peaksoft.dao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.model.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
public class StudentDaoImpl implements StudentDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveStudent(Student student) {
        entityManager.merge(student);
    }

    @Override
    public void deleteStudent(long id) {
        Student student = getStudentById(id);
        if(student != null){
            entityManager.remove(student);
        }
    }

    @Override
    public void updateStudent(Student student) {
        entityManager.merge(student);
    }

    @Override
    public List<Student> getAllStudents(long id) {
        return entityManager.createQuery("SELECT s FROM Student s WHERE s.group.id=:id").setParameter("id",id).getResultList();
    }

    @Override
    public Student getStudentById(long id) {
        return entityManager.find(Student.class,id);
    }
}
