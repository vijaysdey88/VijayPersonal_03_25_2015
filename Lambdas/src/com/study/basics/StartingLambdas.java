package com.study.basics;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.study.model.fixtures.PersonFixture;
import com.study.models.Person;

public class StartingLambdas {

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("This is old way of creating runnable :(");
			}
		});
		Thread t2 = new Thread( () -> System.out.println("This is new way of creating Runnable :)"));
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println("Main ended");
		
		List<Person> persons = PersonFixture.createList();
		Collections.sort(persons, new Comparator<Person>() {
			@Override
			public int compare(Person p1, Person p2) {
				return p1.getName().compareTo(p2.getName());
			}
		});
		System.out.println("Old way sorting ascending - " + persons);
		Collections.sort(persons, (Person p1, Person p2) -> p2.getName().compareTo(p1.getName()));
		
		//Collections.sort(persons, (p1, p2) -> p2.getName().compareTo(p1.getName()));
	}
}
