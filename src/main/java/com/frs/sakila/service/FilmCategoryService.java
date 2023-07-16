package com.frs.sakila.service;

import java.util.List;

import com.frs.sakila.entity.Category;
import com.frs.sakila.entity.Film;


public interface FilmCategoryService {
	
    List<Film> getFilmsByCategory(String category);
    void assignCategoryToFilm(Short filmId, Category category);
}
