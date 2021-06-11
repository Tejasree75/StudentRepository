package com.example.demo;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepo;
import com.example.demo.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import java.util.stream.Collectors;

import static org.mockito.Mockito.times;
import static java.util.stream.Stream.of;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AssessmentApplicationTests {

	@Autowired
	private StudentService studentService;

	@MockBean
	private StudentRepo repo;

	@Test
	public void getAge(){
		Student s= new Student(6,"hello",89,25);
		assertEquals(25,s.getAge());
	}
	@Test
	public void getAllStudentsTest() {
		Mockito.when(repo.findAll()).thenReturn(of(new Student(6, "hello", 89, 25)).collect(Collectors.toList()));
		assertEquals(1, studentService.getAllStudents().size());
	}
	@Test
	public void getStudentIdTest(){
		int id=8;
		Student s=new Student(8,"hello",89,25);
		Mockito.when(repo.findById(id)).thenReturn(Optional.<Student>of(s));
		assertEquals(8,studentService.getStudentId(id).getId());
	}
	@Test
	public void getStudentTest(){
		String name="hello";
		int id=8;
		Student s=new Student(8,"hello",89,25);
		Mockito.when(repo.findByIdAndName(id,name)).thenReturn(Optional.<Student>of(s));
		assertEquals(8,studentService.getStudent(id,name).getId());
		assertEquals("hello",studentService.getStudent(id,name).getName());
	}
	@Test
	public void getStudentMarksTest(){
		int marks= 50;
		int age= 21;
		Mockito.when(repo.findByMarksGreaterThanAndAgeGreaterThan(marks,age)).thenReturn(of(new Student(6, "hello", 50, 21),
				new Student(10,"woow",59,22)).collect(Collectors.toList()));
		assertEquals(new Student(10,"woow",59,22),studentService.getStudentMarks(marks,age).get(1));
		assertEquals(new Student(10,"woow",59,22),studentService.getStudentMarks(marks,age).get(1));

	}
	@Test
	public void getStudentAgeTest(){
		Mockito.when(repo.findByAgeSorted(22)).thenReturn(of(new Student(11,"Bharat",99,21),
				new Student(12,"Indian",100,22),
				new Student(13,"Aspirant",98,22)).collect(Collectors.toList()));
		assertEquals(3,studentService.getStudentAge(22).size());
	}
	@Test
	public void saveStudentTest(){
		Student student= new Student(13,"Pragnya",98,21);
		Mockito.when(repo.save(student)).thenReturn(student);
		Student Created=studentService.saveStudent(student);
		assertThat(Created.getName()).isSameAs(student.getName());
		//assertEquals(student,studentService.saveStudent(student));
	}
	@Test
	public void deleteStudentTest(){
		Student s=new Student(13,"Pragnya",98,21);
		studentService.deleteStudent(s);
		Mockito.verify(repo,times(1)).delete(s);
		//assertThat(repo.findById(13).get().getId());
	}
	@Test
	public void getIdTest(){
		Student s= new Student(6,"hello",89,25);
		assertEquals(6,s.getId());
	}
	@Test
	public void getNameTest(){
		Student s= new Student(6,"hello",89,25);
		assertEquals("hello",s.getName());
	}
	@Test
	public void getAgeTest(){
		Student s= new Student(6,"hello",89,25);
		assertEquals(25,s.getAge());
	}




}
