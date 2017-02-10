package io.github.nazcompile.other;

public class DefaultMethods {
	
	public static void main (String[] args) {
		new DefaultMethods().runSample();
	}
	
	public void runSample() {
		Naz naz = new Naz();
		naz.trainLegs();
		naz.trainChest();
		naz.trainArms();
	}

	@FunctionalInterface
	interface BodyBuilder {
		default public void trainLegs(){System.out.println("Squatting 40Kg");}
		public void trainChest();
		default public void trainArms(){ System.out.println("Curling 15Kg dumbells");}
	}
	
	class Arnold {
		public void trainArms() { System.out.println("Ya curling 100Kg dumbells");}
	}
	
	interface Footballer {
		default public void trainLegs(){System.out.println("Running at 5 Miles/hr");};
	}
	
	
	class Naz extends Arnold implements BodyBuilder, Footballer {		
		@Override
		public void trainChest() { System.out.println("Benching 100Kg dumbells");}

		@Override
		public void trainLegs() {
			System.out.println("Meh...I'll train chest instead");
		}
	}	


}
