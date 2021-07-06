package com.library.sroy.LibraryProject.controller;

import com.library.sroy.LibraryProject.exception.LibraryCardNotFoundException;
import com.library.sroy.LibraryProject.model.LibraryCard;
import com.library.sroy.LibraryProject.repository.LibraryCardRepository;
import com.library.sroy.LibraryProject.service.LibraryCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/library/card")
public class LibraryCardController {

    @Autowired
    private LibraryCardService libraryCardService;


    @GetMapping("/{cardId}")
    public LibraryCard getCardDetails(@PathVariable Integer cardId){
        return libraryCardService.getDetailsOfLibraryCardFromCardId(cardId);
    }
}
