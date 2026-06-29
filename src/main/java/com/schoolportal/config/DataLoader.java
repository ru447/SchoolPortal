package com.schoolportal.config;

import com.schoolportal.model.User;
import com.schoolportal.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final UserRepository userRepository;

    public DataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) {

        if (userRepository.count() == 0) {

            userRepository.save(
                    new User("admin", "admin123", "ADMIN")
            );

            userRepository.save(
                    new User("teacher1", "teacher123", "TEACHER")
            );

            userRepository.save(
                    new User("student1", "student123", "STUDENT")
            );

            System.out.println("Default users created.");
        }
    }
}