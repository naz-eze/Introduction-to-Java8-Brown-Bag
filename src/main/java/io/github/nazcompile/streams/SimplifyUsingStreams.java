package io.github.nazcompile.streams;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SimplifyUsingStreams {

	private static final String WORD_REGEXP = "[- .:,!]+";
	
	public static void main(String[] args) throws IOException {
		SimplifyUsingStreams sus = new SimplifyUsingStreams();
		String fileName = "sonnet.txt";
		
		System.out.println("Line Count - " + sus.getLineCount(fileName, 0));
		System.out.println("Word Count - " + sus.getWordCount(fileName));
		System.out.println("Sorted Distinct Words  - " + sus.getSortedDistinctWords(fileName));
	}

	public long getLineCount(String fileName, int startingLine) throws IOException {
		long result = 0;
		int counter = 0;

		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String line;
		while ((line = br.readLine()) != null) {
			if (counter >= startingLine) {
				result++;
			} else {
				counter++;
			}
		}
		return result;
		
		//JAVA 8
/*		return Files.lines(Paths.get(fileName))
					.skip(startingLine)
					.count();*/
	}

	public long getWordCount(String fileName) throws IOException {
		long result = 0;
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String line;
		while ((line = br.readLine()) != null) {
			String[] words = line.split(WORD_REGEXP);
			result += words.length;
		}
		return result;		
		
		//JAVA 8 
/*		return Files.lines(Paths.get(fileName))
					.flatMap(line -> Stream.of(line.split(WORD_REGEXP)))
					.count();*/
				
	}

	public List<String> getSortedDistinctWords(String fileName) throws IOException {
		List<String> resultList = new ArrayList<>();
		
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String line;
		while ((line = br.readLine()) != null) {
			String[] wordArr = line.split(WORD_REGEXP);
			for (String word : wordArr) {
				if (!resultList.contains(word)) {
					resultList.add(word);
				}
			}
		}
		resultList.sort( new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return s1.length() - s2.length();
			}
		});

		return resultList;	
		
		//JAVA 8
/*		return Files.lines(Paths.get(fileName))
					.flatMap(line -> Stream.of(line.split(WORD_REGEXP)))
					.distinct()
					.sorted((s1, s2) -> s1.length() - s2.length())
					.collect(Collectors.toList());*/
	}
}
