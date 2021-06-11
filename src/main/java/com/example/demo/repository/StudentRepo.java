package com.example.demo.repository;
import com.example.demo.model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//@EnableJpaRepositories
@Repository

public interface StudentRepo extends CrudRepository<Student,Integer>
{
   //List<Student> findAll();
    //Student findById(int id);

    Optional<Student> findByIdAndName(int id, String name);
    List<Student> findByMarksGreaterThanAndAgeGreaterThan(int marks,int age);

    @Query("from Student where age=?1 order by name")
    List <Student> findByAgeSorted(int age);

}

