package com.coen6311.MovieLover.Beans;

import java.util.ArrayList;


public class MovieLover extends User{
	
	private String nickName;
	private ArrayList<Movie> wishList = new ArrayList<>();
	private ArrayList<Comment> commentList = new ArrayList<>();
	

	public String getNickName() {
		return nickName;
	}



	public void setNickName(String nickName) {
		this.nickName = nickName;
	}



	public ArrayList<Movie> getWishList() {
		return wishList;
	}



	public void setWishList(ArrayList<Movie> wishList) {
		this.wishList = wishList;
	}



	public ArrayList<Comment> getCommentList() {
		return commentList;
	}



	public void setCommentList(ArrayList<Comment> commentList) {
		this.commentList = commentList;
	}



	public void getSession() {
		
	}



	@Override
	public String toString() {
		return "MovieLover [nickName=" + nickName + ", wishList=" + wishList + ", commentList=" + commentList
				+ ", email=" + email + ", password=" + password + ", userId=" + userId + "]";
	}

}
