package com.example.analytics.service;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Service;

@Service
public class AnalyticsService {
    @PersistenceContext
    private EntityManager entity;
    public Double getPercentageOfGraduateStudent(){
        Query query = entity.createNativeQuery(
                "SELECT COUNT(id) FROM student WHERE graduated=1;"
        );
        Object result = query.getSingleResult();
        Double numberOfGradStudent =Double.parseDouble(result.toString());
        query = entity.createNativeQuery(
                "SELECT COUNT(id) FROM student;"
        );
        result = query.getSingleResult();
        Double numberOfStudent = Double.parseDouble(result.toString());
        return (numberOfGradStudent/numberOfStudent) * 100;
    }
    public Integer getAvgAgeOfStudent(){
        Query query = entity.createNativeQuery(
                "SELECT AVG(age) FROM student;"
        );
        Object result = query.getSingleResult();
        System.out.println(result.toString());
        double avgAge = Double.parseDouble(result.toString()); // TODO: I have replaced Double with double
        return (int) avgAge;
    }
}
