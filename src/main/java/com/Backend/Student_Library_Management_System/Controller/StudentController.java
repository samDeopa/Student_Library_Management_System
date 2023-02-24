package com.Backend.Student_Library_Management_System.Controller;

import com.Backend.Student_Library_Management_System.Models.Student;
import com.Backend.Student_Library_Management_System.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/add")
    public  String addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @GetMapping("/get")
    public String getStudent(@RequestParam(name = "id") int id){
        return  studentService.getStudent(id).getName();

    }

}
