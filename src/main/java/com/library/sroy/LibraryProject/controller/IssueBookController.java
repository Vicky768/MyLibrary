package com.library.sroy.LibraryProject.controller;

import com.library.sroy.LibraryProject.model.LibraryCard;
import com.library.sroy.LibraryProject.service.IssueService;
import com.library.sroy.LibraryProject.service.LibraryCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/library/issue")
public class IssueBookController {

    @Autowired
    private IssueService issueService;

    @Autowired
    private LibraryCardService libraryCardService;

    @GetMapping("/issueABook/{userId}/{bookId}")
    @ResponseBody
    public LibraryCard issueTheBookTotheUser(@PathVariable Integer userId, @PathVariable Integer bookId){
        Integer libCardId =  issueService.issueTheBookToTheUser(userId,bookId);
        return libraryCardService.getDetailsOfLibraryCardFromCardId(libCardId);
    }
}
