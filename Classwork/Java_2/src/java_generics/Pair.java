package java_generics;

// Create generic class, called Pair.
// It has two instance variables (first, second) of type parameter T.
// Define a parameterized constructor
// Define setters and getters

public class Pair <T1, T2> {

	/*
	private T first;  // Same types
	private T second;

	public Pair(T first, T second) {
		this.first = first;
		this.second = second;
	}

	public void setFirst(T first) {
		this.first = first;
	}

	public void setSecond(T second) {
		this.second = second;
	}

	public T getFirst() {
		return first;
	}

	public T getSecond() {
		return second;
	}
	*/

	private T1 first;  // String
	private T2 second; // int

	public Pair(T1 first, T2 second) {
		this.first = first;
		this.second = second;
	}

	public void setFirst(T1 first) {
		this.first = first;
	}

	public void setSecond(T2 second) {
		this.second = second;
	}

	public T1 getFirst() {
		return first;
	}

	public T2 getSecond() {
		return second;
	}

}
