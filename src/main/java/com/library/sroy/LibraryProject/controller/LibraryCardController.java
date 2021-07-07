package com.library.sroy.LibraryProject.controller;

import com.library.sroy.LibraryProject.model.LibraryCard;
import com.library.sroy.LibraryProject.service.LibraryCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
