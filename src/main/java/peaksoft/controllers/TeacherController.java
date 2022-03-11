package peaksoft.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import peaksoft.service.TeacherService;

@Controller
@RequestMapping("teacher/{id}")
public class TeacherController {

    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping()
    public String infoOfTeacher(Model model, @PathVariable("id") long id) {
        model.addAttribute("teacher", teacherService.getTeacherById(id));
        return "TeacherPages/teacherPage";
    }

}
