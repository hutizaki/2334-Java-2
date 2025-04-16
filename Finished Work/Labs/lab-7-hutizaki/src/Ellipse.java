public class Ellipse extends Shape {
    private double a; // semi-major axis
    private double b; // semi-minor axis
    
    /**
     * Creates an ellipse with the given semi-major and semi-minor axis lengths
     * @param a semi-major axis length
     * @param b semi-minor axis length
     * @throws IllegalArgumentException if values are invalid
     */
    public Ellipse(double a, double b) {
        if (a <= 0 || b <= 0) {
            throw new IllegalArgumentException("Nonpositive value(s) provided for the constructor");
        }
        if (a < b) {
            throw new IllegalArgumentException("Semi-major axis length cannot be less than semi-minor axis length");
        }
        
        this.a = a;
        this.b = b;
    }
    
    @Override
    public double getArea() {
        // Area of ellipse = π * a * b
        return Math.PI * a * b;
    }
    
    @Override
    public double getPerimeter() {
        // Approximation of ellipse perimeter: 2π * sqrt((a² + b²)/2)
        return 2 * Math.PI * Math.sqrt((a * a + b * b) / 2);
    }
    
    // Returns the semi-major axis length
    public double getA() {
        return a;
    }
    
    // Returns the semi-minor axis length
    public double getB() {
        return b;
    }
} 