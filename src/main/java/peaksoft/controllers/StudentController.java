package peaksoft.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.model.Student;
import peaksoft.service.GroupService;
import peaksoft.service.StudentService;

@Controller
@RequestMapping("students/{id}")
public class StudentController {

    private final StudentService studentService;
    private final GroupService groupService;

    @Autowired
    public StudentController(StudentService studentService, GroupService groupService) {
        this.studentService = studentService;
        this.groupService = groupService;
    }

    @GetMapping
    public String getAllStudents(Model model, @PathVariable("id") long id) {
        model.addAttribute("students", studentService.getAllStudents(id));
        model.addAttribute("groupId", id);
        return "StudentPages/StudentPage";
    }

    @GetMapping("/newStudent")
    public String addCourses(Model model) {
        model.addAttribute("student", new Student());
        return "StudentPages/newStudent";
    }

    @PostMapping("/saveStudent")
    public String saveCourses(@ModelAttribute("student") Student student, @PathVariable("id") long id) {
        student.setGroup(groupService.getById(id));
        studentService.saveStudent(student);
        return "redirect:/students/{id}";

    }

    @DeleteMapping("{id2}/deleteStudent")
    public String deleteStudent(@PathVariable("id2") long id1) {
        studentService.deleteStudent(id1);
        return "redirect:/students/{id}";
    }

    @GetMapping("/editStudent/{id1}")
    public String editCompany(Model model, @PathVariable("id1") long id, @PathVariable("id") long id1) {
        model.addAttribute("groupId",id1);
        model.addAttribute("student", studentService.getStudentById(id));
        return "StudentPages/editStudent";
    }

    @PatchMapping("/mergeStudent/{id1}")
    public String updateCompany(@ModelAttribute("student") Student student, @PathVariable("id1") long id) {
        student.setGroup(groupService.getById(id));
        studentService.updateStudent(student);
        return "redirect:/students/{id}";
    }

    public String getStudentByName(@ModelAttribute("studentName") String name,Model model){

        return "";
    }
}
