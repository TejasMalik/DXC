package Core_Java;

public abstract class Animal {
	public abstract void makeNoise();
	public abstract void eat();
	public abstract void roam();
	public abstract void sleep();
}

abstract class Feline extends Animal {
	public void roam() {
		
	}
	
}


abstract class Hippo extends Animal {
	public void makeNoise() {
		
	}
	
	public void eat() {
		
	}
}


abstract class Canine extends Animal {
	public void roam() {
		
	}

}