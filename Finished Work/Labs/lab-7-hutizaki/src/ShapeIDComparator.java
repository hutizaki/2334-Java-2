import java.util.Comparator;

/**
 * Comparator that orders Shape objects by their ID numbers
 */
public class ShapeIDComparator implements Comparator<Shape> {
    
    /**
     * Compares two shapes by their ID numbers
     * @param s1 the first shape
     * @param s2 the second shape
     * @return negative if s1 has smaller ID, positive if s1 has larger ID, 0 if equal
     */
    @Override
    public int compare(Shape s1, Shape s2) {
        // Compare shapes by their ID numbers in ascending order
        return Integer.compare(s1.getID(), s2.getID());
    }
} 