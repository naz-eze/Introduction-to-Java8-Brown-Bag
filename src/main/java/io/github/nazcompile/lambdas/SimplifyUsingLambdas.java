package io.github.nazcompile.lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class SimplifyUsingLambdas {
	
	public static void main(String[] args) {
		SimplifyUsingLambdas sul = new SimplifyUsingLambdas();
		List<Integer> values = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		System.out.println(sul.totalValues(values));
		System.out.println(sul.totalOddValues(values));
		System.out.println(sul.totalEvenValues(values));
		
		//Java 8
		/*System.out.println(sul.total(values, e -> true));
		System.out.println(sul.total(values, e -> e % 2 == 0));
		System.out.println(sul.total(values, e -> e % 2 != 0));*/
	}
	
	//Java 8
	/*	public int total(List<Integer> values, Predicate<Integer> selector){
			int result = 0;
			result = values.stream()
						  .filter(selector)
						  .mapToInt(val -> val)
						  .sum();
			return result;
		}*/
	
	public int totalValues(List<Integer> values) {
		int result = 0;
		for (Integer val : values) {
			result += val;
		}
		return result;
	}
	
	public int totalOddValues(List<Integer> values) {
		int result = 0;
		for (Integer val : values) {
			if (val % 2 != 0) {
				result += val;
			}
		}
		return result;
	}
	
	public int totalEvenValues(List<Integer> values) {
		int result = 0;
		for (Integer val : values) {
			if (val % 2 == 0) {
				result += val;
			}
		}
		return result;
	}
	
	
}
