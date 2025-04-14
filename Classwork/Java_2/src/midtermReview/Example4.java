///Using recursion, find the largest number in an integer array
package midtermReview;

public class Example4 {

	public static int findMax(int[] array, int index) {

		if (index == array.length - 1) return array[index];
		
		int max = findMax(array, index + 1);
		
		return Math.max(max, array[index]);

	}
	
	
	public static void main(String[] args) {
		int[] array = {5, 7, 8, 9, 3, 2, 4};
		int max = findMax(array, 0);
		System.out.println("Max number in array: " + max);

	}

}
