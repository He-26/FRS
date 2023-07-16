package com.frs.sakila.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frs.sakila.entity.Film;
import com.frs.sakila.entity.Inventory;
import com.frs.sakila.exception.InventoryNotFoundException;
import com.frs.sakila.repository.InventoryRepository;

@Service
public class InventoryServiceImpl implements InventoryService {

	private final InventoryRepository inventoryRepository;


	@Autowired
	public InventoryServiceImpl(InventoryRepository inventoryRepository ) {
		this.inventoryRepository = inventoryRepository;
	}
	@Override
	public void addFilmToStore(Inventory inventory) {
		inventoryRepository.save(inventory);
	}

	@Override
	public List<Inventory> getAllInventory() {
		return inventoryRepository.findAll();
	}

	@Override
	public int getInventoryCountForFilm(Film film) {
		return inventoryRepository.countByFilm(film);
	}

	@Override
	public List<Map<String, Object>> getInventoryByStoreId(Byte storeId) {
		List<Inventory> inventoryList = inventoryRepository.findByStoreStoreId(storeId);
		List<Map<String, Object>> result = new ArrayList<>();
		for(Inventory inventory : inventoryList) {
			Film film = inventory.getFilm();
			String filmTitle = film.getTitle();
			int numberOfCopies = inventoryList.size();
			Map<String, Object> inventoryData = new HashMap<>();
			inventoryData.put("title", filmTitle);
			inventoryData.put("copies", numberOfCopies);
			result.add(inventoryData);
		}
		if(result.isEmpty())
			throw new InventoryNotFoundException("No Inventory found with given Store ID: "+storeId);
		else return result;
	}


	@Override
	public List<Map<String, Object>> getInventoryCountByFilmIdWithStoreAddress(Short filmId) {
		List<Map<String, Object>> l = inventoryRepository.getInventoryCountByFilmIdWithStoreAddress(filmId);
		if(l.isEmpty())
			throw new InventoryNotFoundException("No Inventory found with "+filmId);
		else return inventoryRepository.getInventoryCountByFilmIdWithStoreAddress(filmId);
	}


	@Override
	public List<Object[]> getInventoryCountByFilmAndStore(Short filmId, Byte storeId) {
		List<Object []> l=inventoryRepository.findInventoryCountByFilmAndStore(filmId, storeId);
		if(l.isEmpty())
			throw new InventoryNotFoundException("No Inventory found with given Film ID: "+filmId+"and Store ID: "+storeId);
		else return inventoryRepository.findInventoryCountByFilmAndStore(filmId, storeId);

	}
}