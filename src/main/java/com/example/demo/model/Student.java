package com.example.demo.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Student {

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "student_name")
    private String name;
    @Column(name = "student_marks")
    private int marks;
    @Column(name = "student_age")
    private int age;

    public Student() {
    }

    public Student(int id, String name, int marks, int age) {
        super();
        this.id = id;
        this.name = name;
        this.marks = marks;
        this.age = age;

    }


   /* public int getAge() {

       return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {

       return id;
    }

    public void setId(int id) {

       this.id = id;
    }

    public String getName() {

       return name;
    }

    public void setName(String name) {

       this.name = name;
    }

    public int getMarks() {

       return marks;
    }

    public void setMarks(int marks) {

       this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", marks=" + marks +
                '}';
    }*/
}
