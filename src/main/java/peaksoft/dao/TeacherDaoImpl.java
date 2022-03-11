package peaksoft.dao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.model.Course;
import peaksoft.model.Teacher;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class TeacherDaoImpl implements TeacherDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveTeacher(Teacher teacher) {
            entityManager.merge(teacher);
    }

    @Override
    public void updateTeacher(Teacher teacher) {
         entityManager.merge(teacher);
    }

    @Override
    public void deleteTeacher(long id) {
            entityManager.remove(entityManager.find(Teacher.class,id));

    }

    @Override
    public Teacher getTeacherById(long id) {
        return entityManager.find(Teacher.class,id);
    }

    @Override
    public List<Teacher> getAllTeacher(long id) {
        return entityManager.createQuery("SELECT t FROM Teacher t WHERE t.company.id =:id").setParameter("id",id).getResultList();
    }
}
