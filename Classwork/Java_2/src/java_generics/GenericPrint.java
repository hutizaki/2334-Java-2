package java_generics;

//TO-DO: Generic class to print arrays


class GenericPrint<T> { // T isnt the actual type of thing, hence the "generic" part


//TO-DO: instance array variable of type T

private T[] array;


//TO-DO: Constructor to initialize the array

GenericPrint(T[] array) {
	this.array = array;
}


//TO-DO: Method to print the array :

public void printArray() {
	for(T element : array) {
		System.out.println(element + " ");
	}
	System.out.println();
}


public static void main(String[] args) {


Integer[] intArray = {14, 72, 83, 51, 9};


Double[] doubleArray = {1.56, 6.2, 31.3, 51.4, 7.9};


String[] stringArray = {"apple", "banana", "cherry"};





//Using GenericPrint class for 3 different types


GenericPrint<Integer> intPrinter = new GenericPrint<>(intArray);


GenericPrint<Double> doublePrinter = new GenericPrint<>(doubleArray);


GenericPrint<String> stringPrinter = new GenericPrint<>(stringArray);





// Testing printArray()


System.out.print("Array of Integers: ");


intPrinter.printArray();





System.out.print("Array of Doubles: ");


doublePrinter.printArray();





System.out.print("Array of Strings: ");


stringPrinter.printArray();


}


}



