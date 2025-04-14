package java_generics;

import java.util.Scanner;

// Implement a class [with main method], called GenericPairDemo.
// Create an object (secret password) with “Happy” & “Day”
// Create another object (guessed password) using the words from the user
// Check if these 2 objects match

public class GenericPairDemo {

	public static void main(String[] args) {

	// Store the secret password
	Pair<String, String> secret = new Pair<>("Happy", "Day");

	// Ask the user to input 2 words
	Scanner scn = new Scanner(System.in);

	System.out.println("Enter first word: ");
	String f = scn.next();
	System.out.println("Enter second word: ");
	String s = scn.next();

	Pair<String, String> guess = new Pair<>(f, s);

	if(secret.getFirst().equals(guess.getFirst()) &&
			(secret.getSecond().equals(guess.getSecond()) )) {
		System.out.println("You guessed the password!");
	}
	}
}
