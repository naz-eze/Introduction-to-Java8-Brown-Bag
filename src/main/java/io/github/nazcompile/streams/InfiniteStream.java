package io.github.nazcompile.streams;

import java.util.stream.Stream;

public class InfiniteStream {

	public static void main(String[] args) {
		Stream<Integer> infiniteStream = Stream.iterate(21, e -> e + 1);
		System.out.println(infiniteStream);
		
		double result = infiniteStream.filter(val -> val % 2 == 0)
								.filter(val -> val > 43)
				                .limit(60) 
				                .reduce(0, (sum, next) -> sum + next);	
		System.out.println(result);
				
	}
	
}
