package com.example.projektuppgift_webservice.controller;

import com.example.projektuppgift_webservice.dto.LoginDto;
import com.example.projektuppgift_webservice.services.LoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/authenticate")
public class LoginController {

    private LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> authenticate(@RequestBody LoginDto loginDto){
         return loginService.authenticate(loginDto.username(), loginDto.password());
     }

}
