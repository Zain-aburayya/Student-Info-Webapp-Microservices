package com.example.showresult.repository;

import com.example.showresult.model.Analytics;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnalyticsRepo extends
        MongoRepository <Analytics,Double> {
}
