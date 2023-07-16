package com.frs.sakila.service;

import java.util.List;
import java.util.Map;

import com.frs.sakila.entity.Customer;
import com.frs.sakila.entity.Staff;
import com.frs.sakila.entity.Store;

public interface StoreService {

	
	void updateStore(Store store);
	Store getStoreById(byte id);
	List<Store> getStoresByCity(String city);
	List<Store> getStoresByCountry(String country);
	Store getStoreByPhoneNumber(String phone);
	void updateStorePhoneNumber(byte storeId, String phone);
	List<Staff> getAllStaffByStoreId(byte storeId);
	List<Staff> getManagerDetailsByStoreId(byte storeId);
	List<Staff> getAllManagers();
	List<Store> fetchAllStore();
	Store findStoreByManagerStaffId(byte managerStaffId);
	List<Staff> findAllStaff();
	List<Store> findAllStore();
	Map<String, Object> findAllOfMyStore();
	List<Customer> getCustomersByStoreId(Byte storeId);
}
