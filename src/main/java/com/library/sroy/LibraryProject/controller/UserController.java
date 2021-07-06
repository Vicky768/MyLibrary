package com.library.sroy.LibraryProject.controller;

import com.library.sroy.LibraryProject.model.User;
import com.library.sroy.LibraryProject.service.LibraryCardService;
import com.library.sroy.LibraryProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/library")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    LibraryCardService libraryCardService;


    @GetMapping("/user/{userId}")
    public User getUserDetailsFromId(@PathVariable Integer userId){
        return userService.getUserDetails(userId);
    }

    @PostMapping("/addUser")
    public ResponseEntity addUserDetails(@RequestBody User user){

        User savedUser = userService.addANewUser(user);
        URI location = ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/id")
                        .buildAndExpand(savedUser.getUserId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/issueACard/{userId}")
    public String issueACardFortheUser(@PathVariable Integer userId){
        return "The card of id="+libraryCardService.issueANewCard(userId)+" has been successfully issued";

    }
}
