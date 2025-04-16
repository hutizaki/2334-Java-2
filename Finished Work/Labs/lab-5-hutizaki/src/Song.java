import java.util.Arrays;

/**
 * This class represents a Song object, storing details such as 
 * title, artist, and duration. It provides multiple constructors 
 * for object creation and includes methods to retrieve song 
 * information and format it as a string.
 * 
 * @author Bryan Ho
 * @version 1.1
 */
public class Song {
	
	private String title;
	private String artist;
	private int[] time;
	
	private static final String INFO_DELIMITER = "; ";
	private static final String TIME_DELIMITER = ":";
	
	private static final int IDX_TITLE = 0;
	private static final int IDX_ARTIST = 1;
	private static final int IDX_TIME = 2;
	
	private final Song ts /*(this)*/ = this;
	
	/**
	 * Constructor for new Song objects, uses three parameters 
	 * instead of a single formatted string.
	 * 
	 * @param title  --> the name of the song
	 * @param artist --> the artist or band that performed the song
	 * @param time   --> an array representing the song's duration
	 */
	public Song(String title, String artist, int[] time) {
		ts.title = title;
		ts.artist = artist;
		ts.time = Arrays.copyOf(time, time.length);
	}
	
	/**
	 * Constructor for new Song objects, using a single string 
	 * which is then split into components.
	 * 
	 * @param info --> a string that contains the individual components 
	 *                 (title, artist, and time) separated by a delimiter
	 */
	public Song(String info) {
		String[] songDetails = info.split(INFO_DELIMITER);
		title = songDetails[IDX_TITLE];
		artist = songDetails[IDX_ARTIST];
		
		String[] timeComponents = songDetails[IDX_TIME].split(TIME_DELIMITER);
		
		int size = timeComponents.length;
		
		int[] parsedTime = new int[size];
		
		for(int i = size - 1; i > -1; i--) {
			parsedTime[size - i - 1] = Integer.parseInt(timeComponents[i]);
		}
		
		time = parsedTime;
	}
	
	/**
	 * Getter for the Song object's title.
	 * 
	 * @return --> the title of the song
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * Getter for the Song object's artist.
	 * 
	 * @return --> the name of the artist who performed the song
	 */
	public String getArtist() {
		return artist;
	}
	
	/**
	 * Getter for the Song object's duration. Uses Arrays.copyOf 
	 * to maintain encapsulation since int[] arrays are mutable.
	 * 
	 * @return --> a copy of the song's duration in time format
	 */
	public int[] getTime() {
		return Arrays.copyOf(time, time.length);
	}
	
	/**
	 * Converts the Song object to a formatted string representation.
	 * 
	 * @return --> a string containing the song's title, artist, and duration
	 */
	public String toString() {
		
		int[] timing = getTime();
		StringBuilder timeToString = new StringBuilder();
		boolean first = true;
		
		for (int i = timing.length - 1; i > -1; i--) {
			if(first) {
				timeToString.append(timing[i]);
				first = false;
			} else {
				timeToString.append(TIME_DELIMITER);
				timeToString.append(String.format("%02d", timing[i]));
			}
		}
		
		return title + INFO_DELIMITER + artist + INFO_DELIMITER + timeToString;
	}
	
	public static void main (String[] args) {
		Song song = new Song("Where the Streets Have No Name", "U2", new int[] {36, 5});
		Song songA = new Song("It's a Boy; The Who; 38");
		System.out.print(songA);
	}
}
