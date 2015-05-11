package com.study.stream;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collector;

import org.junit.Before;
import org.junit.Test;

import com.study.model.fixtures.PersonFixture;
import com.study.models.Person;

public class CustomCollector {
	
	private List<Person> persons;
	
	private Collector<Person, StringJoiner, String> formattedPersonCollector = 
																Collector.of(
																		() ->  {												//Supplier
																				 System.out.println("Inside supplier...");
																				 return new StringJoiner(" | "); },				 
																		(c, p) -> c.add(p.getName() + ":" + p.getAge()), 		//Accumulator
																		(c1, c2) -> {											//Combiner
																						System.out.println("Inside combiner...");
																						return c1.merge(c2);
																					}, 	   
																		(c) -> c.toString());		  							 //Finisher
	
	private Collector<Person, MaxContainer, Person> eldestPerson = 
														Collector.of(
																MaxContainer::new,
																MaxContainer::add,
																MaxContainer::merge, 
																MaxContainer::getResult);

	
	@Before
	public void setup() {
		persons = PersonFixture.createList();
		System.out.println();
	}
	
	@Test
	public void customCollectorToCollectFormattedPersons() {
		String formattedString = persons
									.stream()
									.collect(formattedPersonCollector);
		System.out.println("Formatted string - " + formattedString);
	}
	
	
	//Creates multiple containers using 'Supplier' and combines them using 'Combiner'
	@Test
	public void customCollectorToCollectFormattedPersonsProcessParallel() {
		String formattedString = persons
									.parallelStream()
									.collect(formattedPersonCollector);
		System.out.println("Formatted string - " + formattedString);
	}
	
	
	@Test
	public void useCustomerCollectorWithCustomContainerToFindMaxAge() {
		Person eldest = persons
							.stream()
							.collect(eldestPerson);
		System.out.println("Eldest - " + eldest);
			
	}
	
	private static class MaxContainer {
		private Person eldest = null;
		
		private void add(Person p) {
			if(null == eldest || p.getAge() > eldest.getAge()) {
				eldest = p;
			}
		}
		
		private MaxContainer merge(MaxContainer other) {
			if(other.eldest.getAge() > this.eldest.getAge()) {
				this.eldest = other.eldest;
			}
			return this;
		}
		
		private Person getResult() {
			return eldest;
		}
	}
	
}
