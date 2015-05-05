package com.study.basics;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.junit.Before;
import org.junit.Test;

import com.study.model.fixtures.PersonFixture;
import com.study.models.Person;

public class FilteringUsingPredicate {

	private List<Person> personsOrignal;
	private List<Person> personsFiltered;

	@Before
	public void setup() {
		personsOrignal = PersonFixture.createList();
		personsFiltered = new ArrayList<Person>();
		System.out.println("\nOriginal - " + personsOrignal);
	}

	@Test
	public void filterAll() {
		Predicate<Person> filterAll = p -> true;

		for (int i = 0; i < personsOrignal.size(); i++) {
			if (!filterAll.test(personsOrignal.get(i))) {
				personsFiltered.add(personsOrignal.get(i));
			}
		}
		System.out.println("Filtered all- " + personsFiltered);
	}

	@Test
	public void filterByName() {
		// Case 2
		personsOrignal = PersonFixture.createList();
		Predicate<Person> filterByName = p -> !p.getName().startsWith("Vijay");
		for (int i = 0; i < personsOrignal.size(); i++) {
			if (!filterByName.test(personsOrignal.get(i))) {
				personsFiltered.add(personsOrignal.get(i));
			}
		}
		System.out.println("Filtered by name- " + personsFiltered);

		/*
		 * try { for (Person p : all) { if (!namePredicate.test(p)) {
		 * all.remove(p); } } } catch (Exception e) {
		 * System.out.println("Filtered - " + all); }
		 */
	}

	@Test
	public void filterUsingDirectApiOnOriginalList() {
		Predicate<Person> filterByName = p -> !p.getName().startsWith("Vijay");
		personsOrignal.removeIf(filterByName);
		System.out.println("Filtered directly using api by name- " + personsOrignal);
	}

}
