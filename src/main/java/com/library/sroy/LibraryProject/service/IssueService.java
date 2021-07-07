package com.library.sroy.LibraryProject.service;

import com.library.sroy.LibraryProject.exception.BookAlreadyBeenIssuedException;
import com.library.sroy.LibraryProject.exception.BookNotFoundException;
import com.library.sroy.LibraryProject.exception.UserNotFoundException;
import com.library.sroy.LibraryProject.model.Book;
import com.library.sroy.LibraryProject.model.LibraryCard;
import com.library.sroy.LibraryProject.model.User;
import com.library.sroy.LibraryProject.repository.BookRepository;
import com.library.sroy.LibraryProject.repository.LibraryCardRepository;
import com.library.sroy.LibraryProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class IssueService {

    private final double FineRate = 0.25;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private LibraryCardRepository cardRepository;

    public Integer issueTheBookToTheUser(Integer userId, Integer bookId){

        Optional<User> userOptional = userRepository.findById(userId);
        if(!userOptional.isPresent())
            throw new UserNotFoundException("The given user is not found");

        User newUser = userOptional.get();
        LibraryCard userLibraryCard = newUser.getCard();

        if(userLibraryCard.hasBookIssued())
            throw new BookAlreadyBeenIssuedException("This card already a book been issued to it");

        Optional<Book> bookOptional = bookRepository.findById(bookId);
        if(!bookOptional.isPresent())
            throw new BookNotFoundException("The given book is not available");

        Book chosenBook = bookOptional.get();
        //setting the book Status
        chosenBook.setIssueStatus(true);

        //set the book object
        userLibraryCard.setIssuedBook(chosenBook);


        LocalDate localDate = LocalDate.now();
        //setting the issue date
        userLibraryCard.setIssueDate(localDate);
        DateCalculationService dateCalculationService = new DateCalculationService();
        LocalDate expectedReturnDate = dateCalculationService.getExpectedReturnDate(localDate);

        //setting the expected Date
        userLibraryCard.setExpecTedReturn(expectedReturnDate);

        cardRepository.save(userLibraryCard);

        return userLibraryCard.getCardId();
    }

     public Double calculateFineRate(Integer userId){
        Optional<User> userOptional = userRepository.findById(userId);
        if(!userOptional.isPresent())
            throw new UserNotFoundException("The given UserId is not found");

        User user = userOptional.get();
        LibraryCard libraryCard = user.getCard();

        LocalDate currenLocalDate = LocalDate.now().plusDays(90);
          //for testing
        LocalDate expectedReturnDate = libraryCard.getExpecTedReturn();

        int daysDiff = new DateCalculationService().getDifferenceDays(currenLocalDate,expectedReturnDate);
        ++daysDiff;

        if(daysDiff>0){
            libraryCard.setDefaulter(true);
            cardRepository.save(libraryCard);
            Double fine = daysDiff * FineRate;
            return fine;
        }
        else
            return 0.0;
     }
}
