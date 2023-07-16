package com.frs.sakila.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.frs.sakila.entity.Customer;
import com.frs.sakila.entity.Staff;
import com.frs.sakila.entity.Store;
import com.frs.sakila.service.StoreService;

@RestController
@RequestMapping("/api/store")
public class StoreController {
	private final StoreService storeService;

	@Autowired
	public StoreController(StoreService storeService) {
		this.storeService = storeService;
	}

	
	@GetMapping("/city/{city}")
	public ResponseEntity<List<Store>> getStoresByCity(@PathVariable("city") String city) {
		List<Store> stores = storeService.getStoresByCity(city);
		return ResponseEntity.ok(stores);
	}

	@GetMapping("/country/{country}")
	public ResponseEntity<List<Store>> getStoresByCountry(@PathVariable("country") String country) {
		List<Store> stores = storeService.getStoresByCountry(country);
		return ResponseEntity.ok(stores);
	}

	@PutMapping("/update/phone/{id}")
	public ResponseEntity<Store> updateStorePhoneNumber(@PathVariable("id") byte storeId, @RequestBody String phone) {
		storeService.updateStorePhoneNumber(storeId, phone);
		Store store = storeService.getStoreById(storeId);
		return ResponseEntity.ok(store);
	}

	@GetMapping("/staff/{id}")
	public ResponseEntity<List<Staff>> getAllStaffByStoreId(@PathVariable("id") byte storeId) {
		List<Staff> staffList = storeService.getAllStaffByStoreId(storeId);
		return ResponseEntity.ok(staffList);
	}

		@GetMapping("/phone/{phone}")
		public ResponseEntity<Store> getStoreByPhoneNumber(@PathVariable("phone") String phone) {
			Store store = storeService.getStoreByPhoneNumber(phone);
			return ResponseEntity.ok(store);
		}
		
	@GetMapping("/customer/{id}")
	public ResponseEntity<List<Customer>> getCustomersByStoreId(@PathVariable("id") Byte storeId) {
		List<Customer> customer = storeService.getCustomersByStoreId(storeId);
		return ResponseEntity.ok(customer);
	}    
	
	@GetMapping("/manager/{id}")
	public ResponseEntity<List<Staff>> getManagerDetailsByStoreId(@PathVariable("id") byte storeId) {
		List<Staff> managers = storeService.getManagerDetailsByStoreId(storeId);
		return ResponseEntity.ok(managers);
	}
	
	@GetMapping("/managers")
	public ResponseEntity<List<Staff>> getAllManagers() {
		List<Staff> managers = storeService.getAllManagers();
		return ResponseEntity.ok(managers);
	}
}