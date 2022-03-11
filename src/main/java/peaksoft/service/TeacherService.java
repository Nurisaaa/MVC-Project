package peaksoft.service;

import org.springframework.stereotype.Service;
import peaksoft.dto.TeacherRequest;
import peaksoft.model.Teacher;

import java.util.List;
@Service
public interface TeacherService {
    void saveTeacher(Teacher teacher);
    void updateTeacher(Teacher teacher);
    void deleteTeacher(long id);
    Teacher getTeacherById(long id);
    List<Teacher> getAllTeacher(long id);
    Teacher teacherRequest(TeacherRequest request);
}
