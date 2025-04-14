package handlingErrors;
import java.util.Scanner;

//Create InvalidAgeException that is thrown when age is negative



//Rules:
//1. Must extend either Exception or RuntimeException classes
//2. Set a string parameter constructor
//3. Invoke the parent class constructor using super()

class InvalidAgeException extends Exception {
 InvalidAgeException(String message) {
     super(message);
 }
}

//Create a class where age is tested for its validity when the user inputs age


public class Practice0 {

 public static void checkAge(int age) throws InvalidAgeException {
     if (age < 0) {
         throw new InvalidAgeException("Age cannot be negative");
     }
 }

 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     System.out.print("Enter the age: ");
     int age = sc.nextInt();

     try {
         checkAge(age);
     } catch (InvalidAgeException e) {
         e.printStackTrace();
     }

     sc.close();
 }
}

