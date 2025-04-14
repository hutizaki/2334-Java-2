package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class studentcoursesmgnm {
	HashMap<String, List<String>> studentList;

	studentcoursesmgnm(){
		studentList = new HashMap<>();
	}

	public void add(String studentName, List<String> courses) { //Use Arrays.asList(); for the courses
		studentList.put(studentName, courses);
	}

	public void studentsInCourse(String course) {

		List<String> studentsEnrolled = new ArrayList<>();

		for (String studentName: studentList.keySet()) {
			List<String> courses = studentList.get(studentName);

			if(courses.contains(course)) {
				studentsEnrolled.add(studentName);
			}
		}

		System.out.println("Students that are enrolled in " + course + " are: " + String.join(", ", studentsEnrolled) + "\n");

	}

	public void printAll() {
		System.out.println("Here are the students and their courses for the year:\n");
		
		for (String studentName: studentList.keySet()) {
			
			List<String> courses = studentList.get(studentName);

			System.out.println(studentName + ", " + courses.toString() + "\n");
		}
	}

	public static void main(String[] args) {
		studentcoursesmgnm Year2025 = new studentcoursesmgnm();

		Year2025.add("Bryan_Ho", Arrays.asList("CS_2334", "HIST", "PYSC"));
		Year2025.add("Joe_Bun", Arrays.asList("CS_2334", "ARCH", "COMP"));
		Year2025.add("Spongebob_Squarepants", Arrays.asList("CS_2334", "DIST", "MATH"));
		
		Year2025.studentsInCourse("CS_2334");
		Year2025.printAll();
	}

}
