package peaksoft.dao;

import peaksoft.model.Teacher;

import java.util.List;

public interface TeacherDao {
    void saveTeacher(Teacher teacher);
    void updateTeacher(Teacher teacher);
    void deleteTeacher(long id);
    Teacher getTeacherById(long id);
    List<Teacher> getAllTeacher(long id);

}
