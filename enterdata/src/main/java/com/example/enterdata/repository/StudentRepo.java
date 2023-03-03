package com.example.enterdata.repository;

import com.example.enterdata.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends
        JpaRepository<Student, Integer> {
}
