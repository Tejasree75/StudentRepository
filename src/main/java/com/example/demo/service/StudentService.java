package com.example.demo.service;

import com.example.demo.repository.StudentRepo;
import com.example.demo.model.Student;
import com.example.demo.exception.ErrorCode;
import com.example.demo.exception.NoStudentFoundException;
import com.example.demo.exception.StudentMatchNotFoundException;
import com.example.demo.exception.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    public int mark = 58;
    public int age1 = 20;
    @Value("${my.age}")
    public int age;

    @Autowired
    StudentRepo repo;

    public Student saveStudent(Student student) {
        System.out.println(student);
        return repo.save(student);
    }

    public List<Student> getAllStudents() {
        List<Student> studentList = new ArrayList<Student>();
        studentList = (List<Student>) repo.findAll();
        System.out.println(studentList);
        if (studentList.isEmpty()) {
            throw new NoStudentFoundException(ErrorCode.NO_STUDENT_FOUND);// System.out.println(studentList.toString());
        }
        return studentList;
    }

    public Student getStudentId(int id) {

        return repo.findById(id).orElseThrow(() -> new StudentNotFoundException(ErrorCode.STUDENT_NOT_FOUND, id));
    }

    public Student getStudent(int id, String name) {
        return repo.findByIdAndName(id, name).orElseThrow(() -> new StudentMatchNotFoundException(ErrorCode.STUDENT_MATCH_NOT_FOUND, id, name));
    }

    public String deleteStudent(Student student) {
        repo.delete(student);
        //System.out.println(getAllStudents());
        return "deleted";

    }

    public List<Student> getStudentMarks(int mark, int age1) {
        return repo.findByMarksGreaterThanAndAgeGreaterThan(mark, age1);
    }

    public List<Student> getStudentAge(int age) {
        System.out.println(age);
        return repo.findByAgeSorted(22);
    }

}




   /* static List<Student> stud = new ArrayList<Student>();

    static {

        stud.add(new Student(1, "teja", 50, 22));
        stud.add(new Student(2, "John", 75, 21));
        stud.add(new Student(3, "Kushi", 80, 22));
        stud.add(new Student(4, "Magnet", 89, 21));
        stud.add(new Student(5, "Taj", 85, 22));

    }*/

   /* public List<Student> getAllStudents() {
        return stud;
        //return repo.findAll();
    }*/

   /* public Student getById(int id) {
        // return repo.findById(id);
        for (Student student : stud) {
            if (student.getId()== id) {
                return student;
            }
        }
        return null;
    }*/


