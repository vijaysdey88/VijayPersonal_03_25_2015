package com.study.hw.week2;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;

import static com.mongodb.client.model.Sorts.*;

import com.study.DBConnection;

public class Homework2_3 {
	
	public static void main(String[] args) {
		MongoCollection<Document> gradesCollection = DBConnection.INSTANCE.getCollection("grades"); 
		Bson typeFilter =  Filters.eq("type", "homework");
		Bson sortBy = ascending("student_id", "score");
		
		int studId = -1;
		for(Document grade : gradesCollection.find(typeFilter).sort(sortBy)) {
			System.out.println(grade);
			int currentStudId = grade.getInteger("student_id");
			if(studId != currentStudId) {
				studId = currentStudId;
				DeleteResult del = gradesCollection.deleteOne(grade);
				System.out.println("Deleted - " + del.getDeletedCount());
			}
		}
		
		System.out.println("After process...");
		for(Document grade : gradesCollection.find(typeFilter).sort(sortBy)) {
			System.out.println(grade);
		}
	}

}
