package com.example.demoprojectmongodb.student;

import com.example.demoprojectmongodb.assembler.StudentModelAssembler;
import com.example.demoprojectmongodb.model.StudentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/students")
public class StudentController {

    private StudentService studentService;
    private StudentModelAssembler studentModelAssembler;

    @Autowired
    public StudentController(StudentService studentService, StudentModelAssembler studentModelAssembler) {
        this.studentService = studentService;
        this.studentModelAssembler = studentModelAssembler;
    }

    @GetMapping
    public ResponseEntity<CollectionModel<StudentModel>> fetchAllStudents()
    {
        List<Student> students = studentService.getAllStudents();

        return ResponseEntity.ok(studentModelAssembler.toCollectionModel(students));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentModel> getStudentById(@PathVariable("id") String id)
    {
        return studentService.getStudentById(id)
                .map(studentModelAssembler::toModel)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Student> addNewStudent(@RequestBody Student student)
    {
        return new ResponseEntity<>(studentService.addNewStudent(student), HttpStatus.OK);
    }

    @DeleteMapping
    public void deleteAll()
    {
        studentService.deleteAllStudents();
    }

}
