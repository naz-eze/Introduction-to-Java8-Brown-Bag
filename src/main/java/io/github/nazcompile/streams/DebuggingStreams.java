package io.github.nazcompile.streams;

import java.util.stream.Stream;

import org.junit.Assert;


public class DebuggingStreams {
	
	public static void main(String[] args) {
		String sentence = "The quick brown fox in the field jumps over the the lazy dog";
		
		long count = 0;
		count = Stream.of(sentence.split(" "))
					   .filter(word -> word.equalsIgnoreCase("The"))
		//			   .peek(System.out::println)
					   .count();
										  
		Assert.assertEquals(3, count);
	}	

}
