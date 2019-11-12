package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.MovieDAO;
import com.model.Movie;

@Service
public class MovieServiceImpl implements MovieService {
	
	@Autowired
	MovieDAO movieDAO;

	@Override
	public boolean addMovie(Movie movie) {
		// TODO Auto-generated method stub
		return movieDAO.addMovie(movie);
	}

	@Override
	public Movie getMovie(int movieId) {
		// TODO Auto-generated method stub
		return movieDAO.getMovie(movieId);
	}

	@Override
	public boolean isMovieExists(int movieId) {
		// TODO Auto-generated method stub
		return movieDAO.isMovieExists(movieId);
	}

	@Override
	public boolean deleteMovie(int movieId) {
		// TODO Auto-generated method stub
		return movieDAO.deleteMovie(movieId);
	}

	@Override
	public boolean updateMovie(Movie movie) {
		// TODO Auto-generated method stub
		return movieDAO.updateMovie(movie);
	}

	@Override
	public List<Movie> getMovies() {
		// TODO Auto-generated method stub
		return movieDAO.getMovies();
	}

	@Override
	public List<Movie> searchMovieByGenre(String movieGenre) {
		// TODO Auto-generated method stub
		return movieDAO.searchMovieByGenre(movieGenre);
	}

	
}
