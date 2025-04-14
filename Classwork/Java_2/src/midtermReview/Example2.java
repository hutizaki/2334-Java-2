package midtermReview;

import java.util.List;

public class Example2 {
	public static int countTarget(List<Integer> numbers, int target, int index) {
		int count = 0;
		if (numbers.size() == index) return count; // base case
		
		if (numbers.get(index) == target) {
			count = 1;
		}
		
		return count + countTarget(numbers, target, index + 1);
	}
	
	public static void main(String[] args) {
		List<Integer> numbers = List.of(4, 6, 2, 4, 3, 5, 7, 2, 3, 4, 5);
		int target = 5;
		int count = countTarget(numbers, target, 0);
		System.out.println("Target count in list: " + count);
	}
}
