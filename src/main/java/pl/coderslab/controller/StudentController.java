package pl.coderslab.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.model.Person;
import pl.coderslab.model.Student;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Controller
public class StudentController {

    @GetMapping("student")
    public String studnetForm(Model model){
        model.addAttribute("student", new Student());
        return "studentForm";
    }


    @PostMapping("student")
    @ResponseBody
    public String handleStudentForm(@ModelAttribute("student") Student student){
        log.info("New Person {}", student);
        return student.toString();
    }


    @ModelAttribute("programmingSkills")
    public List<String> programmingSkills() {
        return Arrays.asList("1java", "2java", "3java", "4java", "5java");
    }

    @ModelAttribute("hobbies")
    public List<String> hobbies() {
        return Arrays.asList("1test", "test", "test", "test", "test");
    }

    @ModelAttribute("countries")
    public List<String> countries() {
        return Arrays.asList("Poland", "Germany", "France", "Russia", "Denmark");
    }


}
