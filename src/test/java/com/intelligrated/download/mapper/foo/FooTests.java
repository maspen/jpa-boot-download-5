package com.intelligrated.download.mapper.foo;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FooTests {

	public static void main(String[] args) {
//		Function<String, String> function1 = x -> x.toUpperCase();
//		Function<String, String> function2 = x -> x.toLowerCase();
//		convertSTring(function1); // STRANGE
//		convertSTring(function2); // strange
		
//		Supplier<String> supplier1 = () -> "String1";
//		Supplier<String> supplier2 = () -> "String2";
//		printSuppliedString(supplier1); // String1
//		printSuppliedString(supplier2); // String2
		
//		Consumer<String> function = x -> System.out.println(x);
//		Consumer<String> function2 = x -> System.out.println(x.toLowerCase());
//		consumeString(function, "StringA"); // StringA
//		consumeString(function2, "StringA"); // stringa
		
		Predicate<Double> function = x -> x > 10;
		Predicate<Double> function2 = x -> x < -10;
		System.out.println(function.test(new Double(9))); // false
		System.out.println(function2.test(new Double(-20))); // true
	}
	
	public static void convertSTring(Function<String, String> function ) {
		System.out.println(function.apply("StRaNgE"));
	}
	
	public static void printSuppliedString(Supplier<String> supplier) {
		System.out.println(supplier.get());
	}
	
	public static void consumeString(Consumer<String> consumer, String x) {
		consumer.accept(x);
	}
	
	public static void testValue(Predicate<Double> predicate, Double d) {
		predicate.test(d);
	}
}
