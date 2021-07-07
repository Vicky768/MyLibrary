package com.library.sroy.LibraryProject.controller;

import com.library.sroy.LibraryProject.model.Book;
import com.library.sroy.LibraryProject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/allBooks")
    public List<Book> getAllTheBooks()
    {
        return bookService.getAllTheBooks();
    }

    @GetMapping("/checkIssueStatus/{bookId}")
    public boolean getIssueStatus(@PathVariable Integer bookId){
        return bookService.getIssueStatusOfBook(bookId);
    }


    @GetMapping("/checkShelf/{bookId}")
    public String getShelfDetailsFromBookId(@PathVariable Integer bookId){
        return bookService.getShelfDetailsFromBookId(bookId);
    }

    @PostMapping("/addABook")
    public String addANewBook(@RequestBody Book book){
        return "The book has been added at bookId = "+bookService.addABook(book);
    }


}
