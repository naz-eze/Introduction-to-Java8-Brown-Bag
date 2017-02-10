package io.github.nazcompile.streams;

import java.util.Arrays;
import java.util.List;

public class SeriesVsParallelStream {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		long start = System.nanoTime();
		numbers
				.stream()
//			   .parallelStream()  // uncomment but comment stream() to use
			   .filter(e -> e % 2 != 0)
			   .mapToInt(SeriesVsParallelStream::compute)
			   .sum();
		long end = System.nanoTime();
		System.out.println("Time taken(s): " + (end - start) / 1.0e9);
	}

	public static int compute(int number) {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
		}
		return number + 2;
	}

}
