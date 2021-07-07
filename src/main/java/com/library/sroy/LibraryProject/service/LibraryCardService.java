package com.library.sroy.LibraryProject.service;

import com.library.sroy.LibraryProject.exception.CardAlreadyPresentException;
import com.library.sroy.LibraryProject.exception.LibraryCardNotFoundException;
import com.library.sroy.LibraryProject.exception.UserNotFoundException;
import com.library.sroy.LibraryProject.model.LibraryCard;
import com.library.sroy.LibraryProject.model.User;
import com.library.sroy.LibraryProject.repository.LibraryCardRepository;
import com.library.sroy.LibraryProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LibraryCardService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    LibraryCardRepository libraryCardRepository;

    public LibraryCard getDetailsOfLibraryCardFromCardId(Integer cardId){
        Optional<LibraryCard> LibCardOptional = libraryCardRepository.findById(cardId);
        if(!LibCardOptional.isPresent())
        {
            throw new LibraryCardNotFoundException("The given card "+cardId+"has not been issued");
        }
        return LibCardOptional.get();
    }


    public Integer issueANewCard(Integer userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (!userOptional.isPresent()) {
            throw new UserNotFoundException("The given user of " + userId + "is not present");
        }

        User user = userOptional.get();

        if (user.getCard() != null) {
            throw new CardAlreadyPresentException("The given user already has a card assigned");
        }
        LibraryCard newLibraryCard = new LibraryCard();
        //newLibraryCard.setCardId(userId);
        libraryCardRepository.save(newLibraryCard);
        //Temporary Solution
        user.setCard(newLibraryCard);
        userRepository.save(user);

        return user.getUserId();
    }
}
