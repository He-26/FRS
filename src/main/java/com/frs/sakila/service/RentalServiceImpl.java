package com.frs.sakila.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frs.sakila.entity.Customer;
import com.frs.sakila.entity.Film;
import com.frs.sakila.entity.Inventory;
import com.frs.sakila.entity.Rental;
import com.frs.sakila.exception.ActorNotFoundException;
import com.frs.sakila.repository.InventoryRepository;
import com.frs.sakila.repository.RentalRepository;

@Service
public class RentalServiceImpl implements RentalService {

    public RentalRepository rentalRepository;
    @Autowired
    public void setRentalRepository(RentalRepository rentalRepository) {
		this.rentalRepository = rentalRepository;
	}

    @Autowired
    public  InventoryRepository inventoryRepository;
    
    @Override
    public List<Rental> getAllRentals() {
        List<Rental> list = rentalRepository.findAll();
        if (list.size() > 0)
            throw new ActorNotFoundException("Rentals are not found.. ");
        return list;
    }
  
    @Override
    public String addRental(Rental rental) {
    	 if (rental == null) {
    	        throw new ActorNotFoundException("Rental object is null");
    	    }
    	    Rental savedRental = rentalRepository.save(rental);
    	    return "Record Created Successfully";
    }

	@Override
	public List<Film> getFilmsRentedByCustomer(Short customerId1) {
		List<Film> list1 = rentalRepository.getFilmsRentedByCustomer(customerId1);
		if(list1.isEmpty())
			throw new ActorNotFoundException("No customer rented the films");
		return list1;
	}


	@Override
	public List<Film> getTop10RentedFilms() {
        
        
        List<Object[]> resultList = rentalRepository.getTop10RentedFilms();
		if(resultList.isEmpty())
			throw new ActorNotFoundException("No films found");
        
        List<Film> topFilms = new ArrayList<>();
        for (Object[] result : resultList) {
            Film film = (Film) result[0];
            topFilms.add(film);
            if(topFilms.size()==10)
            	break;
        }
        
        return topFilms;
    }
	public List<Object[]> getTop10RentedFilmsByStoreId(Byte storeId) {
		List<Object[]> list = rentalRepository.findTop10RentedFilmsByStoreId(storeId);
		if(list.isEmpty())
			throw new ActorNotFoundException("No films found");
		return list;
	}
	public List<Customer> getCustomersWithUnreturnedFilms() {
			
		List<Customer> list = rentalRepository.findCustomersWithUnreturnedFilms();
		if(list.isEmpty())
			throw new ActorNotFoundException("No Customer found");
		return list;
    }
	@Override
	public Rental updateRentalReturnDate(Integer rentalId, Date returnDate) {
		Rental rental = rentalRepository.findById(rentalId).orElseThrow(()->new ActorNotFoundException("No film found"));
        rental.setReturnDate(returnDate);
        return rentalRepository.save(rental);
	}
}