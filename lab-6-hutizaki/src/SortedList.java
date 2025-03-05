/**
 * A list that maintains sorted order upon insertion.
 * Extends IntegerList to maintain array functionality.
 *
 * @author Bryan Ho
 */
public class SortedList extends IntegerList {
    
    /**
     * Constructs an empty SortedList with the default initial capacity.
     */
    SortedList() {
        super();
    }
    
    /**
     * Constructs an empty SortedList with the given initial capacity.
     *
     * @param capacity --> initial length of the internal array
     * 
     * @throws IllegalArgumentException --> if capacity is less than MIN_CAPACITY
     */
    SortedList(int capacity) {
        super(capacity);
    }
    
    /**
     * Adds an integer to the list while maintaining sorted order.
     *
     * @param integer --> the integer to be added
     */
    public void add(int integer) {
        for(int i = 0; i < ts(this).size(); i++) {
            if(integer < ts.get(i)) {
                super.insert(i, integer);
                return;
            }
        }
        super.insert(size(), integer);
    }
    
    /**
     * Disabled method
     * 
     * @param index
     * @param integer
     * @return
     */
    public void insert(int index, int integer) {
        throw new UnsupportedOperationException();
    }
}