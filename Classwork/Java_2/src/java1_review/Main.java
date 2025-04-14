package java1_review;
import java.util.Arrays;
import java.util.Scanner;


public class Main{

	private static String Example1() {
		System.out.println("Enter your favorite vacation spot.");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		System.out.println("You like to vacation at: " + input);
		return input;
	}

	private static int Example2(int[] arr) {

		int total = 0;
		for (int element : arr) {
			if (element > 0) {
				total += element;
			}
		}
		System.out.println("The total for only positive integers: " + total);
		return total;
	}

	public static int[] Example3(int[] arr) {
		int first = 0;
		int last = arr.length - 1;

		while (first < last) {

			int flag = arr[first];
			arr[first] = arr[last];
			arr[last] = flag;

			first++;
			last--;

		}

		System.out.println("Reversed Array: " + Arrays.toString(arr));
		return arr;
	}

	public static void Example4() {
		System.out.println("Please enter a number from 1 - 7: ");
		Scanner scanner = new Scanner(System.in);
		while (true) {
			if (scanner.hasNextInt()) {
				int num = scanner.nextInt();
					if (num >= 1 && num <= 7) {
						switch(num) {

						case 1: System.out.println("Sunday");
							break;
						case 2: System.out.println("Monday");
							break;
						case 3: System.out.println("Tuesday");
							break;
						case 4: System.out.println("Wednesday");
							break;
						case 5: System.out.println("Thursday");
							break;
						case 6: System.out.println("Friday");
							break;
						case 7: System.out.println("Saturday");
							break;
						}
						break;

					} else {
						scanner.nextLine();
						System.out.println("Invalid input. Must be 1 - 7!");
					}

			} else {
				scanner.nextLine();
				System.out.println("Invalid input. Must be 1 - 7!");
			}
		}
	}

	public static void main (String [] args) {

		Example1();

		int[] arr = {56, -9, 6, -2, 77, -345, 89, 90, 234};

		Example2(arr);

		Example3(arr);

		Example4();

		System.out.println("Exiting Code...");
	}

}