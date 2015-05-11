package com.study.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Test;

import com.study.models.Person;

public class FlatMapOperations {

	@Test
	public void flatMapToNavigateOverMultipleStreamsAsASingle() {
		Stream<Library> libStream = IntStream.range(1, 6)
											 .mapToObj(i -> new Library("Lib" + i))
											 .peek(lib -> IntStream.range(1, 4)
													 				.mapToObj(i -> new Person((lib.name + "-person" + i), i*10))
													 				.forEach(lib::addPerson));
		libStream.flatMap(lib -> lib.persons.stream())
				 .forEach(l -> System.out.println(l.getName()));
	}

	private class Library {
		private final String name;
		private final List<Person> persons = new ArrayList<Person>();


		public Library(String name) {
			this.name = name;
		}

		public void addPerson(Person person) {
			this.persons.add(person);
		}
	}

}
