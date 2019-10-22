package Core_Java;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Apple ob1 = new Apple();
		Ball ob2 = new Ball();
		Cat ob3 = new Cat();
		Dog ob4 = new Dog();
		Elephant ob5 = new Elephant();
		ob1.myApple();
		ob2.myBall();
		ob3.myCat();
		ob4.myDog();
		ob5.myElephant();
		Checking.HelloWorld obj = new Checking.HelloWorld();
		
	}

}

class Apple {
	public void myApple() {
		System.out.println("Display Apple");
	}
}

class Ball {
	public void myBall() {
		System.out.println("Display Ball");
	}
}

class Cat {
	public void myCat() {
		System.out.println("Display Cat");
	}
}

class Dog {
	public void myDog() {
		System.out.println("Display Dog");
	}
}

class Elephant {
	public void myElephant() {
		System.out.println("Display Elephant");
	}
}
