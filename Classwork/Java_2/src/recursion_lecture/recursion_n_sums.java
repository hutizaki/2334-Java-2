package recursion_lecture;

//public class recursion_n_sums {
	/*
	public static int total = 1;

	public static int sumOfN(int n) {

		if(n <= 0) return -1;

		if(n != 1) {
			total += n;
			sumOfN(n-1);
		}
		System.out.println(total);
		return total;
	}
	*/

	/*
	public static int sum(int n) {
		int total = 0;
		for(int i = 1; i <= n; i++) {
			total += i;
		}
		System.out.println(total);
		return total;
	}
	*/
public class Factorial {
	public static int factorial(int n) {
		int fact;
		if(n > 1) {
			fact = factorial(n - 1) * n;
		} else {
			fact = 1;
		}
		System.out.println(fact);
		return fact;
	}
	public static void main(String[] args) {
		factorial(4);

	}
}
