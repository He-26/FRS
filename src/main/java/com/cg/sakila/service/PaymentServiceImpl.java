package com.cg.sakila.service;

import java.math.BigDecimal;
import java.security.Timestamp;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.sakila.entity.Payment;
import com.cg.sakila.repository.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService {

	private PaymentRepository paymentRepository;
	@Autowired
	public PaymentServiceImpl(PaymentRepository paymentRepository) {
		this.paymentRepository = paymentRepository;
	}
	
	
	@Override
	public List<Object[]> calculateCumulativeRevenueByDateAndStore(Byte storeId) {
		return paymentRepository.calculateCumulativeRevenueByDateAndStore(storeId);
	}


	@Override
	public List<Map<String, Object>> getRevenueByFilm() {
		List<Map<String, Object>> list = paymentRepository.getRevenueByFilm();
		return list;
	}


	@Override
	public List<Object[]> calculateRevenueByFilmStoreWise(int filmId) {
		List<Object[]> list = paymentRepository.calculateRevenueByFilmStoreWise(filmId);
		return list;
	}
}
    
