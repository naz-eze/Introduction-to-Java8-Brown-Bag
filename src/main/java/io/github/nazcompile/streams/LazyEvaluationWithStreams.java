package io.github.nazcompile.streams;

import java.util.Arrays;
import java.util.List;

public class LazyEvaluationWithStreams {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 5, 4, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);

		int result = 0;
		
				numbers.stream()
			   .filter(LazyEvaluationWithStreams::isGreaterThan7)
			   .filter(value -> isEven(value))
			   .map(LazyEvaluationWithStreams::tripleIt);
//				.findFirst().get(); //uncomment and set output to result
		System.out.println("DONE " + result);
	}

	public static boolean isGreaterThan7(int number) {
		System.out.println("isGreaterThan7 " + number);
		return number > 7;
	}

	public static boolean isEven(int number) {
		System.out.println("isEven " + number);
		return number % 2 == 0;
	}

	public static int tripleIt(int number) {
		System.out.println("tripleIt " + number);
		return number * 3;
	}
}
