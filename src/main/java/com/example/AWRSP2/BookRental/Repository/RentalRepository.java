package com.example.AWRSP2.BookRental.Repository;

import com.example.AWRSP2.BookRental.Rental;
import com.example.AWRSP2.BookRental.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentalRepository extends JpaRepository<Rental, Integer> {
    List<Rental> findByUser(User user);
}
