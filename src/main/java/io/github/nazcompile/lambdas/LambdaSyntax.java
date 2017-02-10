package io.github.nazcompile.lambdas;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class LambdaSyntax {

	//Predicate<String> - Takes one argument and returns a Boolean
	Predicate<String> checkEmpty = (String string) -> string.isEmpty();
	
	//Predicate<String> - Takes two arguments and returns a Boolean. Arguments CAN be of different types
	BiPredicate<String, String> checkEqualStrings = (first, second) -> first.equalsIgnoreCase(second);
	
	// Function<T,R> - Accepts one argument and returns a result. Argument and Result values CAN be different
	Function<String, Integer> strLength = string -> string.length();
	
	// BiFunction<T,U,R> - Accepts two arguments and returns a result. Argument and Result values CAN be different
	BiFunction<Integer, Integer, Integer> adder = (firstVal, secondVal) -> firstVal + secondVal;
	
	//Oh yeah you can even have functions that return functions
	Function<Integer, Predicate<Integer>> isLessThan = pivot -> (number -> number < pivot);
	
	//UnaryOperator<T> - Specialised form Function<T,R> but Argument and Result values CANNOT be different
	UnaryOperator<String> uppercase = string -> string.toUpperCase();
		
	//UnaryOperator<T> - Specialised form BiFunction<T,U,R> but Argument and Result values CANNOT be different
	BinaryOperator<String> combineStrings = (firstStr, secondStr) -> firstStr + " " + secondStr;
	
	// Consumer<T> - Takes a Single Value And Returns No Result
	Consumer<String> printString = System.out::println; 
		
	// BiConsumer<T,U> -  Takes two values and returns no result
	BiConsumer<Integer, String> printKeyValue = (k, v) -> System.out.println("key:" + k + ", value:" + v);
	
	// Supplier - Supplies result(s) (The opposite of a Consumer)
	Supplier<String> sayHello = () -> "Hello!";
	
}
