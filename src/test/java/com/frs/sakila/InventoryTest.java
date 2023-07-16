package com.frs.sakila;
/*
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.frs.sakila.entity.Film;


import static org.mockito.Mockito.*;

import com.frs.sakila.entity.Inventory;
import com.frs.sakila.exception.InventoryNotFoundException;
import com.frs.sakila.repository.InventoryRepository;
import com.frs.sakila.service.InventoryServiceImpl;

class InventoryTest {
	@Mock
    private InventoryRepository inventoryRepository;
    private InventoryServiceImpl inventoryService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        inventoryService = new InventoryServiceImpl(inventoryRepository);
    }
    
    @Test
    void testAddFilmToStore() {
        Inventory inventory = new Inventory();
        when(inventoryRepository.save(inventory)).thenReturn(inventory);
        inventoryService.addFilmToStore(inventory);
        verify(inventoryRepository).save(inventory);
    }

    @Test
    void testGetAllInventory() {
        List<Inventory> expectedInventory = new ArrayList<>();
        when(inventoryRepository.findAll()).thenReturn(expectedInventory);
        List<Inventory> actualInventory = inventoryService.getAllInventory();
        verify(inventoryRepository).findAll();
        Assertions.assertEquals(expectedInventory, actualInventory);
    }

    @Test
    void testGetInventoryCountForFilm() {
        Film film = new Film();
        int expectedCount = 5;
        when(inventoryRepository.countByFilm(film)).thenReturn(expectedCount);
        int actualCount = inventoryService.getInventoryCountForFilm(film);
        verify(inventoryRepository).countByFilm(film);
        Assertions.assertEquals(expectedCount, actualCount);
    }

    @Test
    void testGetInventoryByStoreIdThrowsException() {
        Byte storeId = 1;
        List<Inventory> inventoryList = new ArrayList<>();
        when(inventoryRepository.findByStoreStoreId(storeId)).thenReturn(inventoryList);
        Assertions.assertThrows(InventoryNotFoundException.class, () -> {
            inventoryService.getInventoryByStoreId(storeId);
        });
        verify(inventoryRepository).findByStoreStoreId(storeId);
    }
}
*/