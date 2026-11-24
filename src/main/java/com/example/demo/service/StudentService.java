package com.example.demo.service;

import com.example.demo.exception.StudentNotFoundException;
import com.example.demo.repository.StudentRepository;
import com.example.demo.dto.StudentResponse;
import com.example.demo.entity.Student;

import org.springframework.stereotype.Service;


import java.util.List;


@Service 
public class StudentService {
    private final StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
        
    }
    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }

    public StudentResponse getStudentResponse(Long id){
        Student student = studentRepository.findById(id).orElseThrow(()->
         //new RuntimeException("Student not found"));
        new StudentNotFoundException("Student not found"));
        return new StudentResponse(student.getName(),student.getSkill());
    }
}
