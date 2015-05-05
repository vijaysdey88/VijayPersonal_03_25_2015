package com.study.stream;

import java.util.function.Supplier;
import java.util.stream.Stream;

import org.junit.Test;

import com.study.model.fixtures.PersonFixture;
import com.study.models.Person;

public class ReUseStream {

	@Test(expected = IllegalStateException.class)
	public void cannotReuseStreamDirectly() {
		Stream<String> strStream = Stream.of("b", "a", "c");
		strStream.anyMatch(s -> s.startsWith("a"));
		strStream.forEach(System.out::println);
	}

	@Test
	public void reuseStreamUsingStreamSupplier() {
		Supplier<Stream<String>> streamSupplier = () -> {
			return Stream.of("b", "a", "c")
						 .sorted()
						 .map(String::toUpperCase);
			};

		Stream<String> s1 = streamSupplier.get();
		s1.filter(s -> s.startsWith("A"))
		  .forEach(System.out::println);

		Stream<String> s2 = streamSupplier.get();
		s2.forEach(System.out::println);
	}

	@Test
	public void streamSupplierUsingClosure() {
		String[] values = { "b", "a", "c" };
		Supplier<Stream<String>> supplier1 = getStreamSupplier(values, "s1");
		Stream<String> s1 = supplier1.get();
		s1.filter(s -> s.contains("a")).forEach(System.out::println);

		Supplier<Stream<String>> supplier2 = getStreamSupplier(values, "s2");
		Stream<String> s2 = supplier2.get();
		s2.forEach(System.out::println);

	}
	
	@Test
	public void hideousStreamSupplierUsingMutableClosure() {
		Person p1 = PersonFixture.create();
		String[] values = { "b", "a", "c" };

		Supplier<Stream<String>> supplier1 = getStreamSupplier(values, p1);
		Stream<String> s1 = supplier1.get();
		s1.forEach(System.out::println);
		
		s1 = supplier1.get();
		p1.setName("VijayNew");
		s1.forEach(System.out::println);
	}

	// Note closed prepend filed is not final
	private Supplier<Stream<String>> getStreamSupplier(String[] values, String prepend) {
		Supplier<Stream<String>> streamSupplier = () -> {
			return Stream.of(values)
						 .sorted()
						 .map(s -> prepend + s);
			};
		return streamSupplier;
	}
	
	private Supplier<Stream<String>> getStreamSupplier(String[] values, Person person) {
		Supplier<Stream<String>> streamSupplier = () -> {
			return Stream.of(values)
						 .sorted()
						 .map(s -> person.getName() + "-" + s);
			};
		return streamSupplier;
	}
	
}
