package peaksoft.service;
import org.springframework.stereotype.Service;
import peaksoft.dto.RequestGroup;
import peaksoft.dto.RequestStudent;
import peaksoft.model.Student;
import java.util.List;
@Service
public interface StudentService {

    void saveStudent(Student student);
    void deleteStudent(long id);
    void updateStudent(Student student);
    List<Student> getAllStudents(long id);
    Student getStudentById(long id);
    Student requestStudent(RequestStudent requestStudent);
    Student getStudentByName(String studentName);
}
