package io.github.nazcompile.lambdas

import spock.lang.Specification

class LambdaSyntaxSpec extends Specification {
	
	LambdaSyntax utilFunc
	
	def setup() {
		utilFunc = new LambdaSyntax()
	}
	
	def "Should check empty strings"() {	
		when:
			def result = utilFunc.checkEmpty.test(param)
		then:
			result == expected
		where:
			param	|	expected
			''		|	true
			'hello'	|	false	
	}
	
	def "Should check if two strings are the same"() {
		when:
			def result = utilFunc.checkEqualStrings.test(param1, param2)
		then:
			result == expected
		where:
			param1				|	param2				|	expected
			'world'				|	'world'				|	true
			'I visit the gym'	| 'I train at the gym'	|	false
	}
	
	def "Should return string length"() {
		when:
			def result = utilFunc.strLength.apply(param)
		then:
			result == expected
		where:
			param	|	expected
			''		|	0
			'naz'	|	3
	}
	
	def "Should add two values"() {
		when:
			def result = utilFunc.adder.apply(param1, param2)
		then:
			result == expected
		where:
			param1	|	param2	|	expected
			1		|	  2		|		3
			5		|	  4		|		9
	}
	
	def "Should return input string in uppercase"() {
		when:
			def result = utilFunc.uppercase.apply(param)
		then:
			result == expected
		where:
			param	|	expected
			'bt'	|	'BT'
			'gym'	|	'GYM'
	}
	
	def "Should check if number is less then pivot"() {
		when:
			def result = utilFunc.isLessThan.apply(pivot)
		then:
			result.test(testParam) == expected
		where:
			pivot	|	testParam	|	expected
				4	|	  2			|	true
				10	|	  11		|	false
	}
	
	def "Should return a combination of the arguments"() {
		when:
			def result = utilFunc.combineStrings.apply(param1, param2)
		then:
			result == expected
		where:
			param1	|	param2	|	expected
		   'biceps'	|   'curl'	|	'biceps curl'
			'leg'	|	'press'	|	'leg press'
	}
	
	def "Test to show Consumer in action"() {
		when:
			utilFunc.printString.accept('Hello world!')
		then:
			true
	}
	
	def "Test to show BiConsumer in action"() {
		when:
			utilFunc.printKeyValue.accept(1, 'first')
		then:
			true
	}
	
	def "Should generate random number"() {
		expect:
			utilFunc.sayHello.get() == "Hello!"
	}

}
