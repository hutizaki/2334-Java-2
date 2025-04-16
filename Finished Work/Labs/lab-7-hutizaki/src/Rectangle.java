public class Rectangle extends IsoscelesTrapezoid {
    
    /**
     * Creates a rectangle with the specified width and height
     * @param width the width of the rectangle
     * @param height the height of the rectangle
     */
    public Rectangle(double width, double height) {
        // A rectangle is a special case of an isosceles trapezoid where top = base
        super(width, width, height);
    }
    
    /**
     * Returns the width of the rectangle
     * @return the width
     */
    public double getWidth() {
        // In a rectangle, width is the same as top and base
        return getTop();
    }
    
    /**
     * Returns the height of the rectangle
     * @return the height
     */
    public double getHeight() {
        // In a rectangle, height is the same as leg
        return getLeg();
    }
} 