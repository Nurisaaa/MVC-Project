package peaksoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.dao.StudentDao;
import peaksoft.dto.RequestStudent;
import peaksoft.model.Student;

import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao;

    @Autowired
    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public void saveStudent(Student student) {
        studentDao.saveStudent(student);
    }

    @Override
    public void deleteStudent(long id) {
        studentDao.deleteStudent(id);
    }

    @Override
    public void updateStudent(Student student) {
        studentDao.updateStudent(student);
    }

    @Override
    public List<Student> getAllStudents(long id) {
        return studentDao.getAllStudents(id);
    }

    @Override
    public Student getStudentById(long id) {
        return studentDao.getStudentById(id);
    }

    @Override
    public Student requestStudent(RequestStudent requestStudent) {
        Student student =  new Student();
        student.setFirstName(requestStudent.getFirstName());
        student.setLastName(requestStudent.getLastName());
        student.setEmail(requestStudent.getEmail());
        student.setStudyFormat(requestStudent.getStudyFormat());
        return null;
    }

    @Override
    public Student getStudentByName(String studentName) {
        return null;
    }
}
