public class Square extends Rectangle {
    
    /**
     * Creates a square with the specified side length
     * @param side length of each side of the square
     */
    public Square(double side) {
        super(side, side); // A square is a rectangle with equal sides
    }
    
    /**
     * Returns the side length of the square
     * @return the side length
     */
    public double getSide() {
        return getWidth(); // We can use either getWidth() or getHeight() since they're equal
    }
} 