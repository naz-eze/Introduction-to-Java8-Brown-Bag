package io.github.nazcompile.streams

import spock.lang.Specification

class SimplifyingUsingStreamsSpec extends Specification {

	SimplifyUsingStreams so
	
	def setup() {
		so = new SimplifyUsingStreams()
	}
	
	def "Should be able to get line count"() {
		given:
			def sonnet = 'sonnet.txt'
		when:
			def result = so.getLineCount(sonnet, 0)
		then:
			result == 3
	}
	
	def "Should be able to get word count"() {
		given:
			def sonnet = 'sonnet.txt'
		when:
			def result = so.getWordCount(sonnet)
		then:
			result == 24
	}
	
	def "Should return list of sorted distinct words"() {
		given:
			def sonnet = 'sonnet.txt'
		when:
			def result = so.getSortedDistinctWords(sonnet)
		then:
			result == ["a", "my", "of", "How", "the", "like",
						 "hath", "been", "From", "thee", "year", 
						 "winter", "absence", "pleasure", "fleeting"]

	}
	
}
