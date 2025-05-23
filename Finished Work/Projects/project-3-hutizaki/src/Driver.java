import java.io.FileNotFoundException;
import java.io.IOException;

public class Driver {
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		// read the data
		StatsForTripPoint.readFile("triplog.csv");
		
		// find data for heuristic 1
		System.out.println("Data for heuristic 1:");
		System.out.println("Number of Stops: " + StatsForTripPoint.h1StopDetection());
		System.out.println("Moving Time (hr): " + StatsForTripPoint.movingTime());
		System.out.println("Stopped Time (hr): " + StatsForTripPoint.stoppedTime());
		System.out.println("Average Moving Speed (km/hr): " + StatsForTripPoint.avgMovingSpeed());
		System.out.println();
		
		// find data for heuristic 2
		System.out.println("Data for heuristic 2:");
		System.out.println("Number of Stops: " + StatsForTripPoint.h2StopDetection());
		System.out.println("Moving Time (hr): " + StatsForTripPoint.movingTime());
		System.out.println("Stopped Time (hr): " + StatsForTripPoint.stoppedTime());
		System.out.println("Average Moving Speed (km/hr): " + StatsForTripPoint.avgMovingSpeed());
	}
	

}
