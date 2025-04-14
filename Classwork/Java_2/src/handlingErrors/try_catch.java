package handlingErrors;

import java.util.Scanner;

public class try_catch {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter first integer: ");
		int x = sc.nextInt();
		System.out.println("Enter second integer: ");
		int y =sc.nextInt();

		try
		{
			int result = x / y; // This line will automatically create an exception error object with 23/0
			int[] array = new int[y]; // This line will do the same, with 23/-5, because you cannot have a negative size array.
		}
		catch(ArithmeticException e)
		{
			System.out.println("Cannot divide by zero!!");
		}
		catch(NegativeArraySizeException e)
		{
			System.out.println("Need a positive array size!");
		} // We won't always remember all of the exception names so we can use the "parent" class - Exception!
		catch (Exception e)
		{
			System.out.println(e);
		}
		// finally {
		//System.out.println("Could not handle exceptions!"); Used at the end if you are unsure of the remaining errors
		//}
	}
}
