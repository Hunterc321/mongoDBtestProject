package com.example.demoprojectmongodb.assembler;

import com.example.demoprojectmongodb.model.StudentModel;
import com.example.demoprojectmongodb.student.Student;
import com.example.demoprojectmongodb.student.StudentController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.stereotype.Component;

@Component
public class StudentModelAssembler extends RepresentationModelAssemblerSupport<Student, StudentModel> {

    public StudentModelAssembler() {
        super(StudentController.class, StudentModel.class);
    }

    @Override
    public StudentModel toModel(Student student) {
        StudentModel studentModel = instantiateModel(student);

        addSelfLink(student, studentModel);
        constructStudentModel(student, studentModel);

        return studentModel;
    }

    @Override
    public CollectionModel<StudentModel> toCollectionModel(Iterable<? extends Student> students) {
        CollectionModel<StudentModel> studentModels = super.toCollectionModel(students);

        studentModels.add(linkTo(methodOn(StudentController.class).fetchAllStudents()).withSelfRel());

        return studentModels;

    }

    private void addSelfLink(Student student, StudentModel studentModel)
    {
        studentModel.add(linkTo(
                methodOn(StudentController.class)
                        .getStudentById(student.getId()))
                .withSelfRel());
    }

    private void constructStudentModel(Student student, StudentModel studentModel)
    {
        studentModel.setId(student.getId());
        studentModel.setFirstName(student.getFirstName());
        studentModel.setLastName(student.getLastName());
        studentModel.setAddress(student.getAddress());
    }



}
