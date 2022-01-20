package com.javaWithSpringCourse.smsBoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by sailesh on 1/18/22.
 */
@Controller
public class HomeController {

    @GetMapping("/")
    public String getHomePage() {
        return "redirect:/dashboard";
    }

    @GetMapping("/dashboard")
    public String getDashboardPage() {
        return "dashboard";
    }
}


