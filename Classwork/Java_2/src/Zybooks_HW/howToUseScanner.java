package Zybooks_HW;
import java.util.Scanner;

public class howToUseScanner{

   public static int findSmallestNum (Scanner scnr) {
// Just like int and Strings, you have to declare the parameter type for Scanner

      int smallest = scnr.nextInt();
// Scanner input will always be accessed with .next***

      while (true) {
         int num = scnr.nextInt();
         if (num > 0) {
            break;
         } else if (num < smallest) {
            smallest = num;
         }
      }
      return smallest;
   }

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int minVal;

		minVal = findSmallestNum(scnr);

		System.out.println(minVal);
	}
}