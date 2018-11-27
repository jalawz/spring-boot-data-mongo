package com.apress.demo;

import com.apress.demo.domain.User;
import com.apress.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootDataMongoApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDataMongoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        userRepository.save(new User("2", "Robert", "robert@gmail.com", false));
        userRepository.save(new User("3", "Dan", "dan@gmail.com", true));
    }
}
