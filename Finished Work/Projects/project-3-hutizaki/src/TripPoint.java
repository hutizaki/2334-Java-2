import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * Has multiple setters and getters to manipulate the private fields.
 * Reads trip.csv files to then calculate haversine distances.
 * Added two different ways to detect stops and creates a new movingTrip array.
 * 
 * @author Bryan Ho
 * @version 1.1
 */
public class TripPoint {
	private double lat;
	private double lon;
	private int time;
	private static ArrayList<TripPoint> trip;
	private static ArrayList<TripPoint> movingTrip;
	private static boolean h2Active = false;
	
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
	 * Creates a copy of the <TripPoint> trip array to
	 * maintain encapsulation, no memory addresses are
	 * given away by calling this method.
	 * 
	 * @return -> gives back a copy of the trip
	 */
	public static ArrayList<TripPoint> getTrip(){	
		return trip;
	}

	/**
	 * Creates a copy of the <TripPoint> movingTrip array to
	 * maintain encapsulation, no memory addresses are
	 * given away by calling this method.
	 * 
	 * @return -> gives back a copy of the movingTrip
	 */
    public static ArrayList<TripPoint> getMovingTrip() {
		return movingTrip;
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
		
		System.out.printf("Distance between t=%d and t=%d: %.6f km\n", 
						 a.getTime(), b.getTime(), distance);
		
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
     * Calculates the average moving speed by calculating the total moving distance first.
     * 
     * @return --> average speed while moving as a double in km/hr
     */
    public static double avgMovingSpeed() {
    	
    	double totalMovingDistance = 0;
    	TripPoint previousPoint = null;
    	
    	for(TripPoint tp: movingTrip) {
    		if(previousPoint == null) {
    			previousPoint = tp;
    			continue;
    		}
    		totalMovingDistance += haversineDistance(previousPoint, tp);	
    		previousPoint = tp;
    	}
    	
    	double speed = totalMovingDistance/movingTime();
    	System.out.println("testH" + (h2Active ? "2" : "1") + "AvgMovingSpeed: " + speed);
    	return speed;
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
     * Calculates the total moving time.
     * 
     * @return --> the time spent moving as a double
     */
    public static double movingTime() {
    	double time = ((movingTrip.size() - 1) * 5.0) / 60.0;
    	System.out.println("testH" + (h2Active ? "2" : "1") + "MovingTime: " + time);
    	return time;
    }

    /**
     * Calculates the total stopped time by taking the difference between tripTime and movingTime
     * 
     * @return --> time spent stopped as a double
     */
    public static double stoppedTime() {
    	double time = totalTime() - movingTime();
    	System.out.println("testH" + (h2Active ? "2" : "1") + "StoppedTime: " + time);
    	return time;
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
		
		TripPoint previousPoint = null;
		
		for(TripPoint tp: recentTrip) {
			if(previousPoint == null) {
				previousPoint = tp;
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
	 * @param   filename   --> name of the file being read "triplog.csv"
	 */
	public static void readFile(String filename) throws FileNotFoundException, IOException {
		try {
			System.out.println("Attempting to read file: " + filename);
			File fileFound = new File(filename);
			FileReader fileBeingRead = new FileReader(fileFound);
			BufferedReader lineBeingRead = new BufferedReader(fileBeingRead);
			
			String line = lineBeingRead.readLine();
			
			trip = new ArrayList<>();
			
			while((line = lineBeingRead.readLine()) != null) {
				System.out.println("Reading line: " + line);
				String[] splitLine = line.split(",");
				
				int parsedTime = Integer.parseInt(splitLine[0]); 
				double parsedLat = Double.parseDouble(splitLine[1]);
				double parsedLon = Double.parseDouble(splitLine[2]);
				
				trip.add(new TripPoint(parsedTime, parsedLat, parsedLon));
			}
			
			lineBeingRead.close();
			fileBeingRead.close();
			
			System.out.println("Successfully read " + trip.size() + " points from file");
			
		} catch (NumberFormatException e) {
			System.out.println("Error parsing numbers from file!");
			throw e;
		} catch (Exception e) {
			System.out.println("Could not find file: " + e.getMessage());
			throw e;
		}
	}
	
	/**
     * Detects stops using method h1 by checking the distance between each point in the trip array.
     * Then uses a 0.6km (inclusive) threshold to filter out stops.
     * 
     * @return --> number of stops using the h1 method
     */
    public static int h1StopDetection() {
    	h2Active = false;
    	movingTrip = new ArrayList<>();
    	TripPoint previousPoint = null;
    	int count = 0;
    	
    	for(TripPoint tp: trip) {
    		if(previousPoint == null) {
    			previousPoint = tp;
    			movingTrip.add(tp);
    			continue;
    		}
    		
    		if(haversineDistance(previousPoint, tp) <= 0.6) {
    			count++;
    		} else {
    			movingTrip.add(tp);
    		}
    		previousPoint = tp;  // Update previous point every time
    	}
    	
    	System.out.println("testH1StopDetection: " + count);
    	System.out.println("H1MovingTime: " + movingTime());
    	System.out.println("H1StoppedTime: " + stoppedTime());
    	System.out.println("H1AvgMovingSpeed: " + avgSpeed(trip.get(0), trip.get(trip.size() - 1)));
    	
    	return count;
    }

    /**
     * Detects stops using method h2 by creating a streak of stops array. If that array reaches 3 stops or more,
     * the points in the array are not added to the movingTrip. If the streak is broken before 3, then all points in the array are added.
     * 
     * @return --> number of stops using the h2 method 
     */
    public static int h2StopDetection() {
    	h2Active = true;
    	movingTrip = new ArrayList<>();
    	
    	HashSet<Integer> stops = new HashSet<>();
    	
    	for(int i = 0; i < trip.size(); i++) {
    		TripPoint pointI = trip.get(i);
    		ArrayList<Integer> nearbyPoints = new ArrayList<>();
    		
    		int start = Math.max(0, i - 3);
    		int end   = Math.min(trip.size(), i + 3);
    		
    		for(int j = start; j < end; j++) {
    			
    			if(i == j) continue;
    			
    			TripPoint pointJ = trip.get(j);
    			
    			if(haversineDistance(pointI, pointJ) <= 0.5) {
    				nearbyPoints.add(j);
    			}
    		}
    		
    		if(nearbyPoints.size() >= 2) {
    			for(Integer x: nearbyPoints) {
    				stops.add(x);
    			}
    			stops.add(i);
    		}
    	}
    	
    	for(int i = 0; i < trip.size(); i++) {
    		if(!stops.contains(i)) {
    			movingTrip.add(trip.get(i));
    		}
    	}
    	
    	int numberOfStops = stops.size();
    	System.out.println("testH2StopDetection: " + numberOfStops);
    	
    	return numberOfStops;
    }

    
}
