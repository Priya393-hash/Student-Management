package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Student;


public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByName(String name);
    List<Student> findByNameAndSkill(String name, String skil);
    List<Student> findBySkill(String skill);
    List<Student> findByAgeGreaterThan(int age);
    List<Student> findByAgeGreaterThanEqual(int age);
    List<Student> findByAgeLessThan(int age);
    List<Student> findByAgeLessThanEqual(int age);
    List<Student> findByNameContaining(String name);
    List<Student> findByAgeBetween(int minAge, int maxAge);
}
