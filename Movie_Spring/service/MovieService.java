package com.service;

import java.util.List;

import com.model.Movie;

public interface MovieService {
	
	public boolean addMovie(Movie movie);
	public Movie getMovie(int movieId);
	public boolean isMovieExists(int movieId);
	public boolean deleteMovie(int movieId);
	public boolean updateMovie(Movie movie);
	public List<Movie> getMovies();
	public List<Movie> searchMovieByGenre(String movieGenre);

}
