package com.frs.sakila.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.frs.sakila.entity.Film;
import com.frs.sakila.entity.Inventory;
import com.frs.sakila.repository.FilmRepository;
import com.frs.sakila.repository.InventoryRepository;
import com.frs.sakila.service.FilmService;
import com.frs.sakila.service.InventoryService;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
	
	private final InventoryService inventoryService;
	 
	@Autowired
	FilmRepository filmRepository;
	@Autowired
	InventoryRepository inventoryRepository;
	 

	@Autowired
	public InventoryController(InventoryService inventoryService) {
	        this.inventoryService = inventoryService;
	} 	
	
	//working
 	@PostMapping("/add")
    public ResponseEntity<String> addFilmToStore(@RequestBody Inventory inventory) {
        inventoryService.addFilmToStore(inventory);
        return ResponseEntity.ok("Record Created Successfully");
    }
 	
	//working.
	@GetMapping("/films")
	public List<Map<String, Object>> getAllInventoryOfFilms() {
		List<Inventory> inventoryList = inventoryService.getAllInventory();
	 	List<Map<String, Object>> result = new ArrayList<>();
	 	Map<Film, Integer> filmInventoryMap = new HashMap<>();
	 	    for(Inventory inventory : inventoryList) {
	 	        Film film = inventory.getFilm();
	 	        int numberOfCopies = inventoryService.getInventoryCountForFilm(film);
	 	        filmInventoryMap.put(film, filmInventoryMap.getOrDefault(film, 0) + numberOfCopies);
	 	    }

	 	    for(Map.Entry<Film, Integer> entry : filmInventoryMap.entrySet()) {
	 	        Film film = entry.getKey();
	 	        Integer totalCount = entry.getValue();
	 	        Map<String, Object> inventoryData = new HashMap<>();
	 	        inventoryData.put("title", film.getTitle());
	 	        inventoryData.put("totalCopies", totalCount);
	 	        result.add(inventoryData);
	 	    }
	 	 return result;
	 }
	    
	//working.
	@GetMapping("/store/{id}")
	public ResponseEntity<List<Map<String, Object>>> getInventoryByStoreId(@PathVariable("id") Byte storeId) {
	    List<Map<String, Object>> inventoryData = inventoryService.getInventoryByStoreId(storeId);
	    return ResponseEntity.ok(inventoryData);
	}
	 	
	//working.
	@GetMapping("/film/{id}")
	public ResponseEntity<List<Map<String, Object>>> getInventoryCountByFilmIdWithStoreAddress(
	     @PathVariable("id") Short filmId) {
		 List<Map<String, Object>> inventoryData = inventoryService.getInventoryCountByFilmIdWithStoreAddress(filmId);
		 return ResponseEntity.ok(inventoryData);
	}

	//dummy
	@GetMapping
	public List<Inventory> getAllInventory() {
	      return inventoryService.getAllInventory();
	}
	
	 //working
	 @GetMapping("/film/{filmId}/store/{storeId}")
	 public ResponseEntity<Map<String, String>> getInventoryCount(@PathVariable Short filmId, @PathVariable Byte storeId) {
	 	List<Object[]> inventoryCount = inventoryService.getInventoryCountByFilmAndStore(filmId, storeId);
	 	if(inventoryCount.isEmpty()) {
	 		return ResponseEntity.notFound().build();
	 	}
	 	String storeAddress = inventoryCount.get(0)[0].toString();
	 	String count = inventoryCount.get(0)[1].toString();    
	 	Map<String, String> response = new HashMap<>();
	 	response.put("storeAddress", storeAddress);
	 	response.put("count", count);    
	 	return ResponseEntity.ok(response);
	 }
	    
}