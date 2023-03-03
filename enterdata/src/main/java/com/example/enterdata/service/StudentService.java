package com.example.enterdata.service;

import com.example.enterdata.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.enterdata.model.Student;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepository;

    public void saveStudent(Student student){
        studentRepository.save(student);
    }
}