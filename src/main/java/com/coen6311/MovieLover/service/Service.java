package com.coen6311.MovieLover.service;

import java.util.ArrayList;

import com.coen6311.MovieLover.Beans.Comment;
import com.coen6311.MovieLover.Beans.Movie;
import com.coen6311.MovieLover.Beans.MovieLover;
import com.coen6311.MovieLover.MongoDB.Connection;
import com.coen6311.MovieLover.MongoDB.DBService;

public class Service {
	Connection connection = new Connection();
	DBService service = new DBService(connection);
	
	public void addMovie(Movie movie) {
		service.addMovie(movie);
	}
	
	public ArrayList<Movie> getMovieByName(String movieName) {
		return service.getMovieByName(movieName);
	}
	
	public void updateMovie(Movie movie) {
		service.updateMovie(movie);
	}
	
	public void deleteMovie(String movieId) {
		service.deleteMovie(movieId);
	}
	
	public Movie getMovieById(String movieId) {
		return service.getMovieById(movieId);
	}
	
	public void addMovieLover(MovieLover movieLover) {
		service.addMovieLover(movieLover);
	}
	
	public MovieLover getMovieLoverById(String userId) {
		return service.getMovieLoverById(userId);
	}
	
	public void deleteMovieLover(String userId) {
		service.deleteMovieLover(userId);
	}
	
	public void addComment(Comment comment) {
		service.addComment(comment);
	}
	
	public ArrayList<Comment> getCommentsByMovieId(String movieId) {
		return service.getCommentsByMovieId(movieId);
	}
	
	public ArrayList<Comment> getCommentsByUserId(String userId) {
		return service.getCommentsByUserId(userId);
	}
	
	public void updateComment(Comment comment) {
		service.updateComment(comment);
	}
	
	public void deleteComment(String userId, String movieId) {
		service.deleteComment(userId, movieId);
	}
	
	public void addMovieToWishList(String userId, String movieId) {
		service.addMovieToWishList(userId, movieId);
	}
	
	public void deleteMovieFromWishList(String userId, String MovieId) {
		service.deleteMovieFromWishList(userId, MovieId);
	}
}
