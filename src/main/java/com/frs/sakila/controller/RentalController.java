package com.frs.sakila.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.frs.sakila.entity.Customer;
import com.frs.sakila.entity.Film;
import com.frs.sakila.entity.Rental;
import com.frs.sakila.service.RentalService;


@RestController
@RequestMapping("/api/rental")
public class RentalController {

    private RentalService rentalService;
    @Autowired
    public void setRentalService(RentalService rentalService) {
		this.rentalService = rentalService;
	}
    
   
    @GetMapping("/getAll")
    public ResponseEntity<List<Rental>> getAllRentals() {
        List<Rental> rentals = rentalService.getAllRentals();
        return new ResponseEntity<>(rentals, HttpStatus.OK);
    }

    
    @GetMapping("/customer/{customerId}/films")
    public ResponseEntity<List<Film>> getFilmsRentedByCustomer(@PathVariable Short customerId) {
        List<Film> films = rentalService.getFilmsRentedByCustomer(customerId);

        if (films.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(films);
    }
    @GetMapping("/top-10-rented-films")
    public ResponseEntity<List<Film>> getTop10RentedFilms() {
    	List<Film> films = rentalService.getTop10RentedFilms();
        return new ResponseEntity<List<Film>>(films,HttpStatus.OK);
    }
    @GetMapping("/top-10-rented-films/{storeId}")
    public ResponseEntity<List<Object[]>> getTop10RentedFilmsByStoreId(@PathVariable Byte storeId) {
        List<Object[]> top10RentedFilms = rentalService.getTop10RentedFilmsByStoreId(storeId);

        if (top10RentedFilms.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(top10RentedFilms);
    }
    @GetMapping("/unreturned-customers")
    public ResponseEntity<List<Customer>> getCustomersWithUnreturnedFilms() {
        List<Customer> customers = rentalService.getCustomersWithUnreturnedFilms();
        return ResponseEntity.ok(customers);
    }
    @PostMapping("/{rentalId}/return-date")
    public ResponseEntity<Rental> updateRentalReturnDate(
            @PathVariable Integer rentalId,
            @RequestParam("returnDate") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") java.util.Date returnDate
    ) {
        Rental updatedRental = rentalService.updateRentalReturnDate(rentalId, returnDate);
        return ResponseEntity.ok(updatedRental);
    }
   
}
