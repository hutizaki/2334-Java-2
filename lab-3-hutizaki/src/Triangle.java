
// Bryan Ho - 113366523

public class Triangle {
	
	private double sideA;
	private double sideB;
	private double sideC;
	
	public static final String POLYGONSHAPE = "Triangle";
	public static final double DEFAULT_SIDE = 1.0;
	
	public Triangle() {
		
		this.sideA = DEFAULT_SIDE;
		this.sideB = DEFAULT_SIDE;
		this.sideC = DEFAULT_SIDE;
		System.out.println("Default triangle made");
	}
	
	public Triangle(double sideA, double sideB, double sideC) {
		
		if (isTriangle(sideA, sideB, sideC)) {
			
			this.sideA = sideA;
			this.sideB = sideB;
			this.sideC = sideC;

		} else {
			
			this.sideA = DEFAULT_SIDE;
			this.sideB = DEFAULT_SIDE;
			this.sideC = DEFAULT_SIDE;
		}
	}
	
	public Triangle(double[] sides) {
		
		if (isTriangle(sides)) {
			
			this.sideA = sides[0];
			this.sideB = sides[1];
			this.sideC = sides[2];
			
		} else {
			
			this.sideA = DEFAULT_SIDE;
			this.sideB = DEFAULT_SIDE;
			this.sideC = DEFAULT_SIDE;
		}
	}
	
	// NOTE: To maintain encapsulation, use the getters '.getSide@()' to
	// reach the variables. Think 'I need to GET an ITEM from the OBJECT'
	// GET = getter, ITEM = side@ or variable, OBJECT = object name or 'triangle'
	// passed in the parameter. This could be T1, T2, etc.
	
public Triangle(Triangle triangle) {
	
		if (triangle == null) {
			
			this.sideA = DEFAULT_SIDE;
			this.sideB = DEFAULT_SIDE;
			this.sideC = DEFAULT_SIDE;
			
		} else {
			
			this.sideA = triangle.getSideA();
			this.sideB = triangle.getSideB();
			this.sideC = triangle.getSideC();
		}
	}
	
	public double getSideA() {
		return sideA;
	}
	
	
	public double getSideB() {
		return sideB;
	}
	
	
	public double getSideC() {
		return sideC;
	}
	
	
	public double[] getSides() {
		double[] sides = {sideA, sideB, sideC};
		return sides;
	}
	
	
	public double getAngleA() {
		return lawOfCosines(sideB, sideC, sideA);
	}
	
	
	public double getAngleB() {
		return lawOfCosines(sideA, sideC, sideB);
	}
	
	
	public double getAngleC() {
		return lawOfCosines(sideA, sideB, sideC);
	}
	
	
	public double[] getAngles() {
		// Recycle the getAngle functions for A, B, C
		double[] angles = {getAngleA(), getAngleB(), getAngleC()};
		return angles;
	}
	
	
	public boolean setSideA(double sideA) {
		
		if (sideA <= 0 || !isTriangle(sideA, sideB, sideC)) {
			System.out.println("Invalid input for side A, no changes made."); 
			return false;
		}
		
		this.sideA = sideA;
		return true;
	}
	
	
	public boolean setSideB(double sideB) {
		
		if (sideB <= 0 || !isTriangle(sideA, sideB, sideC)) {
			System.out.println("Invalid input for side B, no changes made."); 
			return false;
		}
		
		this.sideB = sideB;
		return true;
	}
	
	
	public boolean setSideC(double sideC) {
		
		if (sideC <= 0 || !isTriangle(sideA, sideB, sideC)) {
			System.out.println("Invalid input for side C, no changes made."); 
			return false;
		}
		
		this.sideC = sideC;
		return true;
	}
	
	
	public boolean setSides(double[] sides) {
		
		if (!isTriangle(sides)) {
			System.out.println("Invalid inputs for sides, no changes made."); 
			return false;
		}
		
		this.sideA = sides[0];
		this.sideB = sides[1];
		this.sideC = sides[2];
		System.out.println("All sides were successfully changed!");
		return true;
	}
	
	
	public static boolean isTriangle(double sideA, double sideB, double sideC) {
		// Recycle the isTrangle(double[]) function by creating a new array
		return isTriangle(new double[] {sideA, sideB, sideC}); 
	}
	
	// Main logic for valid triangle
	public static boolean isTriangle(double[] sides) {
		
		// Used for triangle inequality
		double max = 0.00;
		double sum = 0.00;
		
		// First, check for null input and check the length of sides[]
		if (sides == null || sides.length != 3) {
			return false;
		}
		
		// Check for zeros or negative numbers in the array
		for (int i = 0; i < 3; i++) {
			
			// Find the largest side
			if (sides[i] > max) {
				max = sides[i];
			}
			
			if (sides[i] <= 0) {
				return false; // Ends the loop
			}
			
			sum += sides[i];
		}
		
		// Now check for the triangle inequality
		return 2 * max < sum;
	}
	
	// The getAngle@ methods will input side@ as double c, to return angle @
	public static double lawOfCosines(double a, double b, double c) {
		
		double angleC = Math.acos((a * a + b * b - c * c)/(2 * a * b));
		return Math.toDegrees(angleC);
	}
	
	/* 
	NOTE: to use the toString(), you don't put T1.toString();
	Instead, you are creating a replacement of the vanilla Java method toString()
	for the Triangle class, so when you use System.out.print(); the method is
	already called since Java sees the triangle object, then converts it 
	"to a string" using the method below 
	*/
	public String toString() {
		
		String sideA = String.format("%.4f", getSideA());
		String sideB = String.format("%.4f", getSideB());
		String sideC = String.format("%.4f", getSideC());
		
		String string = POLYGONSHAPE + "(" +
						sideA + ", " +
						sideB + ", " +
						sideC + ")";
		return string;
	}
	
	public static void main (String[] args) {
		Triangle T1 = new Triangle();
		System.out.println(T1);
	}
}
