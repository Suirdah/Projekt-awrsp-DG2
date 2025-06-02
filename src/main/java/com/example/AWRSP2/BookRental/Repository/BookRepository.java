package com.example.AWRSP2.BookRental.Repository;

import com.example.AWRSP2.BookRental.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
