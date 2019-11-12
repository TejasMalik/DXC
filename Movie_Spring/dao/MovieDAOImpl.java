package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.model.Movie;
import com.mongodb.WriteResult;

@Repository
public class MovieDAOImpl implements MovieDAO {

	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public boolean addMovie(Movie movie) {
		// TODO Auto-generated method stub
		mongoTemplate.save(movie);
		return true;
	}

	@Override
	public Movie getMovie(int movieId) {
		// TODO Auto-generated method stub
		return mongoTemplate.findById(movieId, Movie.class);
	}

	@Override
	public boolean isMovieExists(int movieId) {
		// TODO Auto-generated method stub
		Movie movie = mongoTemplate.findById(movieId, Movie.class);
		if (movie == null) {
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteMovie(int movieId) {
		// TODO Auto-generated method stub
		Movie movie = new Movie();
		movie.setMovieId(movieId);
		WriteResult writeResult = mongoTemplate.remove(movie);
		int rowsAffected = writeResult.getN();

		if (rowsAffected == 0) {
			return false;
		}
		return true;
	}

	@Override
	public boolean updateMovie(Movie movie) {
		// TODO Auto-generated method stub
		mongoTemplate.save(movie);
		return true;
	}

	@Override
	public List<Movie> getMovies() {
		// TODO Auto-generated method stub
		return mongoTemplate.findAll(Movie.class);
	}

	@Override
	public List<Movie> searchMovieByGenre(String movieGenre) {
		// TODO Auto-generated method stub
		return null;
	}

}
