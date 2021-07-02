package com.library.sroy.LibraryProject.controller;

import com.library.sroy.LibraryProject.model.User;
import com.library.sroy.LibraryProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/library/user")
public class UserController {

    @Autowired
    UserRepository userRepo;

    @GetMapping("/{userId}")
    public User getUserDetailsFromId(@PathVariable Integer userId){
           Optional<User> user = userRepo.findById(userId);
           if(user.isPresent())
               return user.get();
           return null;
    }


}
