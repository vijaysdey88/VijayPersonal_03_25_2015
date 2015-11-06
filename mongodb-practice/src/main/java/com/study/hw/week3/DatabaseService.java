package com.study.hw.week3;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

public final class DatabaseService {
	
	public static final DatabaseService INSTANCE = new DatabaseService();
	
	private final Datastore studentPracticeDS;
	
	private DatabaseService(){
		MongoClient mongo = new MongoClient(new ServerAddress("localhost", 27017));
		Morphia morphia = new Morphia();
		morphia.map(Student.class)
				//.map(Score.class)
				;
		studentPracticeDS = morphia.createDatastore(mongo, "school_practice");
	}

	public Datastore getStudentPracticeDS() {
		return studentPracticeDS;
	}

}
