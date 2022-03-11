package peaksoft.dao;

import peaksoft.model.Student;

import java.util.List;

public interface StudentDao {
    void saveStudent(Student student);
    void deleteStudent(long id);
    void updateStudent(Student student);
    List<Student> getAllStudents(long id);
    Student getStudentById(long id);
}
