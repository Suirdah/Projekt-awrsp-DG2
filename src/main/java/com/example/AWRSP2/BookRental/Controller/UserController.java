package com.example.AWRSP2.BookRental.Controller;

import com.example.AWRSP2.BookRental.Service.UserService;
import com.example.AWRSP2.BookRental.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id){
        return userService.getUserById(id);
    }

    @PostMapping
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }
}
