package com.study.hw.week3;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;

public class Homework3_1Test {
	
	private Datastore studDS = DatabaseService.INSTANCE.getStudentPracticeDS();
	
	
	@Test //@Ignore
	public void shouldStoreStudents() {
		Student stud = new Student();
		int id = 400;
		stud.setId(id);
		String studentName = "Vijay_" + id;
		stud.setName(studentName);
		List<Score> scores = new ArrayList<Score>();
		scores.add(new Score("exam", 123.5));
		scores.add(new Score("homework", 20.8));
		scores.add(new Score("homework", 18.8));
		scores.add(new Score("homework", 10.1));
		scores.add(new Score("homework", 50.8));
		stud.setScores(scores);
		
		studDS.save(stud);
		
		stud = studDS.createQuery(Student.class).filter("name", studentName).get();
		Assert.assertEquals(studentName, stud.getName());
		Assert.assertEquals(scores, stud.getScores());
	}
	
	
	@Test
	public void findAllStudents() {
		Query<Student> q = studDS.createQuery(Student.class);
		List<Student> students = q.asList();
		System.out.println(students);
	}

	@Test
	public void deleteMinHomework() {
		Student stud = studDS.createQuery(Student.class).filter("name", "Vijay_400").get();
		
		deleteMinScore(stud);
	}
	
	@Test
	public void deleteMinScoresOfAllStudents() {
		List<Student> students = studDS.createQuery(Student.class).asList();
		
		students.stream()
		.forEach(this::deleteMinScore);
	}


	private void deleteMinScore(Student stud) {
		List<Score> scores = stud.getScores();
		Optional<Score> minScore = scores.stream()
		.filter((score) ->  score.getType().equals("homework"))
		.collect(Collectors.minBy((s1, s2) -> s1.getScore().compareTo(s2.getScore())));
		
//		System.out.println(minScore);
		System.out.println(scores.remove(minScore.get()));
		studDS.save(stud);
		
//		stud = studDS.createQuery(Student.class).filter("name", "Vijay_400").get();
//		System.out.println("After deletion" + stud);
	}
}
