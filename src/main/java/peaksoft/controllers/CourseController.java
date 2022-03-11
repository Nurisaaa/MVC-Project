package peaksoft.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.dto.RequestCourse;
import peaksoft.dto.RequestGroup;
import peaksoft.dto.TeacherRequest;
import peaksoft.model.Course;
import peaksoft.model.Group;
import peaksoft.model.Teacher;
import peaksoft.service.CompanyService;
import peaksoft.service.CourseService;
import peaksoft.service.GroupService;
import peaksoft.service.TeacherService;

@Controller
@RequestMapping("/courses/{id}")
public class CourseController {

    private final CourseService courseService;
    private final CompanyService companyService;
    private final GroupService groupService;
    private final TeacherService teacherService;

    @Autowired
    public CourseController(CourseService courseService, CompanyService companyService, GroupService groupService, TeacherService teacherService) {
        this.companyService = companyService;
        this.courseService = courseService;
        this.groupService = groupService;
        this.teacherService = teacherService;
    }

    @GetMapping()
    public String coursesOfCompany(@PathVariable("id") long id, Model model) {
        model.addAttribute("courses", courseService.getAllCourse(id));
        model.addAttribute("companyId", id);
        model.addAttribute("groups", groupService.getGroupByCompanyById(id));
        model.addAttribute("teachers", teacherService.getAllTeacher(id));
        return "CoursePages/coursePage";
    }


    @GetMapping("/new")
    public String addCourses(Model model) {
        model.addAttribute("course", new Course());
        return "CoursePages/newCourse";
    }

    @PostMapping("/saveCourse")
    public String saveCourses(@ModelAttribute("course") RequestCourse requestCourse, @PathVariable("id") long id) {
        Course course = courseService.courseRequest(requestCourse);
        course.setCompany(companyService.getCompanyById(id));
        courseService.saveCourse(course);
        return "redirect:/courses/{id}";
    }

    @DeleteMapping("{id1}/delete")
    public String deleteCourse(@PathVariable("id1") long id1) {
        courseService.deleteCourse(id1);
        return "redirect:/courses/{id}";
    }


    @GetMapping("{id2}/editCourse")
    public String updateCourse(Model model, @PathVariable("id2") long id, @PathVariable("id") long id1) {
        model.addAttribute("course", courseService.getById(id));
        model.addAttribute("IdCompany", id1);
        return "CoursePages/editCourse";
    }

    @PatchMapping("/merge/{id3}")
    public String mergeCourse(@ModelAttribute("course") Course course, @PathVariable("id3") long id) {
        course.setCompany(courseService.getById(id).getCompany());
        courseService.updateCourse(course);
        return "redirect:/courses/{id}";
    }

    @GetMapping("/newGroup")
    public String newGroup(Model model) {
        Group group = new Group();
        model.addAttribute("newGroup", group);
        model.addAttribute("courseName", group.getCourseName());
        return "GroupPages/newGroup";
    }

    @PostMapping("/saveGroup")
    public String saveGroup(@ModelAttribute("newGroup") RequestGroup requestGroup, @ModelAttribute("courseName") String name, @PathVariable("id") long id) {
        Group group = groupService.groupRequest(requestGroup);
        group.setCompany(companyService.getCompanyById(id));
        group.setCourses(courseService.getCourseByName(name,id));
        groupService.saveGroup(group);
        return "redirect:/courses/{id}";
    }

    @DeleteMapping("{idGr}/deleteGroup")
    public String deleteGroup(@PathVariable("idGr") long id) {
        groupService.deleteGroup(id);
        return "redirect:/courses/{id}";
    }

    @GetMapping("{id2}/editGroup")
    public String updateGroup(Model model, @PathVariable("id2") long id, @PathVariable("id") long id1) {
        model.addAttribute("group", groupService.getById(id));
        model.addAttribute("IdCompany", id1);
        return "GroupPages/editGroup";
    }

    @PatchMapping("/mergeGr/{id3}")
    public String mergeGroup(@ModelAttribute("group") Group group, @PathVariable("id3") long id) {
        group.setCompany(groupService.getById(id).getCompany());
        groupService.updateGroup(group);
        return "redirect:/courses/{id}";
    }

    @GetMapping("/newTeacher")
    public String newTeacher(Model model) {
        Teacher teacher = new Teacher();
        model.addAttribute("newTeacher", teacher);
        model.addAttribute("courseName", teacher.getCourseName());
        return "TeacherPages/newTeacer";
    }

    @PostMapping("/saveTeacher")
    public String saveTeacher(@ModelAttribute("newTeacher") TeacherRequest teacherRequest, @PathVariable("id") long id, @ModelAttribute("courseName") String courseName) throws Exception {
        if (courseService.getCourseByName(courseName,id).getTeacher() == null) {
            Teacher teacher = teacherService.teacherRequest(teacherRequest);
            teacher.setCompany(companyService.getCompanyById(id));
            teacher.setCourse(courseService.getCourseByName(courseName,id));
            teacherService.saveTeacher(teacher);
        } else {
            throw new Exception();
        }
        return "redirect:/courses/{id}";
    }

    @DeleteMapping("{idTc}/deleteTeacher")
    public String deleteTeacher(@PathVariable("idTc") long id) {
        teacherService.deleteTeacher(id);
        return "redirect:/courses/{id}";
    }

    @GetMapping("/editTeacher/{id2}")
    public String updateTeacher(Model model, @PathVariable("id2") long id, @PathVariable("id") long id1) {
        model.addAttribute("teacher", teacherService.getTeacherById(id));
        model.addAttribute("IdCompany", id1);
        model.addAttribute("courseName",teacherService.getTeacherById(id).getCourseName());
        return "TeacherPages/editTeacher";
    }

    @PatchMapping("/mergeTc/{id3}")
    public String mergeTeacher(@ModelAttribute("teacher") Teacher teacher, @PathVariable("id3") long id, @PathVariable("id") long id1,@ModelAttribute("courseName") String  name) throws Exception {
        if (teacher.getCourse() == null) {
            teacher.setCompany(teacherService.getTeacherById(id).getCompany());
            teacher.setCourse(courseService.getCourseByName(name,id1));
            teacherService.updateTeacher(teacher);
        } else {
            throw new Exception();
        }
        return "redirect:/courses/{id}";

    }

}
