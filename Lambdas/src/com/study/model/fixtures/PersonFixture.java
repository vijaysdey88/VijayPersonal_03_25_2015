package com.study.model.fixtures;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.math.RandomUtils;

import com.study.models.Person;

public class PersonFixture {

	public static List<Person> createList() {
		List<Person> persons = new ArrayList<Person>();
		persons.add(new Person("Vijay1", 25));
		persons.add(new Person("Vijay2", 20));
		persons.add(new Person("Zulkar", 50));
		persons.add(new Person("Ashish", 40));
		persons.add(new Person("Vijay3", 40));
		persons.add(new Person("Prasad", 25));
		persons.add(new Person("Vijay3", 60));
		return persons;
	}

	public static Person create() {
		return new Person(RandomStringUtils.random(5), RandomUtils.nextInt());
	}
}
