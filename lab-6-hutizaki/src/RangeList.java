/**
 * A list that represents a range of consecutive integers.
 * Extends IntegerList to provide range-specific operations.
 *
 * @author Bryan Ho
 */
public class RangeList extends IntegerList {
    
    /**
     * Constructs an empty RangeList.
     */
    RangeList() {
        super();
    }
    
    /**
     * Constructs a RangeList and populates it with values in the given range.
     *
     * @param lowerBound --> start of the range (inclusive)
     * @param upperBound --> end of the range (inclusive)
     * @throws IllegalArgumentException --> if lowerBound > upperBound
     */
    RangeList(int lowerBound, int upperBound) {
        super();
        if(lowerBound > upperBound) {
            throw new IllegalArgumentException("The upper bound must be greater than or equal to the lower bound.");
        } else {
            add(lowerBound, upperBound);
        }
    }
    
    /**
     * Adds a range of consecutive integers to the list.
     *
     * @param lowerBound --> start of the range (inclusive)
     * @param upperBound --> end of the range (inclusive)
     * @throws IllegalArgumentException --> if lowerBound > upperBound
     */
    public void add(int lowerBound, int upperBound) {
        if(lowerBound > upperBound) {
            throw new IllegalArgumentException("The upper bound must be greater than or equal to the lower bound.");
        }
        
        if(size() == 0) {
            for(int i = lowerBound; i <= upperBound; i++) {
                super.insert(size(), i);
            }
        }
        
        int min = get(0);
        int max = get(size() - 1);
        
        for(int i = min - 1; i >= lowerBound; i--) {
            super.insert(0, i);
        }
        
        for(int i = max + 1; i <= upperBound; i++) {
            super.insert(size(), i);
        }
    }
    
    /**
     * Removes a range of integers from the list.
     *
     * @param lowerBound --> start of the range (inclusive)
     * @param upperBound --> end of the range (inclusive)
     * @throws IllegalArgumentException --> if bounds are invalid or range is non-terminal
     * @throws UnsupportedOperationException --> if list is empty
     */
    public void remove(int lowerBound, int upperBound) {
        if(lowerBound > upperBound) {
            throw new IllegalArgumentException("The upper bound must be greater than or equal to the lower bound.");
        } else if (size() == 0) {
            throw new UnsupportedOperationException("Cannot remove range from an empty list.");
        } else if(lowerBound < get(0) || upperBound > get(size() - 1)) {
            throw new IllegalArgumentException("Lower and/or upper bounds are out of the current list range.");
        } else if(lowerBound != get(0) && upperBound != get(size() - 1)) {
            throw new IllegalArgumentException("Cannot remove non-terminal ranges.");
        }
        
        for(int i = lowerBound; i <= upperBound; i++) {
            super.remove(indexOf(i));
        }
    }
    
    /**
     * Disabled method
     *
     * @param index 
     * @param integer 
     */
    public void insert(int index, int integer) {
        throw new UnsupportedOperationException();
    }
    
    /**
     * Disabled method
     * 
     * @param integer 
     */
    public void add(int integer) {
    	throw new UnsupportedOperationException();
    }
}