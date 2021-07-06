package com.library.sroy.LibraryProject.controller;

import com.library.sroy.LibraryProject.model.Book;
import com.library.sroy.LibraryProject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/library/book/")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/{bookId}")
    public Book getBookDetailsById(@PathVariable Integer bookId)
    {
        return bookService.getBookDetails(bookId);
    }

    @GetMapping("/checkIssueStatus/{bookId}")
    public boolean getIssueStatus(@PathVariable Integer bookId){
        return bookService.getIssueStatusOfBook(bookId);
    }


    @GetMapping("/checkShelf/{bookId}")
    public String getShelfDetailsFromBookId(@PathVariable Integer bookId){
        return bookService.getShelfDetailsFromBookId(bookId);
    }


}
