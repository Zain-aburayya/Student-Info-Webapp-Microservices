package com.example.showresult.service;

import com.example.showresult.model.Analytics;
import com.example.showresult.repository.AnalyticsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnalyticsService {

    @Autowired
    private AnalyticsRepo analyticsRepo;

    public List<Analytics> getAnalysisData(){
        return analyticsRepo.findAll();
    }
}