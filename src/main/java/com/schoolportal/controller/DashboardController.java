package com.schoolportal.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/")
    public String home(Authentication authentication) {

        // If no user is logged in
        if (authentication == null || !authentication.isAuthenticated()) {
            return "redirect:/login";
        }

        // Redirect based on role
        if (authentication.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
            return "redirect:/admin";
        }

        if (authentication.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_TEACHER"))) {
            return "redirect:/teacher";
        }

        if (authentication.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_STUDENT"))) {
            return "redirect:/student";
        }

        // Fallback
        return "redirect:/login";
    }

    @GetMapping("/admin")
    public String adminDashboard() {
        return "admin/dashboard";
    }

    @GetMapping("/teacher")
    public String teacherDashboard() {
        return "teacher/dashboard";
    }

    @GetMapping("/student")
    public String studentDashboard() {
        return "student/dashboard";
    }

}