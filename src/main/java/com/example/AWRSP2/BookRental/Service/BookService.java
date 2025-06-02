package com.example.AWRSP2.BookRental.Service;

import com.example.AWRSP2.BookRental.Book;
import com.example.AWRSP2.BookRental.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Book addBook(Book book){
        return bookRepository.save(book);
    }

    public Book getBookById(int id){
        return bookRepository.findById(id).orElse(null);
    }

    public void setBookAvailability(Book book, boolean available){
        book.setAvailable(available);
        bookRepository.save(book);
    }
}
