package com.cg.sakila.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.sakila.entity.Address;
import com.cg.sakila.entity.Customer;
import com.cg.sakila.entity.Staff;
import com.cg.sakila.entity.Store;
import com.cg.sakila.repository.AddressRepository;
import com.cg.sakila.repository.StaffRepository;
import com.cg.sakila.repository.StoreRepository;
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
	public void addStore(Store store) {
		storeRepository.save(store);
	}

	@Override
	public void updateStore(Store store) {
		storeRepository.save(store);
	}

	@Override
	public Store getStoreById(byte id) {
		return storeRepository.findByStoreId(id);
	}

	
	@Override
	public List<Store> getStoresByCity(String city) {
		return storeRepository.findByAddressCityCity(city);
	}

	
	@Override
	public List<Store> getStoresByCountry(String country) {
		return storeRepository.findByAddressCityCountryCountry(country);
	}

	@Override
	public Store getStoreByPhoneNumber(String phone) {
		return storeRepository.findByAddressPhone(phone);
	}
	
	@Override
	public void assignAddressToStore(byte storeId, Address address) {
	    Store store = storeRepository.findByStoreId(storeId);
	    store.setAddress(address);
	    addressRepository.save(address);
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
	public void assignManagerToStore(byte managerStaffId, Staff manager) {
		Store store = findStoreByManagerStaffId(managerStaffId);
		manager.setStore(store);
	}

	@Override
	public List<Staff> getAllStaffByStoreId(byte storeId) {
		return staffRepository.getByStoreStoreId(storeId);
	}
	
	@Override
	public List<Staff> getManagerDetailsByStoreId(byte storeId) {
		return staffRepository.findByStoreId(storeId);
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
	public List<Address> fetchAllAddress() {
		return addressRepository.findAll();
	}

	@Override
	public List<Staff> findAllStaff() {
		return Collections.emptyList();
	}

	@Override
	public List<Store> findAllStore() {
		return Collections.emptyList();
	}
	
    public List<Customer> getCustomersByStoreId(Byte storeId) {
        return storeRepository.findCustomersByStoreId(storeId);
    }


}
