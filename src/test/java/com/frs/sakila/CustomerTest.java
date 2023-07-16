package com.frs.sakila;
/*
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cg.sakila.entity.Customer;
import com.cg.sakila.exception.CustomerNotFoundException;
import com.cg.sakila.repository.CustomerRepository;
import com.cg.sakila.service.CustomerServiceImpl;

public class CustomerTest {

	@Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerServiceImpl customerService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
     void testFindAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer());
        customers.add(new Customer());
        when(customerRepository.findAll()).thenReturn(customers);
        List<Customer> result = customerService.findAllCustomers();
        assertEquals(customers, result);  
        verify(customerRepository).findAll();
    }

    @Test
    void testFindCustomersByLastName_WhenNoCustomersExist() {
        when(customerRepository.findByLastName("Smith")).thenReturn(new ArrayList<>());
        assertThrows(CustomerNotFoundException.class, () -> {
            customerService.findCustomersByLastName("Smith");
        });
        verify(customerRepository).findByLastName("Smith");
    }

    @Test
     void testFindCustomerByEmail_WhenCustomerDoesNotExist() {
        when(customerRepository.findByEmail("john@example.com")).thenReturn(null);        
        assertThrows(CustomerNotFoundException.class, () -> {
            customerService.findCustomerByEmail("john@example.com");
        });
        verify(customerRepository).findByEmail("john@example.com");
    }

 

    @Test
    void testFindCustomersByLastName_WhenNoCustomersExist1() {
        when(customerRepository.findByLastName("Smith")).thenReturn(new ArrayList<>());
        assertThrows(CustomerNotFoundException.class, () -> {
            customerService.findCustomersByLastName("Smith");
        });
        verify(customerRepository).findByLastName("Smith");
    }
}
*/
