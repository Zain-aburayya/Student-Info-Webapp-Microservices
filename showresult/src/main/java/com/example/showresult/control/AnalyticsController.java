package com.example.showresult.control;


import com.example.showresult.model.Analytics;
import com.example.showresult.service.AnalyticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AnalyticsController {

    @Autowired
    private AnalyticsService analyticsService;

    @GetMapping("/result")
    public String getAllResult(Model model){
        List<Analytics> analytics = analyticsService.getAnalysisData();
        model.addAttribute("analytics" , analytics);
        return "result-form";
    }
}
