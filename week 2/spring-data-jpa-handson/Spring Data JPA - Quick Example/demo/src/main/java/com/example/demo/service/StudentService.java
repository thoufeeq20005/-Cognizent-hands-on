package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements CommandLineRunner {

    @Autowired
    StudentRepository repository;

    @Override
    public void run(String... args) {

        Student s1 = new Student("Afzal",21);

        repository.save(s1);

        System.out.println("Student Saved");
    }
}
