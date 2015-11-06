package com.study.driver;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;

import static com.mongodb.client.model.Projections.*;
import static com.mongodb.client.model.Filters.*;

import com.study.DBConnection;

public class FindBasics {

	public static void main(String[] args) {
		MongoCollection<Document> cricketers = DBConnection.INSTANCE.getCollection("cricketers"); 
		cricketers.drop();
		
		List<Document> crics = IntStream.range(0, 50)
										.mapToObj(i -> new Document("name", "Sachin " + i)
										.append("score", 100 * i)
										.append("state", RandomStringUtils.randomAlphabetic(3)))
										.collect(Collectors.toList());
		cricketers.insertMany(crics);
		
//		for(Document doc : cricketers.find(new Document("score", new Document("$gte", 4700)))) {
//			System.out.println(doc);
//		}
		
		List<Document> res = cricketers
				.find(and(gt("name", "Sachin 20"), gt("score", 4000)))
				.projection(fields(include("name", "state"), exclude("_id")))
				.into(new ArrayList<Document>());
		for(Document doc : res) {
			System.out.println(doc);
		}
		
		
	}

}
