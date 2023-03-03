package com.example.showresult.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Setter
@Getter
@AllArgsConstructor
public class Analytics {
    private Double percentageOfGraduateStudent;
    private Integer avgAgeOfStudent;
}
