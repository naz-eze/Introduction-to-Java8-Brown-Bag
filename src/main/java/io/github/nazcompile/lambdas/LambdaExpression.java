package io.github.nazcompile.lambdas;

public class LambdaExpression {

	public static void main(String[] args) {

		//Java8
		Thread threadOne = new Thread(() ->	System.out.println("Running threadOne"));	
		
		//Before Java 8
		Thread threadTwo = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Running threadTwo");
			}
		});
		
		
		threadOne.start();
		threadTwo.start();
		System.out.println("Running main thread");
	}

}
