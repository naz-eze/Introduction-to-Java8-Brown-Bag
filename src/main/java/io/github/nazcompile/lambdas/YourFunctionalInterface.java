package io.github.nazcompile.lambdas;

public class YourFunctionalInterface {

	public static void main(String[] args) {
		new YourFunctionalInterface().runSample();
	}
	
	void runSample() {
		Zoo anonZoo = new Zoo( new Animal() {		
			@Override
			public void makeSound() {
				System.out.println("Roar! from Anonymous Inner Class");			
			}
		});
		anonZoo.speak();
		
		Zoo funcZoo = new Zoo( () -> System.out.println("Roar! from Lambda"));
		funcZoo.speak();
	}
	
	@FunctionalInterface
	public interface Animal {
		public void makeSound();
		public String toString();
	}

	public class Zoo {	
		Animal animal;
		
		Zoo(Animal animal) {
			this.animal = animal;
		}
		
		public void speak() {
			animal.makeSound();
		}
	}

}

