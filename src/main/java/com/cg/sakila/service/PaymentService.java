package com.cg.sakila.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.cg.sakila.entity.Payment;

public interface PaymentService {

    public List<Object[]> calculateCumulativeRevenueByDateAndStore(Byte storeId);
    List<Map<String,Object>> getRevenueByFilm();
    List<Object[]> calculateRevenueByFilmStoreWise(int filmId);
}
