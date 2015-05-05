package com.study.stream;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

import com.study.model.fixtures.PersonFixture;
import com.study.models.Person;

public class StreamCollectors {
	
	private List<Person> persons;
	
	@Before
	public void setup() {
		persons = PersonFixture.createList();
		System.out.println();
	}
	
	@Test
	public void simplyCollectInListOrSet() {
		List<Person> filteredList = persons.stream()
										.filter(p -> p.getName().startsWith("Vijay"))
										.collect(Collectors.toList());
		System.out.println("Filtered list - " + filteredList);
		
		Set<String> filteredSet = persons.stream()
				.filter(p -> p.getName().startsWith("Vijay"))
				.map(Person::getName)
				.collect(Collectors.toSet());
		System.out.println("Filtered set of names - " + filteredSet);
	}
	
	@Test
	public void groupByCollector() {
		Map<Integer, List<Person>> byAge = persons.stream()
												  .collect(Collectors.groupingBy(Person::getAge));
		System.out.println("Grouped by age " + byAge);
	}
	
	@Test
	public void averagingUsingCollector() {
		double average = persons.stream()
								.collect(Collectors.averagingDouble(p -> Double.valueOf(p.getAge())));
		System.out.println("Average age - " + average);
	}
	
	@Test
	public void intSummaryStatisticsCollector() {
		IntSummaryStatistics stats = persons.stream()
											.collect(Collectors.summarizingInt(Person::getAge));
		System.out.println("Stats - " + stats);
	}
	
	@Test
	public void convertToMapUsingCollector() {
		Map<String, String> map = persons.stream()
										 .collect(Collectors.toMap(p -> p.getName() + p.getAge(), Person::getName));
		System.out.println("Map -- " + map);
	}
	
	@Test(expected=IllegalStateException.class)
	public void toMapThrowsErrorForNonUniqueKeys() {
		Map<String, Integer> nameToAge = persons.stream()
												.collect(Collectors.toMap(Person::getName, Person::getAge));
		System.out.println(nameToAge);
	}
	
	@Test
	public void toMapNotErrorForNonUniqueKeysWhenUsedWithMergeFunction() {
		Map<String, Integer> nameToAge = persons.stream()
												.filter(p -> p.getName().startsWith("Vijay"))
												.collect(
														Collectors.toMap(Person::getName,
																		 Person::getAge,
																		 (age1,age2) -> (age1 + age2)/2)
														);
		System.out.println("Merging duplicate keys :" + nameToAge);
	}

	@Test
	public void joningAllElementsOfListToAPhrase() {
		String phrase = persons.stream()
							   .map(Person::getName)
							   .collect(Collectors.joining(",", "All persons are [", "]..thats it!!!"));
		System.out.println("Joined phrase - " + phrase);
	}

}
