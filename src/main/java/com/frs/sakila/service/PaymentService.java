package com.frs.sakila.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.frs.sakila.entity.Payment;

public interface PaymentService {

	Payment addPayment(Payment payment);
	List<Object[]> calculateCumulativeRevenueOfAllStores();
    List<Map<String,Object>> getRevenueByFilm();
    
}
