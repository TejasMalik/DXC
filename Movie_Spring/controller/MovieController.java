package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Movie;
import com.service.MovieService;

@RestController
@RequestMapping("movie")
public class MovieController {
	
	@Autowired
	MovieService movieService;
	
	@GetMapping("/{movieId}")
	public Movie getMovie(@PathVariable("movieId")int movieId) {
		System.out.println("Get movie called " +movieId);
		return movieService.getMovie(movieId);
	}
	
	@DeleteMapping("/{movieId}")
	public boolean deleteMovie(@PathVariable("movieId")int movieId) {
		System.out.println("Delete movie called " +movieId);
		return movieService.deleteMovie(movieId);
	}
	
	@GetMapping
	public List<Movie> getAllMovies() {
		
		System.out.println("Get All Movies");
		return movieService.getMovies();
	}
	
	@PostMapping
	public boolean saveMovie(@RequestBody Movie movie) {
		System.out.println("Saving a movie");
		System.out.println(movie);
		return movieService.addMovie(movie);
	}
	
	@PutMapping
	public boolean updateMovie(@RequestBody Movie movie) {
		System.out.println("Updating a movie");
		System.out.println(movie);
		return movieService.updateMovie(movie);
	}
	
}
