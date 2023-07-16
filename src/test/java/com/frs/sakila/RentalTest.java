package com.frs.sakila;
/*
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.frs.sakila.entity.Rental;
import com.frs.sakila.exception.ActorNotFoundException;
import com.frs.sakila.service.RentalService;

@SpringBootTest
public class RentalTest {
	
	RentalService rentalService;
	@Autowired
	public void setRentalService(RentalService rentalService) {
		this.rentalService = rentalService;
	}
	@Test
	public void testGetTop10Films()
	{
		assertNotNull(rentalService.getTop10RentedFilms());
	}
	@Test
	public void testUpdateReturnDateException()
	{
		assertThrows(ActorNotFoundException.class, ()->new ActorNotFoundException("No film found"));
	}
	@Test
	public void testUpdateReturnDate()
	{	
		int year = 2005;
		int month = Calendar.MAY;
		int day = 24;
		int hour = 22;
		int minute = 53;
		int second = 30;
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month, day, hour, minute, second);
		Date date = calendar.getTime();
		Rental rental = rentalService.updateRentalReturnDate(1, date);
        rental.setReturnDate(date);
		assertEquals(date,rental.getReturnDate() );
	}
	@Test
	public void testGetTop10FilmsByStore()
	{
		
		assertNotNull(rentalService.getCustomersWithUnreturnedFilms());
	}

}
*/