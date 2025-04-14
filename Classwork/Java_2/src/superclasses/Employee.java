package superclasses;

public class Employee extends Person{
	private double salary;
	private String jobTitle;
	// Needs a constructor
	// Must add "name" and "age" from the Person sub-class
	Employee(String name, int age, double salary, String jobTitle){

		super(name, age); // Use "super" to grab variables from the sub-class
		// Must match the subclass constructor as well: 1) name -> 2) age
		this.salary = salary;
		this.jobTitle = jobTitle;
	}

	@Override
	public String toString() {
		return getName() + " " + getAge() + " " + salary + " " + jobTitle;
		// Trying to use name + age here will not work, they are encapsulated or private in the Person class
		// Instead, use the "getter" method to call name and age
	}
	public static void main(String[] args) {
		Employee e1 = new Employee("Tim Cook", 45, 1000000000.1, "CEO");
		// Set the age to 47
		e1.setAge(47);
	}
}
