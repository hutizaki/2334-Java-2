public class IsoscelesTrapezoid extends Polygon {
    private double top;
    private double base;
    private double leg;
    private double area;
    private double triangleBase;
    private double height;
    
    /**
     * Creates an isosceles trapezoid with the given dimensions
     * @param top length of the top side
     * @param base length of the base side
     * @param leg length of the two equal legs
     */
    public IsoscelesTrapezoid(double top, double base, double leg) {
        // A trapezoid has 4 sides: top, base, and two equal legs
        super(top, base, leg, leg);
        
        this.top = top;
        this.base = base;
        this.leg = leg;
        
        // Calculate the half difference between base and top
        this.triangleBase = Math.abs(base - top) / 2.0;
        
        // Calculate height using the Pythagorean theorem
        this.height = Math.sqrt(leg * leg - triangleBase * triangleBase);
        
        // Calculate area: area = (top + base) * height / 2
        this.area = ((top + base) / 2.0) * height;
    }
    
    // Returns the length of the top side
    public double getTop() {
        return top;
    }
    
    // Returns the length of the base side
    public double getBase() {
        return base;
    }
    
    // Returns the length of the equal legs
    public double getLeg() {
        return leg;
    }
    
    @Override
    public double getArea() {
        return area;
    }
    
    /**
     * Returns the rectangle in the center of the trapezoid
     * The center rectangle has width equal to the smaller parallel side
     * and height equal to the height of the trapezoid
     * @return the center rectangle
     */
    public Rectangle getCenterRectangle() {
        // In a rectangle, the center rectangle is itself
        if (top == base) {
            return new Rectangle(top, height);
        }
        
        // For an isosceles trapezoid, the center rectangle has width = min(top, base)
        double smallerSide = Math.min(top, base);
        return new Rectangle(smallerSide, height);
    }
} 