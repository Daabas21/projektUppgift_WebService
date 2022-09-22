package com.example.projektuppgift_webservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public ResponseEntity<String> authenticate(String username, String password) {

        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);

            if (passwordEncoder.matches(password, userDetails.getPassword())) {
                return ResponseEntity.ok(jwtUtils.generateToken(username));
            } else {
                return ResponseEntity.status(401).body("password incorrect");
            }
        }catch (Exception e){
            return ResponseEntity.status(401).body("Can't find this username");
        }

    }

}
