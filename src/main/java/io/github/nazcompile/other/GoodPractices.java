package io.github.nazcompile.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GoodPractices {

	public static void main(String[] args) {
		lambdaUse();
		sharedMutability();
	}
	
	public static void lambdaUse() {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		//wrong way to do this
		numbers.stream()
				.forEach(val -> {
					if (val % 2 == 0) {
						if (val > 6 && val < 10) {
							System.out.println(val);
						}
					}
				});
		//better but not there yet
		numbers.stream()
				.filter(val -> val % 2 == 0 && val > 6 && val < 10)
				.forEach(System.out::println);
		
		//wayyy better
		numbers.stream()
			   .filter(val -> val % 2 == 0)
			   .filter(val -> val > 6)
			   .filter(val -> val < 10)
			   .forEach(System.out::println);
	}
	
	public static void sharedMutability() {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
	    
	    //wrong way to do this.
	    List<Integer> doubleOfEven = new ArrayList<>();
	    numbers.stream()
	           .filter(val -> val % 2 == 0)
	           .map(val -> val * 2)
	           .forEach(val -> doubleOfEven.add(val));	        
	    System.out.println(doubleOfEven);
	    
	    //right way to do it
	    List<Integer> doubleOfEven2 =
	      numbers.stream()
	      		 .filter(val -> val % 2 == 0)
	      		 .map(val -> val * 2)
	      		 .collect(Collectors.toList());
	    System.out.println(doubleOfEven2);
	}

}
