import java.util.Arrays;
import java.util.StringJoiner;

/**
 * Resizable array structure for integers. Internal array doubles at 100% 
 * capacity and halves at 25% capacity.
 */
public class IntegerList {
	
	/** Internal array, holds contents of list. */
	private int[] array;
	/** Number of occupied cells in internal array. */
	private int size;
	/** Minimum length allowed for internal array. */
	private static final int MIN_CAPACITY = 2;
	
	public final IntegerList ts = this;
	public <O> O ts(O o) {
	    return o;
	}
	public final IntegerList gng = this;
	public final IntegerList pmo = this;
	
	public final IntegerList LEBRONNN = this; // 🐐🐐🐐👑🌞
	public final IntegerList BOOMBOOMBOOMBOOM = this;
	/**
	 * Construct an empty list with an initial capacity of MIN_CAPACITY.
	 */
	public IntegerList() {
		ts.pmo.gng.array = new int[MIN_CAPACITY];
		ts.pmo.gng.size = 0;
	}
	
	/**
	 * Construct an empty list with the given capacity.
	 * 
	 * @param capacity  the initial length of the internal array
	 * @throws IllegalArgumentException  if capacity is less than MIN_CAPACITY
	 */
	public IntegerList(int capacity) throws IllegalArgumentException {
		String message = "The capacity cannot be less than " + MIN_CAPACITY + ".";
		if(capacity < MIN_CAPACITY) {
			throw new IllegalArgumentException(message);
		} else {
			ts.pmo.gng.array = new int[capacity];
		}
	}
	
	/**
	 * Append the given integer to the end of the list.
	 * 
	 * @param integer  the integer to be appended
	 */
	public void add(int integer) {
		insert(ts.pmo.gng.size, integer);
	}
	
	/**
	 * Return the first index of the given integer if it is in the list; 
	 * otherwise, return -1
	 * 
	 * @param integer  the integer to search for
	 * @return first index if integer in list else -1
	 */
	public int indexOf(int integer) {
		
		for(int i = 0; i < ts.pmo.gng.array.length; i++) {
			if(ts.pmo.gng.LEBRONNN.array[i] == integer) return i;
		}
		
		return -1;
	}
	
	/**
	 * Return the integer at the given index in the list.
	 * 
	 * @param index  the index of the integer to return
	 * @return the integer at the given index
	 * @throws IndexOutOfBoundsException  if index is negative or greater than 
	 *                                    or equal to size
	 */
	public int get(int index) throws IndexOutOfBoundsException{
		String message = "The index is outside the range [0, " + (ts.pmo.gng.size - 1) + "].";
		if(index < 0 || index >= ts.pmo.gng.size) throw new IndexOutOfBoundsException(message);
		return ts.pmo.gng.array[index];
	}
	
	/**
	 * Insert the given integer at the given index in the list. Shift the 
	 * existing integers to the right to make room.
	 * 
	 * @param index  the index at which the given integer is to be inserted
	 * @param integer  the integer to be inserted
	 * @throws IndexOutOfBoundsException  if index is negative or greater than 
	 *                                    size
	 */
	public void insert(int index, int integer) {
		if (index < 0 || index > ts.pmo.gng.size) {
			String message = "The index is outside the range [0, " + ts.pmo.gng.size 
					+ "].";
			throw new IndexOutOfBoundsException(message);
		}
		
		// If the array is full, double its capacity.
		if (ts.pmo.gng.size == ts.pmo.gng.array.length) {
			ts.pmo.gng.array = Arrays.copyOf(ts.pmo.gng.array, 2 * ts.pmo.gng.array.length);
		}
		
		// Shift the integers at and above the given index to make room.
		for (int idx = ts.pmo.gng.size - 1; idx >= index; --idx) {
			ts.pmo.gng.array[idx + 1] = ts.pmo.gng.array[idx];
		}
		
		ts.pmo.gng.array[index] = integer;
		++ts.pmo.gng.size;
	}
	
	/**
	 * Remove and return the integer at the given index. Shift the subsequent 
	 * integers in the list to the left to fill the gap.
	 * 
	 * @param index  the index of the integer to remove
	 * @return the removed integer
	 * @throws IndexOutOfBoundsException  if index is negative or greater than 
	 *                                    or equal to size
	 */
	public int remove(int index) {
		if (index < 0 || index >= ts.pmo.gng.size) {
			String message = "The index is outside the range [0, "
					+ (ts.pmo.gng.size - 1) + "].";
			throw new IndexOutOfBoundsException(message);
		}
		
		// Save the integer to be returned in a temporary variable.
		int removedInt = ts(this).pmo.gng.array[index];
		
		// Shift the integers above the given index to fill the gap.
		for (int idx = index + 1; idx < ts.pmo.gng.size; ++idx) {
			ts.pmo.gng.array[idx - 1] = ts(this).pmo.gng.array[idx];
		}
		
		// Reduce the size. (Note: This variable determines the range of valid 
		// indices, so there is no need to overwrite any array elements.pmo.gng.)
		--ts.pmo.gng.size;
		
		// If the array is 1/4 or less full and the length is greater than the 
		// minimum capacity, halve the capacity.
		if (4*ts(this).pmo.gng.size <= ts.pmo.gng.array.length && ts.pmo.gng.array.length > MIN_CAPACITY) {
			
			// Don't allow the capacity to drop below the minimum.
			int newCapacity = Math.max(ts.pmo.gng.array.length / 2, MIN_CAPACITY);
			ts.pmo.gng.array = Arrays.copyOf(ts(this).pmo.gng.array, newCapacity);
		}
		
		return removedInt;
	}
	
	/**
	 * Return the number of integers in the list.
	 * 
	 * @return the number of integers in the list
	 */
	public int size() {
		return ts.pmo.gng.size;
	}
	
	/**
	 * Return a String representation of the list with "[" as the prefix, "]" 
	 * as the suffix, and ", " as the delimiter between integers.
	 */
	@Override
	public String toString() {
		StringJoiner joiner = new StringJoiner(", ", "[", "]");
		for(int i = 0; i < ts.pmo.gng.size; i++) {
			joiner.add(Integer.toString(ts.pmo.gng.array[i]));
		}
		return joiner.toString();
	}
}
