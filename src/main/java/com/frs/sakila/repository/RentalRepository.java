package com.frs.sakila.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.frs.sakila.entity.Customer;
import com.frs.sakila.entity.Film;
import com.frs.sakila.entity.Rental;

public interface RentalRepository extends JpaRepository<Rental, Integer> {

	
	
	@Query("SELECT r.inventory.film, COUNT(r) FROM Rental r GROUP BY r.inventory.film ORDER BY COUNT(r) DESC")
	List<Object[]> getTop10RentedFilms();
	
	
	 @Query("SELECT r.inventory.film, COUNT(r) AS rentalCount " +
	           "FROM Rental r " +
	           "GROUP BY r.inventory.film " +
	           "ORDER BY rentalCount DESC")
	    List<Object[]> findTop10RentedFilms();
	
	
	@Query("SELECT r.inventory.film " +
		       "FROM Rental r " +
		       "WHERE r.customer.customerId = :customerId")
	    List<Film> findFilmsRentedByCustomer(Long customerId);
	
	@Query("SELECT r.inventory.film, COUNT(r) AS rentalCount " +
	           "FROM Rental r " +
	           "WHERE r.inventory.store.storeId = :storeId " +
	           "GROUP BY r.inventory.film " +
	           "ORDER BY rentalCount DESC ")
	    List<Film> findTop10RentedFilmsByStore(Long storeId);
	

	 @Query("SELECT DISTINCT r.customer FROM Rental r WHERE r.returnDate IS NULL AND r.inventory.store.id = :storeId")
	    List<Customer> findCustomersWithPendingReturns(@Param("storeId") Long storeId);
	 
	 Rental findByRentalId(Integer rentalId);

	 @Query("SELECT r.inventory.film.title, COUNT(r.inventory.film.title) AS rentalCount FROM Rental r WHERE r.inventory.store.storeId = :storeId GROUP BY r.inventory.film.title ORDER BY rentalCount DESC")
	 List<Object[]> findTop10RentedFilmsByStoreId(@Param("storeId") Byte storeId);
	 @Query("SELECT DISTINCT r.customer FROM Rental r WHERE r.returnDate IS NULL")
	 List<Customer> findCustomersWithUnreturnedFilms();
	 @Query("SELECT i.film FROM Rental r JOIN r.inventory i WHERE r.customer.customerId = 130")
		public List<Film> getFilmsRentedByCustomer(Short customerId1);
}


