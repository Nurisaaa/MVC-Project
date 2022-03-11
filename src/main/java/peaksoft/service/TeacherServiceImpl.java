package peaksoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.dao.TeacherDao;
import peaksoft.dto.TeacherRequest;
import peaksoft.model.Teacher;

import java.util.List;
@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {

    private TeacherDao teacherDao;

    @Autowired
    public TeacherServiceImpl(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    @Override
    public void saveTeacher(Teacher teacher) {
        teacherDao.saveTeacher(teacher);
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        teacherDao.updateTeacher(teacher);
    }

    @Override
    public void deleteTeacher(long id) {
        teacherDao.deleteTeacher(id);
    }

    @Override
    public Teacher getTeacherById(long id) {
        return teacherDao.getTeacherById(id);
    }

    @Override
    public List<Teacher> getAllTeacher(long id) {
        return teacherDao.getAllTeacher(id);
    }

    @Override
    public Teacher teacherRequest(TeacherRequest request) {
        Teacher teacher = new Teacher();
        teacher.setFirstName(request.getFirstName());
        teacher.setLastName(request.getLastName());
        teacher.setEmail(request.getEmail());
        return teacher;
    }


}
