package collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class queue {

	public static void main(String[] args) {
		// Make a HashSet
		HashSet<Integer> numbers = new HashSet<>();
		numbers.add(45);
		numbers.add(56);
		numbers.add(25);
		numbers.add(71);

		System.out.println("Initial HashSet: " + numbers);

		//Create a LinkedHashSet
		LinkedHashSet<Integer> numbers2 = new LinkedHashSet<>(5);
		numbers2.add(43);
		numbers2.add(89);
		numbers2.add(99);

		System.out.println("Initial LinkedHashSet: " + numbers2);

		//Create a TreeSet
		TreeSet<Integer> numbers3 = new TreeSet<>();
		numbers3.add(7);
		numbers3.add(46);
		numbers3.add(21);
		numbers3.add(4);
		numbers3.add(18);

		System.out.println("TreeSet: " + numbers3);
	}

}
