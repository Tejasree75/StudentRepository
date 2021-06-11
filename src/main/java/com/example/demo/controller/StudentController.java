package com.example.demo.controller;

import com.example.demo.service.StudentService;
import com.example.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/AllStudents")
    public @ResponseBody List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }
    @GetMapping("/Student/{id}")
    public @ResponseBody
    Student getStudentId(@PathVariable("id") int id) {

        return studentService.getStudentId(id);
    }

    @GetMapping("/Students/{id}/{name}")
    public @ResponseBody
    Student getStudent(@PathVariable("id") int id, @PathVariable("name") String name) {
        return studentService.getStudent(id, name);
    }
    @PostMapping("/saveStudents")
    public @ResponseBody
    Student saveStudent(Student student) {

        return studentService.saveStudent(student);
    }

    @GetMapping("/DeleteStudent")
    public @ResponseBody
    String deleteStudent(Student student) {

        return studentService.deleteStudent(student);
    }

    @GetMapping("/StudentMarks/{mark}/{age1}")
    public @ResponseBody
    List<Student> getStudentMarks(@PathVariable("mark")int mark,@PathVariable("age1")int age1) {

        return studentService.getStudentMarks(mark,age1);
    }


    @GetMapping("/StudentAge/{age}")
    public @ResponseBody
    List<Student> getStudentAge(@PathVariable("age") int age) {

        return studentService.getStudentAge(age);
    }



}
