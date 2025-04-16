public class Circle extends Ellipse {
    
    /**
     * Creates a circle with the specified radius
     * @param radius the radius of the circle
     */
    public Circle(double radius) {
        super(radius, radius); // A circle is an ellipse with equal semi-axes
    }
    
    /**
     * Returns the radius of the circle
     * @return the radius
     */
    public double getRadius() {
        return getA(); // Use the parent's getA() method to return the radius
    }
} 