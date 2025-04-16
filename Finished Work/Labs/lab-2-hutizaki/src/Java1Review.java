import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.HashMap;
/**
 * Implement each of the 10 methods tested in JUnitTests.java. Study the tests
 * to determine how the methods should work.
 */
public class Java1Review {
	
	public static void toLowerCase(String[] str_arr) {
		
		for (int i = 0; i < str_arr.length; i++) {
			str_arr[i] = str_arr[i].toLowerCase();
		}
		return;
	}
	
	public static Double divide(double d, double e) {
		
		if (e == 0) {
			return Double.POSITIVE_INFINITY;
		}
		return d / e;
	}
	
	public static int divide(int d, int e) {
		
		return d / e;
	}
	
	public static Boolean isDivisibleBy7(int i) {
		
		if (i % 7 == 0) {
			return true;
		}
		return false;
	}
	
	public static String[] toLowerCaseCopy(String[] str_arr) {
		
		String[] result = new String[str_arr.length];
		
		for (int i = 0; i < str_arr.length; i++) {
			result[i] = str_arr[i].toLowerCase();
		}
		return result;
	}

	public static void removeDuplicates(int[] array) {
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for (Integer num: array) {
			if (!map.containsKey(num)) {
				map.put(num, 1);
			} else {
				int freq = map.get(num) + 1;
				map.put(num, freq);
			}
		}
		
		for (int i = 0; i < array.length; i++) {
			if (map.get(array[i]) != 1) {
				array[i] = 0;
			}
		}
		return; 
	}

	public static Double average(int[] array) {
		
		double divisor = array.length;
		double sum = 0.0;
		for (int num: array) {
			sum+= num;
		}
		return sum / divisor;
	}

	public static int findMin(int a, int b, int c) {
		return findMin(new int[] {a, b, c}); 
	}

	public static Integer findMin(int[] array) {
		
		int min = array[0];
		for (int num: array) {
			if (num < min) {
				min = num;
			}
		}
		return min;
	}

	public static String main(String string) {
		
		return "Overloaded main method was passed \"" + string + "\".";
	}
	
	public static void main(String[] args) {
		// If you want to write your own tests, do so here. (Do not modify
		// JUnitTests.java.) To run this method in Eclipse, right-click
		// Java1Review.java in the Package Explorer and select "Run As" >
		// "Java Application" from the context menu.
	}
}
