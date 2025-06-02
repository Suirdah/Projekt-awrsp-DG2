package com.example.AWRSP2.BookRental.Service;

import com.example.AWRSP2.BookRental.Book;
import com.example.AWRSP2.BookRental.Repository.UserRepository;
import com.example.AWRSP2.BookRental.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User addUser(User user){
        return userRepository.save(user);
    }

    public User getUserById(int id){
        return userRepository.findById(id).orElse(null);
    }
}
