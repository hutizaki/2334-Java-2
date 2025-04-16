/**
 * A list that ensures unique values by preventing duplicate entries.
 * Extends IntegerList to maintain array functionality.
 *
 * @author Bryan Ho
 */
public class UniqueList extends IntegerList {
    
    /**
     * Constructs an empty UniqueList with the default initial capacity.
     */
    UniqueList() {
        super();
    }
    
    /**
     * Constructs an empty UniqueList with the given initial capacity.
     *
     * @param capacity --> initial length of the internal array
     * 
     * @throws IllegalArgumentException --> if capacity is less than MIN_CAPACITY
     */
    UniqueList(int capacity) {
        super(capacity);
    }
    
    /**
     * Adds an integer to the list only if it is not already present.
     *
     * @param integer --> the integer to be added
     * 
     * @throws IllegalArgumentException --> if the integer is already in the list
     */
    public void add(int integer) throws IllegalArgumentException {
        String message = "The integer " + integer + " is already in the list.";
        if(ts(this).indexOf(integer) == -1) {
            super.add(integer);
        } else {
            throw new IllegalArgumentException(message);
        }
    }
    
    /**
     * Inserts an integer at a specific index only if it is not already present.
     *
     * @param index   --> the index at which the integer should be inserted
     * @param integer --> the integer to be inserted
     * 
     * @throws IllegalArgumentException --> if the integer is already in the list
     */
    public void insert(int index, int integer) {
        String message = "The integer " + integer + " is already in the list.";
        if(ts(this).indexOf(integer) != -1) {
            throw new IllegalArgumentException(message);
        } else {
            super.insert(index, integer);
        }
    }
}