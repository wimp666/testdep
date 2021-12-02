package com.coen6311.MovieLover.MongoDB;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class Connection {
	public MongoClient mongoClient;
	public MongoDatabase database;

	public Connection() {
		ConnectionString connectionString = new ConnectionString("mongodb+srv://6311:6311MovieLovers@cluster0.zvskl.mongodb.net/6311?retryWrites=true&w=majority");
		MongoClientSettings settings = MongoClientSettings.builder()
        .applyConnectionString(connectionString)
        .build();
		mongoClient = MongoClients.create(settings);
		database = mongoClient.getDatabase("6311");

	}
}
