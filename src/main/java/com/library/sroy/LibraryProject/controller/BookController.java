package com.library.sroy.LibraryProject.controller;

import com.library.sroy.LibraryProject.exception.BookNotFoundException;
import com.library.sroy.LibraryProject.model.Book;
import com.library.sroy.LibraryProject.repository.BookRepository;
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
    private BookRepository bookRepo;

    @GetMapping("/{bookId}")
    public Book getBookDetailsById(@PathVariable Integer bookId)
    {
        Optional<Book> book = bookRepo.findById(bookId);
        if(!book.isPresent())
            throw new BookNotFoundException("The given book is not present in the library");

        return book.get();
    }

    @GetMapping("/checkIssueStatus/{bookId}")
    public boolean getIssueStatus(@PathVariable Integer bookId){
        Optional<Book> book = bookRepo.findById(bookId);
        if(book.isPresent())
        {
            return book.get().getIssueStatus();
        }
        return false;
    }

    @GetMapping("/checkShelf/{bookId}")
    public String getShelfDetailsFromBookId(@PathVariable Integer bookId){
        Optional<Book> book = bookRepo.findById(bookId);
        if(book.isPresent()){
            return book.get().getShelfNumber();
        }
        return null;
    }


}
