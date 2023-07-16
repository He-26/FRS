package com.frs.sakila.service;

import java.util.List;
import java.util.Optional;

import com.frs.sakila.entity.Address;
import com.frs.sakila.entity.Customer;
import com.frs.sakila.entity.myEntity;

public interface CustomerService {

	List<Customer> findAllCustomers();
	List<Customer> findCustomersByLastName(String lastName);
	List<Customer> findCustomersByFirstName(String firstName);
	Customer findCustomerByEmail(String email);
	List<Customer> getCustomersByCity(String city);
	List<Customer> getCustomersByCountry(String country);
    Customer assignAddressToCustomer(short customerId, Address address);
	List<Customer> findActiveCustomers();
	List<Customer> findInactiveCustomers();
	Customer findCustomerByPhone(String phone);
	Customer updateCustomerFirstName(Short id, String firstName);
	Customer updateCustomerLastName(Short id, String lastName);
	Customer updateCustomerEmail(Short id, String email);	
	Optional<Customer> assignStoreToCustomer(Short id, Byte storeId);
	Customer updateCustomerPhone(Short customerId, String phone);
	Customer addCustomer(Customer customer);
	Customer saveCustomer(Customer customer);
	
}
