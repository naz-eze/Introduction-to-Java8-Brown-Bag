package io.github.nazcompile.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamSources {
	
	class CollectionInterface {
		Stream<Integer> listStream = new ArrayList<Integer>().stream();
		Stream<String> setStream = new HashSet<String>().parallelStream();
	}
	
	class ArrayClass {
		String[] array = {"a", "b", "c", "d"};
		Stream<String> arrayStream = Arrays.stream(array);
	}
	
	class FileClass {
		public Stream<String> readFile() throws IOException {
			Stream<String> lines = Files.lines(Paths.get("somefile.txt"));
			return lines;
		}
	}
	
	class RandomNumbers {
		IntStream randomInts = new Random().ints();
		DoubleStream randomIDoubles = new Random().doubles();
		LongStream randomlings = new Random().longs(20);
	}
	
	class YourOwnObjectStream {
		Stream<Custom> customStream = Stream.of(new Custom("one"), new Custom("two"));
	}
	
	class Custom {
		Custom(String someValue) { /*do something clever */ }
	}
	
}
