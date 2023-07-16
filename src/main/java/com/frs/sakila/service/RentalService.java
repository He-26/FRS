package com.frs.sakila.service;


import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.frs.sakila.entity.Customer;
import com.frs.sakila.entity.Film;
import com.frs.sakila.entity.Rental;
@Service
public interface RentalService {
	List<Rental> getAllRentals();
    List<Film> getFilmsRentedByCustomer(Short customerId);
    String addRental(Rental rental);
	List<Film> getTop10RentedFilms();
	List<Object[]> getTop10RentedFilmsByStoreId(Byte storeId);
	List<Customer> getCustomersWithUnreturnedFilms();
	public Rental updateRentalReturnDate(Integer rentalId, Date returnDate);
    }
    


