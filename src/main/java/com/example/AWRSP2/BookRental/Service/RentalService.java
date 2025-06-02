package com.example.AWRSP2.BookRental.Service;

import com.example.AWRSP2.BookRental.Book;
import com.example.AWRSP2.BookRental.Rental;
import com.example.AWRSP2.BookRental.Repository.RentalRepository;
import com.example.AWRSP2.BookRental.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RentalService {
    private final RentalRepository rentalRepository;
    private final UserService userService;
    private final BookService bookService;

    @Autowired
    public RentalService(RentalRepository rentalRepository, UserService userService, BookService bookService) {
        this.rentalRepository = rentalRepository;
        this.userService = userService;
        this.bookService = bookService;
    }

    public String rentBook(int userId, int bookId){
        User user = userService.getUserById(userId);
        if (user == null){
            return "Nie znaleziono użytkownika";
        }
        Book book = bookService.getBookById(bookId);
        if (book == null){
            return "Nie znaleziono książki";
        }
        if (!book.isAvailable()){
            return "Książka jest obecnie wypożyczona";
        }

        Rental rental = new Rental();
        rental.setUser(user);
        rental.setBook(book);
        rental.setRentalDate(LocalDate.now());

        bookService.setBookAvailability(book, false);
        rentalRepository.save(rental);
        return "Książka wypożyczona pomyślnie";
    }

    public String returnBook(int id){
        Rental rental = rentalRepository.findById(id).orElse(null);
        if (rental == null){
            return "Nie znaleziono wypożyczenia";
        }

        if (rental.getReturnDate() != null) {
            return "Książka była już zwrócona: " + rental.getReturnDate();
        }

        rental.setReturnDate(LocalDate.now());
        rentalRepository.save(rental);

        Book book = rental.getBook();
        bookService.setBookAvailability(book, true);

        return "Książka zwrócona pomyślnie";

    }

    public List<Rental> getAllRentals(){
        return rentalRepository.findAll();
    }

    public List<Rental> getUserRentalHistory(int id){
        User user = userService.getUserById(id);
        return rentalRepository.findByUser(user);
    }
}
