package com.coen6311.MovieLover;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.coen6311.MovieLover.Beans.Comment;
import com.coen6311.MovieLover.Beans.Movie;

import com.coen6311.MovieLover.Beans.MovieLover;
import com.coen6311.MovieLover.MongoDB.Connection;
import com.coen6311.MovieLover.MongoDB.DBService;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;


@SpringBootApplication
public class MovieLoversApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieLoversApplication.class, args);
	}

}
