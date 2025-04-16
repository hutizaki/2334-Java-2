
public class Song {
	private final String title;
	private final String artist;
	private final int[] time; // Up to 3 elements. 0 - 59 range for sec & min. Hours and or Minutes ignored if "0"
	// [sec, min, hrs]
	
	Song(String title, String artist, int[] time) { 
		this.title = title;
		this.artist = artist;
		// Strings are immutable in java! But Arrays aren't, so we must assign with a copy
		this.time = new int[time.length];
		for(int i = 0; i < time.length; i++) {
			this.time[i] = time[i];
		}
	}

	public String getTitle() {
		return title;
	}
	
	public String getArtist() {
		return artist;
	}
	
	
	public int[] getTime() {
		int[] copyOfTime = new int[time.length];
		for(int i = 0; i < time.length; i++) {
			copyOfTime[i] = time[i];
		}
		return copyOfTime;
	}
}
