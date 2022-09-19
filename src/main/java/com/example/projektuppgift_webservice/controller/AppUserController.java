package com.example.projektuppgift_webservice.controller;

import com.example.projektuppgift_webservice.dto.DtoRequest;
import com.example.projektuppgift_webservice.dto.DtoResponse;
import com.example.projektuppgift_webservice.services.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class AppUserController {

    @Autowired
    AppUserService appUserService;

    @PostMapping
    public DtoResponse insertUser(@RequestBody DtoRequest userDtoRequest){
        return appUserService.insertUser(userDtoRequest);
    }

    @GetMapping
    public List<DtoResponse> findAll(){
        return appUserService.findAll();
    }

    @GetMapping("/{id}")
    public DtoResponse findById(@PathVariable int id){
        return appUserService.findById(id);
    }

}
