package com.coen6311.MovieLover.Beans;

import java.util.ArrayList;

public class Movie {
	private String movieName;
	private String movieID;
	private double movieRating;
	private String movieSynopsis;
	private ArrayList<Comment> commentList = new ArrayList<>();
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getMovieID() {
		return movieID;
	}
	public void setMovieID(String movieID) {
		this.movieID = movieID;
	}
	public double getMovieRating() {
		return movieRating;
	}
	public void setMovieRating(double movieRating) {
		this.movieRating = movieRating;
	}
	public String getMovieSynopsis() {
		return movieSynopsis;
	}
	public void setMovieSynopsis(String movieSynopsis) {
		this.movieSynopsis = movieSynopsis;
	}
	public ArrayList<Comment> getCommentList() {
		return commentList;
	}
	public void setCommentList(ArrayList<Comment> commentList) {
		this.commentList = commentList;
	}

	@Override
	public String toString() {
		return "Movie{" +
				"movieName='" + movieName + '\'' +
				", movieID='" + movieID + '\'' +
				", movieRating=" + movieRating +
				", movieSynopsis='" + movieSynopsis + '\'' +
				", commentList=" + commentList +
				'}';
	}

}