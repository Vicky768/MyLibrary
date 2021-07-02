package com.library.sroy.LibraryProject.controller;

import com.library.sroy.LibraryProject.model.User;
import com.library.sroy.LibraryProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/library/user")
public class UserController {

    @Autowired
    UserRepository userRepo;

    @GetMapping("/{userId}")
    public Integer getUserDetailsFromId(@PathVariable Integer userId){
           // User user = userRepo.getById(userId);
            return userId;
    }


}
