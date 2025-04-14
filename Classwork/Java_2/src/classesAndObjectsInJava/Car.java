package classesAndObjectsInJava;

public class Car {

	private String model;
	private String color;
	private String condition;

	private int year;
	private int miles;
	private double price;

	private static int noWheel = 4;

	Car() {

	}

	Car(String model, String color, String condition, int year, int miles, double price) {
		this.model = model;
		this.color = color;
		this.condition = condition;
		this.year = year;
		this.miles = miles;
		this.price = price;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		if (year > 1885) {
			this.year = year;
		}
	}

	public int getMiles() {
		return miles;
	}

	public void setMiles(int miles) {
		this.miles = miles;
	}
	// toString() gets called when we print an object
	@Override
	public String toString() {
		return model + " " + color + " " + year + " " + miles + " " + condition;
	}
	public static void main(String[] args) {
		// Car c1 = new Car(); Error? // Rewriting as default constructor
		Car c1 = new Car("Tesla", "Black", "Used", 2018, 105000, 57000.0);
		c1.year = 1300;
		// It is better to use the setter, to valid the user input instead of
		//directly changing the variable to something invalid

		c1.setCondition("Fair");
		System.out.println(c1);
	}
}
