package com.library.sroy.LibraryProject.service;

import com.library.sroy.LibraryProject.exception.BookNotFoundException;
import com.library.sroy.LibraryProject.model.Book;
import com.library.sroy.LibraryProject.repository.BookRepository;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book getBookDetails(Integer bookId){
        Optional<Book> book = bookRepository.findById(bookId);
        if(!book.isPresent())
            throw new BookNotFoundException("The given book is not present in the library");

        return book.get();
    }

    public boolean getIssueStatusOfBook(Integer bookId){
        Optional<Book> book = bookRepository.findById(bookId);
        if(!book.isPresent()){
            return book.get().getIssueStatus();
        }
        return false;
    }

    public String getShelfDetailsFromBookId(Integer bookId){
        Optional<Book> book = bookRepository.findById(bookId);
        if(!book.isPresent())
        {
            throw new BookNotFoundException("The given bookId="+bookId+" is not available at this library");
        }
        return book.get().getShelfNumber();
    }
}
