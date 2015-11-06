package com.study.driver;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.math.RandomUtils;
import org.bson.Document;

import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.*;
import com.study.DBConnection;

public class InsertDocument {

	
	public static void main(String[] args) {
		String collectionName = "persons";
		MongoCollection<Document> coll = DBConnection.INSTANCE.getCollection(collectionName);
		
		List<String> hobies = new ArrayList<String>();
		hobies.add("sing");
		hobies.add("read");
		String name = "Vijay Hobbiesest_"+ RandomUtils.nextInt(100);
		Document person = new Document()
									.append("name", name)
									.append("age", RandomUtils.nextInt(100))
									//.append("hobbies", hobies)
									.append("created", new Date());
		coll.insertOne(person);
		System.out.println(person);
		
		Document address = new Document("street", "fatima nagar")
		.append("soc", "pleasant park2");
		
		coll.updateOne(eq("name", name), new Document("$push", new Document("addresses", address)));
		for(Document doc : coll.find()
		.sort(new Document("created", -1))
		.limit(3)) {
			System.out.println(doc);
		}
		
		//addPost("test", "test", new ArrayList(), "vd");
	}
	
	
	 public static String addPost(String title, String body, List tags, String username) {
		 	MongoCollection<Document> postsCollection = DBConnection.INSTANCE.getCollection("testposts");	

	        System.out.println("inserting blog entry " + title + " " + body);

	        String permalink = title.replaceAll("\\s", "_"); // whitespace becomes _
	        permalink = permalink.replaceAll("\\W", ""); // get rid of non alphanumeric
	        permalink = permalink.toLowerCase();
	        permalink = permalink+ (new Date()).getTime();


	        // todo XXX
	        // Remember that a valid post has the following keys:
	        // author, body, permalink, tags, comments, date
	        //
	        // A few hints:
	        // - Don't forget to create an empty list of comments
	        // - for the value of the date key, today's datetime is fine.
	        // - tags are already in list form that implements suitable interface.
	        // - we created the permalink for you above.

	        // Build the post object and insert it
	        Document post = new Document();
	        post.append("title", title)
	        .append("author", username)
	        .append("body", body)
	        .append("permalink", permalink)
	        .append("tags", tags)
	        .append("comments", new ArrayList<String>())
	        .append("date", new Date());
	        postsCollection.insertOne(post);

	        return permalink;
	    }


}
