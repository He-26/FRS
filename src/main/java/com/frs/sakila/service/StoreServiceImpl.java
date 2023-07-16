package com.frs.sakila.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frs.sakila.entity.Customer;
import com.frs.sakila.entity.Staff;
import com.frs.sakila.entity.Store;
import com.frs.sakila.exception.StoreNotFoundException;
import com.frs.sakila.repository.AddressRepository;
import com.frs.sakila.repository.StaffRepository;
import com.frs.sakila.repository.StoreRepository;

import java.util.Collections;

@Service
public class StoreServiceImpl implements StoreService {
	
	@Autowired
	private StoreRepository storeRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private StaffRepository staffRepository;


	@Override
	public void updateStore(Store store) {
		storeRepository.save(store);
	}

	
	@Override
	public List<Store> getStoresByCity(String city) {
		List<Store> store = storeRepository.findByAddressCityCity(city);
		if(store.isEmpty())
			throw new StoreNotFoundException("Store with city "+city+" is not available");
		return storeRepository.findByAddressCityCity(city);
	}
	
	 public List<Customer> getCustomersByStoreId(Byte storeId) {
		 List<Customer> customer = storeRepository.findCustomersByStoreId(storeId);
		 if(customer.isEmpty())
			 throw new StoreNotFoundException("Customer with store ID "+storeId+" is not available");
	        return storeRepository.findCustomersByStoreId(storeId);
	    }
	
	@Override
	public Store getStoreById(byte id) {
		Store store = storeRepository.findByStoreId(id);
		if(store==null)
			throw new StoreNotFoundException("Store with ID "+id+" is not available");
		return storeRepository.findByStoreId(id);
	}

	@Override
	public List<Store> getStoresByCountry(String country) {
		List<Store> store = storeRepository.findByAddressCityCountryCountry(country);
		if(store.isEmpty())
			throw new StoreNotFoundException("Store with country "+country+" is not available");
		return storeRepository.findByAddressCityCountryCountry(country);
	}

	@Override
	public Store getStoreByPhoneNumber(String phone) {
		Store store = storeRepository.findByAddressPhone(phone);
		if(store==null)
			throw new StoreNotFoundException("Store with phone "+phone+" is not available");
		return storeRepository.findByAddressPhone(phone);
	}
	
	@Override
	public List<Staff> getManagerDetailsByStoreId(byte storeId) {
		List<Staff> staff = storeRepository.findManagerByStoreId(storeId);
		if(staff.isEmpty())
			throw new StoreNotFoundException("Manager with store ID "+storeId+" is not available");
		return staffRepository.findByStoreId(storeId);
	}
	
	@Override
	public void updateStorePhoneNumber(byte storeId, String phone) {
		Optional<Store> storeOptional = storeRepository.findById(storeId);
		if (storeOptional.isPresent()) {
			Store store = storeOptional.get();
			store.getAddress().setPhone(phone);
			storeRepository.save(store);
		}
	}

	@Override
	public List<Staff> getAllStaffByStoreId(byte storeId) {
		List<Staff> staff =staffRepository.getByStoreStoreId(storeId);
		if(staff.isEmpty())
			throw new StoreNotFoundException("Invalid Id");
		else return staffRepository.getByStoreStoreId(storeId);
	}
	
	

	@Override
	public List<Staff> getAllManagers() {
		return staffRepository.allManagers();
	}

	@Override
	public List<Store> fetchAllStore() {
		return storeRepository.findAll();
	}

	@Override
	public Store findStoreByManagerStaffId(byte managerStaffId) {
		Staff staff = staffRepository.findByStaffId(managerStaffId);
		byte id = staff.getStaffId();
		return storeRepository.findByStoreId(id);
	}

	@PersistenceContext
	private EntityManager entityManager;

	public Map<String, Object> findAllOfMyStore() {
		//return storeRepository.getStoreData();
		return null;
	}


	@Override
	public List<Staff> findAllStaff() {
		return Collections.emptyList();
	}

	@Override
	public List<Store> findAllStore() {
		return Collections.emptyList();
	}
	
   


}
