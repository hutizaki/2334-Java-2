
import java.util.Scanner;

public class insurancePremiumFinder {

// Create a separate method to handle switch case, since switch case does not take operands
   private static int getAgeRange (int age) {
      if (age <= 50) {
         return 1;
      } else if (age <= 81) {
         return 2;
      } else {
         return 3;
      }
   }

   public static int findPremium (int coverage, int age) {
      int ageRange = getAgeRange(age);
// Call the method to 'setup' the value for switch case

      if (coverage < 40000) {
         switch (ageRange) {
            case 1: return 30;
            case 2: return 35;
            case 3: return 40;
         }
      } else if (coverage <= 60000) {
         switch (ageRange) {
            case 1: return 45;
            case 2: return 50;
            case 3: return 65;
         }
      } else {
         switch (ageRange) {
            case 1: return 70;
            case 2: return 75;
            case 3: return 90;
         }
      }
      return -1;
   }

   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      int memberCoverage;
      int memberAge;

      memberCoverage = scnr.nextInt();
      memberAge = scnr.nextInt();

      System.out.println(findPremium(memberCoverage, memberAge));
   }
}