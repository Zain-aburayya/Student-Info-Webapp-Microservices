package com.example.enterdata.control;

import com.example.enterdata.model.Student;
import com.example.enterdata.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Controller
public class StudentController {
    private StudentService studentService;

    @Autowired
    public void showResultServiceController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping("/add-student")
    public String showAddStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "add-form";
    }
    @PostMapping("/add-student")
    public String addStudent(@RequestParam(required = false) String name,
                             @RequestParam(required = false) Integer age,
                             @RequestParam(value = "isGraduated", required = false) Boolean isGraduated) {
        if (StringUtils.isEmpty(name) || age == null) {
            return "add-error-form";
        }
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        isGraduated = (isGraduated != null);
        student.setGraduated(isGraduated);
        studentService.saveStudent(student);
        return "redirect:/success-add";
    }

    @GetMapping("/success-add")
    public String successfulAddingStudent() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://analytics:9090/update";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        restTemplate.exchange(url, HttpMethod.POST, entity, Void.class);
        return "success-form";
    }

}
