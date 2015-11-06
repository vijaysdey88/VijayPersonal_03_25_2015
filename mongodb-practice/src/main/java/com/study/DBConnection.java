package com.study;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public final class DBConnection {
	public static final DBConnection INSTANCE = new DBConnection();
	
	private final MongoDatabase db;

	private DBConnection() {
		MongoClient client = new MongoClient(new ServerAddress("localhost", 27017));
		db = client.getDatabase("students");
	}
	
	public  MongoCollection<Document> getCollection(String collectionName) {
		MongoCollection<Document> coll = db.getCollection(collectionName);
		return coll;
	}
}
