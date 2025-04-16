public abstract class Shape implements Comparable<Shape> {

	private int id;
	private static int nextID = 0;
	
	Shape(){
		id = nextID;
		nextID++;
	}
	
	public int getID() {
		return id;
	}
	
	// Returns the perimeter of the shape
	public abstract double getPerimeter();
	
	// Returns the area of the shape
	public abstract double getArea();
	
	@Override
	public int compareTo(Shape other) {
		// First compare by class name
		int typeComparison = this.getClass().getName().compareTo(other.getClass().getName());
		if (typeComparison != 0) {
			return typeComparison;
		}
		
		// If types are the same, compare by perimeter
		double perimeterDiff = this.getPerimeter() - other.getPerimeter();
		if (Math.abs(perimeterDiff) > 0.0001) {  // Using a small epsilon for double comparison
			return perimeterDiff < 0 ? -1 : 1;
		}
		
		// If perimeters are the same, compare by area
		double areaDiff = this.getArea() - other.getArea();
		if (Math.abs(areaDiff) > 0.0001) {  // Using a small epsilon for double comparison
			return areaDiff < 0 ? -1 : 1;
		}
		
		// If all are the same, return 0 (equal)
		return 0;
	}
	
	@Override
	public String toString() {
		return "<"
				+ getClass().getName()
				+ ", ID: " + id
				+ ", PERIMETER: " + String.format("%.1f", getPerimeter())
				+ ", AREA: " + String.format("%.1f", getArea())
				+ ">";
	}
}