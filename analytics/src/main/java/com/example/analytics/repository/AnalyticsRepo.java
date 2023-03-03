package com.example.analytics.repository;

import com.example.analytics.model.Analytics;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnalyticsRepo extends
        MongoRepository<Analytics, Double> {
}