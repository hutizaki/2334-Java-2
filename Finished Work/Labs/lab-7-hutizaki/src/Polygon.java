public abstract class Polygon extends Shape {
    private double perimeter;
    
    /**
     * Creates a polygon with the given side lengths
     * @param sides array of side lengths
     * @throws IllegalArgumentException if the polygon constraints are violated
     */
    protected Polygon(double... sides) {
        if (sides == null) {
            throw new IllegalArgumentException("null sides");
        }
        
        if (sides.length < 3) {
            throw new IllegalArgumentException("Invalid number of sides: " + sides.length);
        }
        
        double sum = 0;
        for (double side : sides) {
            if (side <= 0) {
                throw new IllegalArgumentException("Nonpositive side: " + side);
            }
            sum += side;
        }
        
        // Check polygon inequality for each side
        for (double side : sides) {
            double otherSidesSum = sum - side;
            if (side >= otherSidesSum) {
                throw new IllegalArgumentException("Polygon inequality violated: " + side + " >= " + otherSidesSum);
            }
        }
        
        // Calculate perimeter
        this.perimeter = sum;
    }
    
    @Override
    public double getPerimeter() {
        return perimeter;
    }
} 