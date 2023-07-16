package com.frs.sakila.service;

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

import com.frs.sakila.entity.Payment;
import com.frs.sakila.repository.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService {

	private PaymentRepository paymentRepository;
	@Autowired
	public PaymentServiceImpl(PaymentRepository paymentRepository) {
		this.paymentRepository = paymentRepository;
	}
	
	EntityManager entityManager;
	@Autowired
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public List<Object[]> calculateCumulativeRevenueOfAllStores(){
		
		String query = "SELECT DATE(payment_date) AS payment_date, SUM(amount) AS amount " +
            "FROM Payment " +
            "GROUP BY DATE(payment_date) " +
            "ORDER BY DATE(payment_date)";

		List<Object[]> results = entityManager.createQuery(query, Object[].class).getResultList();
		List<Object[]> cumulativeResults = new ArrayList<>();

		BigDecimal cumulativeRevenue = BigDecimal.ZERO;
		for(Object[] result : results) {
			Date paymentDate = (Date) result[0];
			BigDecimal amount = (BigDecimal) result[1];
			cumulativeRevenue = cumulativeRevenue.add(amount);
			Object[] cumulativeResult = { paymentDate, amount, cumulativeRevenue };
			cumulativeResults.add(cumulativeResult);
		}
		return cumulativeResults;
	}
	


	@Override
	public Payment addPayment(Payment payment) {
		return paymentRepository.save(payment);
	}


	@Override
	public List<Map<String, Object>> getRevenueByFilm() {
		List<Map<String, Object>> list = paymentRepository.getRevenueByFilm();
		return list;
	}
	

}
    
