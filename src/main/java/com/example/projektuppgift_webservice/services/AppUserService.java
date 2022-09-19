package com.example.projektuppgift_webservice.services;

import com.example.projektuppgift_webservice.dto.DtoRequest;
import com.example.projektuppgift_webservice.dto.DtoResponse;
import com.example.projektuppgift_webservice.entities.AppUser;
import com.example.projektuppgift_webservice.repositories.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserService {

    @Autowired
    AppUserRepository appUserRepository;

    public DtoResponse insertUser(DtoRequest userDtoRequest) {
        
         AppUser existingAppuser  = appUserRepository.save(new AppUser(userDtoRequest.username(), userDtoRequest.password()));
         
         return new DtoResponse(existingAppuser.getId(), existingAppuser.getUsername());
    }

    public List<DtoResponse> findAll() {
        return appUserRepository.findAll()
                .stream()
                .map(appUser -> new DtoResponse(appUser.getId(), appUser.getUsername()))
                .toList();
    }

    public DtoResponse findById(int id) {
        AppUser appUser = appUserRepository.findById(id).orElseThrow();

        return new DtoResponse(appUser.getId(), appUser.getUsername());
    }

    public void deleteById(int id) {
        appUserRepository.deleteById(id);
    }

    public DtoResponse updateUserById(int id, DtoRequest dtoRequest) {

        AppUser existingAppUser = appUserRepository.findById(id).orElseThrow();

        if (dtoRequest.username() != null){
            existingAppUser.setUsername(dtoRequest.username());
        }
        if (dtoRequest.password() != null){
            existingAppUser.setPassword(dtoRequest.password());
        }

        appUserRepository.save(existingAppUser);

        return new DtoResponse(existingAppUser.getId(), existingAppUser.getUsername());
    }
}
