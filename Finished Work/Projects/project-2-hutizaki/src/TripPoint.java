import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Has multiple setters and getters to manipulate the private fields.
 * Reads trip.csv files to then calculate haversine distances.
 * @author Bryan Ho
 * @version 1.1
 */
public class TripPoint {
	private double lat;
	private double lon;
	private int time;
	private static ArrayList<TripPoint> trip;
	
	
	/**
	 * Constructor for the TripPoint object
	 * 
	 * @param time --> this is the time stamp for the coordinates
	 * @param lat  --> Latitude value
	 * @param lon  --> Longitude Value
	 */
	TripPoint(int time, double lat, double lon){
		this.lat = lat;
		this.lon = lon;
		this.time = time;
	}
	
	/**
	 * ints are mutable, this getter returns a copy to
	 * maintain encapsulation.
	 * 
	 * @return --> gives back a copy of time
	 */
	public int getTime() {
		int copyOfTime = time;
		return copyOfTime;
	}
	
	/**
	 * doubles are mutable, this getter returns a copy to
	 * maintain encapsulation.
	 * 
	 * @return --> gives back a copy of latitude is given
	 */
	public double getLat() {
		double copyOfLat = lat;
		return copyOfLat;
	}
	
	/**
	 * doubles are mutable, this getter returns a copy to
	 * maintain encapsulation.
	 * 
	 * @return --> gives back a copy of longitude
	 */
	public double getLon() {
		double copyOfLon = lon;
		return copyOfLon;
	}
	
	/**
	 * Creates a copy of the trip<TripPoint> array to
	 * maintain encapsulation, no memory addresses are
	 * given away by calling this method.
	 * 
	 * @return -> gives back a copy of the trip
	 */
	public static ArrayList<TripPoint> getTrip(){
		ArrayList<TripPoint> copyOfTrip = new ArrayList<>();
		
		for(TripPoint tripPointObject: trip) {
			copyOfTrip.add(new TripPoint(tripPointObject.getTime(), 
										 tripPointObject.getLat(),
										 tripPointObject.getLon()));
		}
		
		return copyOfTrip;
	}
	
	/**
	 * Uses TripPoints to pull out lon and lat. Then converts from degrees to radians,
	 * then inputs them into the haversine distance formula.
	 * 
	 * @return --> gives back the arc distance in km
	 */
	public static double haversineDistance(TripPoint a, TripPoint b) {
		
		double latA = Math.toRadians(a.getLat());
	    double latB = Math.toRadians(b.getLat());
	    double deltaLat = latB - latA;
	    double deltaLon = Math.toRadians(b.getLon() - a.getLon());
		
	    double haversineLat = Math.sin(deltaLat / 2) * Math.sin(deltaLat / 2);
	    double haversineLon = Math.sin(deltaLon / 2) * Math.sin(deltaLon / 2);
		
		double internalDistance = haversineLat + Math.cos(latA) * Math.cos(latB) * haversineLon;
		
		double radiusOfEarth = 6371.0; //in km
		
		double distance = 2 * radiusOfEarth * Math.asin(Math.sqrt(internalDistance));
		
	    return distance;
	}
	
	/**
	 * Calculates the average speed using distance/time in hours.
	 * Uses Math.abs to work in any TripPoint order.
	 * 
	 * @param a --> any TripPoint
	 * @param b --> any TripPoint
	 * @return  --> gives back the avgspeed in km/hr
	 */
	public static double avgSpeed(TripPoint a, TripPoint b) {
		
		double distance = Math.abs(haversineDistance(a, b));
		double time = Math.abs((a.getTime() - b.getTime()) / 60.0);
		
		return distance/(time * 1.0);
	}
	
	/**
	 * totalTime() adds all the numbers up from the trip and divides by 60.0
	 * to return a proper double for the total time.
	 * 
	 * @return --> total time as a double
	 */
	public static double totalTime() {
		return trip.get(trip.size() - 1).getTime()/60.0;
	}
	
	/**
	 * Loops through the trip to get all points, then calls haversineD
	 * to get all the distances, then finally rounds at the end
	 * 
	 * @return --> gives back the properly rounded total distance
	 */
	public static double totalDistance() {
		
		ArrayList<TripPoint> recentTrip = getTrip();
		
		double totalDistance = 0;
		
		boolean first = true;
		
		TripPoint previousPoint = null;
		
		for(TripPoint tp: recentTrip) {
			if(first) {
				previousPoint = tp;
				first = false;
				continue;
			}
			totalDistance += haversineDistance(previousPoint, tp);
			previousPoint = tp;
		}
		
		return totalDistance;
	}
	
	/**
	 * This method is what creates the actual "trip" ArrayList.
	 * First it reads the file, then it will assign the values to the 
	 * correct variables for the class by calling the TripPoint() method.
	 * 
	 * 
	 * {@value} parsedTime --> Extracted time from the file reader
	 * {@value} parsedLat  --> Extracted Latitude from the file reader
	 * {@value} parsedLon  --> Extracted Longitude from the file reader
	 * 
	 * @param filename --> name of the file being read "triplog.csv"
	 */
	public static void readFile(String filename) {
		
		try {
			
			File fileFound = new File(filename);
			
			FileReader fileBeingRead = new FileReader(fileFound);
			
			BufferedReader lineBeingRead = new BufferedReader(fileBeingRead);
			
			String line = lineBeingRead.readLine();
			
			trip = new ArrayList<>(); // Bowl must be "made" first before adding any ingredients
			
			while((line = lineBeingRead.readLine()) != null) {
				
				String[] splitLine = line.split(",");
				
				int parsedTime = Integer.parseInt(splitLine[0]); 
				double parsedLat = Double.parseDouble(splitLine[1]);
				double parsedLon = Double.parseDouble(splitLine[2]);
				
				// "new" should be used because it is a *new* object being made!
				trip.add(new TripPoint(parsedTime, parsedLat, parsedLon));
				
			}
			
			lineBeingRead.close();
			fileBeingRead.close();
			
		} catch (Exception e) {
			System.out.println("Could not find file!");
		}
	}
	
	/**
	 * Copied the test case data from TripPointTest
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TripPoint a = new TripPoint(0, 35.211037,-97.438866);
		TripPoint b = new TripPoint(5, 35.222366,-97.45298);
		System.out.println(haversineDistance(a, b));
		
		TripPoint.readFile("triplog.csv");
		
		double actual = TripPoint.totalDistance();
		
		System.out.println(actual);
	}

}
