package superclasses;

class Animal{
	public void eat() {
		System.out.println("Animals eat food");
	}
	public void eat(String food) {
		System.out.println("Animals eat " + food);
	}
}

public class Dog() extends Animal{
	public void ear (String food, int servings) {
		System.out.println("Dog eats " + food + " servings of " + servings);
	}
	public void eat() {
		System.out.println("Dogs eat bones");
	}

	static void main (String[] args) {
		 Animal a1 = new Animal();
		 a1.eat();
		 a1.eat("grass");

		 Dog dog = new Dog();
		 dog.eat();				// calls overridden method
		 dog.eat("Bones");		// calls the inherited method
		 dog.eat("Bones", 3);

		 Animal dog2 = new Dog(); // superclass as reference type
		 dog2.eat();
	}
}