package com.library.sroy.LibraryProject.service;

import com.library.sroy.LibraryProject.exception.UserNotFoundException;
import com.library.sroy.LibraryProject.model.User;
import com.library.sroy.LibraryProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserDetails(Integer userId){
        Optional<User> user = userRepository.findById(userId);

        if(!user.isPresent())
            throw new UserNotFoundException("The given user "+userId+"is not found");

        return user.get();
    }

    public User addANewUser(User user){
         //need to add an exception
        User savedUser = userRepository.save(user);
        return savedUser;

    }
}
