package com.frs.sakila;
/*
import com.cg.sakila.entity.Film;

import com.cg.sakila.entity.Language;

import com.cg.sakila.repository.FilmRepository;

import com.cg.sakila.repository.LanguageRepository;

import com.cg.sakila.service.FilmServiceImpl;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;

import org.mockito.Mock;

import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import java.util.List;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.*;



public class FilmTest {
	@Mock
	private FilmRepository filmRepository;
	@Mock
	private LanguageRepository languageRepository;
	@InjectMocks
	private FilmServiceImpl filmService;
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testCreateFilm() {
		Film film = new Film();
		when(filmRepository.save(film)).thenReturn(film);
		Film createdFilm = filmService.createFilm(film);
		assertEquals(film, createdFilm);
		verify(filmRepository, times(1)).save(film);
	}

	@Test
	public void testSearchFilmsByTitle() {
		String title = "Sample Title";
		List<Film> films = Arrays.asList(new Film(), new Film());
		when(filmRepository.findByTitleContaining(title)).thenReturn(films);
		List<Film> foundFilms = filmService.searchFilmsByTitle(title);
		assertEquals(films, foundFilms);
		verify(filmRepository, times(1)).findByTitleContaining(title);

	}

	@Test

	public void testSearchFilmsByReleaseYear() {
		int year = 2021;
		List<Film> films = Arrays.asList(new Film(), new Film());
		when(filmRepository.findByReleaseYear(year)).thenReturn(films);
		List<Film> foundFilms = filmService.searchFilmsByReleaseYear(year);
		assertEquals(films, foundFilms);
		verify(filmRepository, times(1)).findByReleaseYear(year);
	}
	@Test
	public void testFindFilmsByRentalDurationGreaterThan() {
		int rentalDuration = 5;
		List<Film> films = Arrays.asList(new Film(), new Film());
		when(filmRepository.findFilmsByRentalDurationGreaterThan(rentalDuration)).thenReturn(films);
		List<Film> foundFilms = filmService.findFilmsByRentalDurationGreaterThan(rentalDuration);
		assertEquals(films, foundFilms);
		verify(filmRepository, times(1)).findFilmsByRentalDurationGreaterThan(rentalDuration);
	}

	@Test
	public void testFindFilmsByRentalRateGreaterThan() {
		double rentalRate = 5.99;
		List<Film> films = Arrays.asList(new Film(), new Film());
		when(filmRepository.findFilmsByRentalRateGreaterThan(rentalRate)).thenReturn(films);
		List<Film> foundFilms = filmService.findFilmsByRentalRateGreaterThan(rentalRate);
		assertEquals(films, foundFilms);
		verify(filmRepository, times(1)).findFilmsByRentalRateGreaterThan(rentalRate);

	}
	@Test
	public void testUpdateFilmReleaseYear() {
		short id = 1;
		int newReleaseYear = 2023;
		Film film = new Film();
		when(filmRepository.findById(id)).thenReturn(Optional.of(film));
		filmService.updateFilmReleaseYear(id, newReleaseYear);
		assertEquals(newReleaseYear, film.getReleaseYear());
		verify(filmRepository, times(1)).save(film);
	}
	@Test
	public void testUpdateFilmRentalDuration() {
		short id = 1;
		int newRentalDuration = 7;
		Film film = new Film();
		when(filmRepository.findById(id)).thenReturn(Optional.of(film));
		filmService.updateFilmRentalDuration(id, newRentalDuration);
		assertEquals(newRentalDuration, film.getRentalDuration());
		verify(filmRepository, times(1)).save(film);

	}

	@Test
	public void testUpdateFilmRentalRate() {
		short id = 1;
		double newRentalRate = 6.99;
		Film film = new Film();
		when(filmRepository.findById(id)).thenReturn(Optional.of(film));
		filmService.updateFilmRentalRate(id, newRentalRate);
		assertEquals(newRentalRate, film.getRentalRate());
		verify(filmRepository, times(1)).save(film);
	}
	@Test
	public void testUpdateFilmRating() {
		short id = 1;
		String newRating = "R";
		Film film = new Film();
		when(filmRepository.findById(id)).thenReturn(Optional.of(film));
		filmService.updateFilmRating(id, newRating);
		assertEquals(newRating, film.getRating());
		verify(filmRepository, times(1)).save(film);
	}
	@Test
	public void testUpdateFilmLanguage() {
		Short filmId = 1;
		String languageName = "English";
		Film film = new Film();
		Language language = new Language();
		when(filmRepository.findById(filmId)).thenReturn(Optional.of(film));
		when(languageRepository.findByName(languageName)).thenReturn(language);
		filmService.updateFilmLanguage(filmId, languageName);
		assertEquals(language, film.getLanguage());
		verify(filmRepository, times(1)).save(film);
	}
	@Test
	public void testCountFilmsByYear() {
		List<Object[]> filmCounts = Arrays.asList(new Object[]{2021, 10L}, new Object[]{2022, 15L});
		when(filmRepository.countFilmsByYear()).thenReturn(filmCounts);
		List<Object[]> counts = filmService.countFilmsByYear();
		assertEquals(filmCounts, counts);
		verify(filmRepository, times(1)).countFilmsByYear();
	}


}
*/