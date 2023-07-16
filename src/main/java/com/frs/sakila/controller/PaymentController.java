package com.frs.sakila.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.frs.sakila.entity.Actor;
import com.frs.sakila.entity.Payment;
import com.frs.sakila.service.PaymentService;

@RestController
@RequestMapping("api/payment")
public class PaymentController {

	private PaymentService paymentService;

	@Autowired
	public PaymentController(PaymentService paymentService) {
		this.paymentService = paymentService;
	}
	
	//working
	@PostMapping("/post")
	public ResponseEntity<String> addActor(@Valid @RequestBody Payment payment) {
		paymentService.addPayment(payment);
		return new ResponseEntity<>("Record Created Successfully", HttpStatus.CREATED);
	}
    
    @GetMapping("revenue/filmwise")
	public List<Map<String,Object>> getRevenueByFilm() {
		return paymentService.getRevenueByFilm();
	}
	
    
    @GetMapping("/revenue/datewise")
    public List<Object[]> getDatewiseRevenue() {
        return paymentService.calculateCumulativeRevenueOfAllStores();
    }
    
}
