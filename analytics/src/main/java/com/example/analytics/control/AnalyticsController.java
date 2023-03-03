package com.example.analytics.control;

import com.example.analytics.model.Analytics;
import com.example.analytics.repository.AnalyticsRepo;
import com.example.analytics.service.AnalyticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnalyticsController {
    private AnalyticsService analyticsService;
    @Autowired
    private AnalyticsRepo analyticsRepo;

    @Autowired
    public void setAnalyticsService(AnalyticsService analyticsService){
        this.analyticsService = analyticsService;
    }

    @PostMapping(value = "/update")
    public void updateAnalytics() {
        Double percentageOfGraduateStudent = analyticsService.getPercentageOfGraduateStudent();
        Integer avgAgeOfStudent = analyticsService.getAvgAgeOfStudent();
        Analytics doc = new Analytics(percentageOfGraduateStudent, avgAgeOfStudent);
        analyticsRepo.save(doc);
    }
}