package com.library.sroy.LibraryProject.controller;

import com.library.sroy.LibraryProject.model.User;
import com.library.sroy.LibraryProject.service.IssueService;
import com.library.sroy.LibraryProject.service.LibraryCardService;
import com.library.sroy.LibraryProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/library")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    LibraryCardService libraryCardService;

    @Autowired
    IssueService issueService;


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
    public User issueACardFortheUser(@PathVariable Integer userId){
       return getUserDetailsFromId(libraryCardService.issueANewCard(userId));
    }

    @GetMapping("/calculateFine/{userId}")
    public Double calculateTheFine(@PathVariable Integer userId){
        return issueService.calculateFineRate(userId);
    }
}
