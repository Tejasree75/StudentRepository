package com.example.demo;

import com.example.demo.controller.StudentController;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.Assertions.assertThat;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)

@WebMvcTest(value = StudentController.class)
public class AssessmentControllerTest {
    @Autowired
    private MockMvc mockMvc;


    @MockBean
    private StudentService studentService;

    @Test
    public void TestGetAllStudents() throws Exception {
        Student mockStudent1= new Student();
        mockStudent1.setId(6);
        mockStudent1.setName("hello");
        mockStudent1.setMarks(98);
        mockStudent1.setAge(21);

        Student mockStudent2= new Student();
        mockStudent2.setId(7);
        mockStudent2.setName("happy");
        mockStudent2.setMarks(89);
        mockStudent2.setAge(22);

        List<Student> studentList=new ArrayList<>();
        studentList.add(mockStudent1);
        studentList.add(mockStudent2);

        Mockito.when(studentService.getAllStudents()).thenReturn(studentList);
        String URI= "/test/AllStudents";
        RequestBuilder requestBuilder= MockMvcRequestBuilders.get(
                URI).accept(
                MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expectedJson= this.mapToJson(studentList);
        String outputInJson = result.getResponse().getContentAsString();
        assertThat(outputInJson).isEqualTo(expectedJson);
    }

    @Test
    public void TestGetStudentId() throws Exception{
        Student mockStudent= new Student();
        mockStudent.setId(6);
        mockStudent.setName("hello");
        mockStudent.setMarks(98);
        mockStudent.setAge(21);
        Mockito.when(studentService.getStudentId(Mockito.anyInt())).thenReturn(mockStudent);
        String URI = "/test/Student/6";
        RequestBuilder requestBuilder= MockMvcRequestBuilders.get(
                URI).accept(
                MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expectedJson= this.mapToJson(mockStudent);
        String outputInJson = result.getResponse().getContentAsString();
        assertThat(outputInJson).isEqualTo(expectedJson);
    }
    @Test
    public void TestGetStudent() throws Exception{
        Student mockStudent= new Student();
        mockStudent.setId(6);
        mockStudent.setName("hello");
        mockStudent.setMarks(98);
        mockStudent.setAge(21);
        Mockito.when(studentService.getStudent(Mockito.anyInt(),Mockito.anyString())).thenReturn(mockStudent);
        String URI = "/test/Students/6/hello";
        RequestBuilder requestBuilder= MockMvcRequestBuilders.get(
                URI).accept(
                MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expectedJson= this.mapToJson(mockStudent);
        String outputInJson = result.getResponse().getContentAsString();
        assertThat(outputInJson).isEqualTo(expectedJson);
    }
    @Test
    public void TestSaveStudent() throws Exception{
        Student mockStudent=new Student();
        mockStudent.setId(8);
        mockStudent.setName("Rama");
        mockStudent.setMarks(77);
        mockStudent.setAge(23);

        String inputInJson= this.mapToJson(mockStudent);
        Mockito.when(studentService.saveStudent(Mockito.any(Student.class))).thenReturn(mockStudent);
        String URI="/test/saveStudents";
        RequestBuilder requestBuilder= MockMvcRequestBuilders
                .post(URI)
                .accept(MediaType.APPLICATION_JSON).content(inputInJson)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response= result.getResponse();
        String outputInJson = response.getContentAsString();
        assertThat(outputInJson).isEqualTo(inputInJson);
        Assertions.assertEquals(HttpStatus.OK.value(),response.getStatus());
    }
    @Test
    public void TestDeleteStudent() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.delete("/DeleteStudent"));
    }

   @Test
    public void TestGetStudentAge() throws Exception{
        List<Student> studentList=new ArrayList<>();
        studentList.add(new Student(6,"hello",98,22));
        studentList.add(new Student(7,"hi",76,22));

        Mockito.when(studentService.getStudentAge(Mockito.anyInt())).thenReturn(studentList);
        String URI = "/test/StudentAge/22";
        RequestBuilder requestBuilder= MockMvcRequestBuilders.get(
                URI).accept(
                MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expectedJson= this.mapToJson(studentList);
        String outputInJson = result.getResponse().getContentAsString();
        assertThat(outputInJson).isEqualTo(expectedJson);
    }

    @Test
    public void TestGetStudentMarks() throws Exception{
        List<Student> studentList=new ArrayList<>();
        studentList.add(new Student(6,"hello",98,22));
        studentList.add(new Student(7,"hi",76,22));

        Mockito.when(studentService.getStudentMarks(Mockito.anyInt(),Mockito.anyInt())).thenReturn(studentList);
        String URI = "/test/StudentMarks/98/22";
        RequestBuilder requestBuilder= MockMvcRequestBuilders.get(
                URI).accept(
                MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expectedJson= this.mapToJson(studentList);
        String outputInJson = result.getResponse().getContentAsString();
        assertThat(outputInJson).isEqualTo(expectedJson);
    }


    private String mapToJson(Object object) throws JsonProcessingException{
        ObjectMapper objectMapper= new ObjectMapper();
        return objectMapper.writeValueAsString(object);
    }




}


/*mockMvc.perform(MockMvcRequestBuilders
       .get("/test/StudentMarks")
               .accept(MediaType.APPLICATION_JSON))
      .andDo(print())
               .andExpect(status().isOk())
               .andExpect(MockMvcResultMatchers.jsonPath("$.mark").value(50))
               .andExpect(MockMvcResultMatchers.jsonPath("$.age1").value(21));

*/
