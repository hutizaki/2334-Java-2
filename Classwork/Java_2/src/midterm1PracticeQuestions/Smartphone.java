package midterm1PracticeQuestions;



/*Midterm 1 Practice Questions

1. Write a Java program to create a class called Smartphone with private instance variables
   brand, model, and storageCapacity. Provide public getter and setter methods to access and
   modify these variables. Add a method called increaseStorage() that takes an integer value and
   increases the storageCapacity by that value.*/

public class Smartphone{

	  private String brand;
	  private String model;
	  private int storageCapacity;

	  public void setBrand(String brand) {
	    this.brand = brand;
	  }

	  public String getBrand() {
	    return brand;
	  }

	  public void setModel(String model) {
	    this.model = model;
	  }

	  public String getModel() {
	    return model;
	  }

	  public void setStorageCapacity(int sc) {
	    int copy = sc;
	    storageCapacity = copy;
	  }

	  public int getStorageCapacity() {
	    int copy = this.storageCapacity;
	    return copy;
	  }

	  public void increaseStorage(int as) {
	    if(as > 0) {
	      this.storageCapacity += as;
	    }
	  }
	}





/*2. Write a Java program to create a class called "BankAccount" with instance variables 'accountNumber'
     and balance, and static variables 'bankName' and 'interestRate'. Provide static methods to get and
     set the static variables. Create several 'BankAccount' objects and print their details along with
     the static variables.*/




/*3. Write a Java program that reads a list of integers from the user and throws an exception if any numbers
     are duplicates.*/




/*4. Write a Java program that creates a class hierarchy for employees of a company.
     The base class should be Employee, with subclass Manager. Each subclass should have properties such as
     name, address, salary, and job title. Implement methods for calculating bonuses, generating performance
     reports, and managing projects.*/




/*5. Create a generic Pair<K, V> class that holds a key-value pair. Implement getter methods and a
     swap() method to swap the key and value.*/




/*6. Write a Java program to create a method that takes a string as input and throws an exception if the
     string does not contain vowels.*/




/*7. Write a Java program to create an abstract class Shape with abstract methods calculateArea() and
     calculatePerimeter(). Create subclasses Circle and Triangle that extend the Shape class and implement
     the respective methods to calculate the area and perimeter of each shape.*/

	public abstract class Shape {

		  abstract double calculateArea();

		  abstract double calculatePerimeter();
		}

		public class Circle extends Shape {
		  private double radius;

		  public Circle(double radius) {
		    this.radius = radius;
		  }

		  @Override
		  double calculateArea() {
		    return Math.PI * radius * radius;
		  }

		  @Override
		  double calculatePerimeter() {
		    return Math.PI * radius * 2;
		  }
		}

		public class Triangle extends Shape {

		}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
