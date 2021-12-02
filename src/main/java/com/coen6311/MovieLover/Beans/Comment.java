package com.coen6311.MovieLover.Beans;

public class Comment {
	private String comment;
	private String userId;
	private String movieId;
	private int rating;
	
	public Comment(String comment, int rating, String movieId, String userId) {
		this.comment = comment;
		this.rating = rating;
		this.movieId = movieId;
		this.userId = userId;
	}
	
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getUserId() {
		return userId;
	}
	public void setMovielover(String userId) {
		this.userId = userId;
	}
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}


	@Override
	public String toString() {
		return "Comment{" +
				"comment='" + comment + '\'' +
				", userId='" + userId + '\'' +
				", movieId='" + movieId + '\'' +
				", rating=" + rating +
				'}';
	}

	

}
