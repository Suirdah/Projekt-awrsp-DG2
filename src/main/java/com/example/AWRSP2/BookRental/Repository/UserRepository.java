package com.example.AWRSP2.BookRental.Repository;

import com.example.AWRSP2.BookRental.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
