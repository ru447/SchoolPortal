package com.schoolportal.service;

import com.schoolportal.model.User;
import com.schoolportal.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(UserRepository userRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {

        // Delete all existing users
        userRepository.deleteAll();

        // ADMIN
        User admin = new User();
        admin.setUsername("admin");
        admin.setPassword(passwordEncoder.encode("admin123"));
        admin.setRole("ADMIN");
        userRepository.save(admin);

        // TEACHER
        User teacher = new User();
        teacher.setUsername("teacher");
        teacher.setPassword(passwordEncoder.encode("teacher123"));
        teacher.setRole("TEACHER");
        userRepository.save(teacher);

        // STUDENT
        User student = new User();
        student.setUsername("student");
        student.setPassword(passwordEncoder.encode("student123"));
        student.setRole("STUDENT");
        userRepository.save(student);

        System.out.println("==============================");
        System.out.println("Default users recreated");
        System.out.println("admin / admin123");
        System.out.println("teacher / teacher123");
        System.out.println("student / student123");
        System.out.println("==============================");
    }
}