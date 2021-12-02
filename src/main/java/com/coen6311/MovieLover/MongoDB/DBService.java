package com.coen6311.MovieLover.MongoDB;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.coen6311.MovieLover.Beans.*;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;

public class DBService {
	private Connection myConnection;
	private MongoCollection<Document> moviesCollection,movieLoversCollection,commentsCollection;
	
	public DBService(Connection myConnection) {
		this.myConnection = myConnection;
		moviesCollection = myConnection.database.getCollection("Movies");
		movieLoversCollection = myConnection.database.getCollection("MovieLovers");
		commentsCollection = myConnection.database.getCollection("comments");
	}

	public double calAvg(ArrayList<Comment> list) {
		int i = 0;
		int sum = 0;
		if(list.isEmpty())
			return 2.5;
		for(Comment c : list) {
			sum+=c.getRating();
			i++;
		}
		return sum/i;
	}

	//add new movie to database
	public void addMovie(Movie movie) {
		String movieName = movie.getMovieName();
		String movieId = movie.getMovieID();
		String movieSymposis = movie.getMovieSynopsis();
		Document document = new Document("movieName", movieName).  
		         append("movieId", movieId).  
		         append("movieSynposis", movieSymposis).  
		         append("movieRating", 2.5);
		moviesCollection.insertOne(document);  
	}
	

	//get movies by name
    public ArrayList<Movie> getMovieByName(String movieName){
    	FindIterable<Document> findIterable = moviesCollection.find(Filters.eq("movieName",movieName));
		MongoCursor<Document> mongoCursor = findIterable.iterator();
		ArrayList<Movie> movieList = new ArrayList<>();
		while(mongoCursor.hasNext()){  
			Document tempDocument = mongoCursor.next();
			Movie tempMovie = new Movie();
			tempMovie.setMovieID(tempDocument.getString("movieId"));
			tempMovie.setMovieName(tempDocument.getString("movieName"));
			tempMovie.setMovieSynopsis(tempDocument.getString("movieSynopsis"));
			ArrayList<Comment> tempList = getCommentsByMovieId(tempMovie.getMovieID());
			tempMovie.setCommentList(tempList);
			tempMovie.setMovieRating(calAvg(tempList));
			movieList.add(tempMovie); 
	        }
		return movieList;
    }
	
	//get movie info by Id
	public Movie getMovieById(String movieId) {
		Movie movie = new Movie();
		Document temp = moviesCollection.find(Filters.eq("movieId",movieId)).first();
		movie.setMovieID(temp.getString("movieId"));
		movie.setMovieName(temp.getString("movieName"));
		movie.setMovieSynopsis(temp.getString("movieSynopsis"));
		ArrayList<Comment> tempList = getCommentsByMovieId(movieId);
		movie.setCommentList(tempList);
		movie.setMovieRating(calAvg(tempList));
		return movie;
	}
	
	//edit movie
	public void updateMovie(Movie movie) {
		BasicDBObject  document = new BasicDBObject().append("$set",new BasicDBObject().
				append ("movieId", movie.getMovieID()).
				append("movieName",movie.getMovieName()).
				append("movieSynopsis",movie.getMovieSynopsis()));
	    Bson movieIdFilter = Filters.eq("movieId", movie.getMovieID());
		moviesCollection.updateOne(movieIdFilter,document);
	}
	
	//delete movie
	public void deleteMovie(String movieId) {
		Bson movieIdFilter = Filters.eq("movieId", movieId);
	    moviesCollection.deleteOne(movieIdFilter);
	}
	
	//add new MovieLover
	public void addMovieLover(MovieLover movieLover) {
		Document document = new Document("userId", movieLover.getUserId()).
				append("nickName", movieLover.getNickName()).
				append("wishList", movieLover.getWishList()).
				append("password", movieLover.getPassword()).
				append("email", movieLover.getEmail());
		movieLoversCollection.insertOne(document);
	}
	
	//get movieLovers by id
	public MovieLover getMovieLoverById(String userId) {
		Document tempUser = movieLoversCollection.find(Filters.eq("userId",userId)).first();
		MovieLover movieLover = new MovieLover();
		movieLover.setNickName(tempUser.getString("nickName"));
		ArrayList<Movie> wishList = new ArrayList<>();
		ArrayList<String> tempWishList = new ArrayList<>(tempUser.getList("wishList", String.class));
		for(String s : tempWishList) {
			wishList.add(getMovieById(s));
		}
		ArrayList<Comment> commentList = getCommentsByUserId(userId);
		movieLover.setCommentList(commentList);
		movieLover.setWishList(wishList);
		movieLover.setEmail(tempUser.getString("email"));
		movieLover.setUserId(tempUser.getString("userId"));
		movieLover.setPassword(tempUser.getString("password"));
		return movieLover;
	}

	
	//delete MovieLover
	public void deleteMovieLover(String userId) {
		movieLoversCollection.deleteOne(Filters.eq("userId",userId));
	}
	
	//add comment to existing movie
	public void addComment(Comment comment) {
		Document document = new Document("movieId", comment.getMovieId()).
				append("userId",comment.getUserId()).
				append("rating",comment.getRating()).
				append("comment", comment.getComment());
		commentsCollection.insertOne(document);
	}

	
	//get comments
	public ArrayList<Comment> getCommentsByMovieId(String movieId) {
		FindIterable<Document> findIterable = commentsCollection.find(Filters.eq("movieId",movieId));
		MongoCursor<Document> mongoCursor = findIterable.iterator();
		ArrayList<Comment> commentList = new ArrayList<>();
		while(mongoCursor.hasNext()){  
			Document tempDocument = mongoCursor.next();
			Comment tempComment = new Comment(tempDocument.getString("comment"),tempDocument.getInteger("rating"),
					tempDocument.getString("movieId"),tempDocument.getString("userId"));
			commentList.add(tempComment); 
	        }
		return commentList;
	}
	
	public ArrayList<Comment> getCommentsByUserId(String userId) {
		FindIterable<Document> findIterable = commentsCollection.find(Filters.eq("userId",userId));
		MongoCursor<Document> mongoCursor = findIterable.iterator();
		ArrayList<Comment> commentList = new ArrayList<>();
		while(mongoCursor.hasNext()){  
			Document tempDocument = mongoCursor.next();
			Comment tempComment = new Comment(tempDocument.getString("comment"),tempDocument.getInteger("rating"),
					tempDocument.getString("movieId"),tempDocument.getString("userId"));
			commentList.add(tempComment); 
	        }
		return commentList;
	}
	
	//update comment
	public void updateComment(Comment comment) {
		BasicDBObject  document = new BasicDBObject().append("$set",new BasicDBObject().
				append ("movieId", comment.getMovieId()).
				append("userId",comment.getUserId()).
				append("rating",comment.getRating()).
				append("comment", comment.getComment())
				);
		Bson userIdFilter = Filters.eq("userId", comment.getUserId());
	    Bson movieIdFilter = Filters.eq("movieId", comment.getMovieId());
		commentsCollection.updateOne(Filters.and(userIdFilter,movieIdFilter),document);
	}
	
	//delete comment
	public void deleteComment(String userId,String movieId) {
		Bson userIdFilter = Filters.eq("userId", userId);
	    Bson movieIdFilter = Filters.eq("movieId", movieId);
	    commentsCollection.deleteOne(Filters.and(userIdFilter,movieIdFilter));
	}
	
	//add movie to wishList
	public void addMovieToWishList(String userId, String movieId) {
		BasicDBObject  document = new BasicDBObject().append("$addToSet",new BasicDBObject().
				append ("wishList", movieId));
		Bson userIdFilter = Filters.eq("userId", userId);
		movieLoversCollection.updateOne(userIdFilter, document);
	}
	
	//delete movie from wishList
	public void deleteMovieFromWishList(String userId, String movieId) {
		BasicDBObject  document = new BasicDBObject().append("$pull",new BasicDBObject().
				append ("wishList", movieId));
		Bson userIdFilter = Filters.eq("userId", userId);
		movieLoversCollection.updateOne(userIdFilter, document);
	}
}
