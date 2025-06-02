package com.example.AWRSP2.BookRental.Controller;

import com.example.AWRSP2.BookRental.Rental;
import com.example.AWRSP2.BookRental.Service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rentals")
public class RentalController {
    private final RentalService rentalService;

    @Autowired
    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @PostMapping("/rent")
    public String rentBook(@RequestParam int userId, @RequestParam int bookId){
        return rentalService.rentBook(userId, bookId);
    }

    @PostMapping("/return/{rentalId}")
    public String returnBook(@PathVariable int rentalId){
        return rentalService.returnBook(rentalId);
    }

    @GetMapping
    public List<Rental> getAllRentals(){
        return rentalService.getAllRentals();
    }

    @GetMapping("/history/{userId}")
    public List<Rental> getUserRentalHistory(@PathVariable int userId){
        return rentalService.getUserRentalHistory(userId);
    }
}
