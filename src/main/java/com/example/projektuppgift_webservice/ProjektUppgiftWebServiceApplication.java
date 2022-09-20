package com.example.projektuppgift_webservice;

import com.example.projektuppgift_webservice.entities.AppUser;
import com.example.projektuppgift_webservice.repositories.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ProjektUppgiftWebServiceApplication implements CommandLineRunner {

    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(ProjektUppgiftWebServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        appUserRepository.save(new AppUser("hassan",passwordEncoder.encode("pass!")));
        appUserRepository.save(new AppUser("ali", passwordEncoder.encode("password?")));
    }
}
