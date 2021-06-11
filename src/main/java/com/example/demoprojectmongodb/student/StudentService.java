package com.example.demoprojectmongodb.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student addNewStudent(Student student)
    {
        return studentRepository.save(student);
    }

    public Optional<Student> getStudentById(String id) {

        return studentRepository.findById(id);
    }

    public void deleteAllStudents()
    {
        studentRepository.deleteAll();
    }
}
