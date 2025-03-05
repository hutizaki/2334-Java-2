import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class represents a Playlist, which contains a list of songs
 * and provides methods to add, remove, and manipulate songs.
 *
 * @author Bryan Ho
 * @version 1.1
 */
public class Playlist {
	
	private ArrayList<Song> songs;
	
	/**
	 * Default constructor for Playlists
	 */
	Playlist() {
		songs = new ArrayList<>();
	}
	
	/**
	 * Constructor for playlists when given a filename
	 * 
	 * @param filename --> uses the name of a file to add a list of songs
	 */
	Playlist(String filename) {
		songs = new ArrayList<>();
		addSongs(filename);
	}
	
	/**
	 * Getter for how many songs are in a playlist
	 * 
	 * @return --> gives the number of songs in a playlist
	 */
	public int getNumSongs() {
		return songs.size();
	}
	
	/**
	 * Getter for a song in a playlist given an index
	 * 
	 * @param index --> the index of where the song is in a playlist
	 * @return      --> gives the Song object at "index"
	 */
	public Song getSong(int index) {
		if (index < 0 || index >= getNumSongs()) {
			return null;
		}
		return songs.get(index);
	}
	
	/**
	 * Getter for Songs
	 * 
	 * @return --> gives a Song array
	 */
	public Song[] getSongs() {
		return songs.toArray(new Song[0]);
	}
	
	/**
	 * Method to add a song at the end of the playlist
	 * when passing a Song object
	 * 
	 * @param song --> Song object
	 * @return     --> calls the other addSong() which gives a T/F statement
	 */
	public boolean addSong(Song song) {
		return addSong(getNumSongs(), song);
	}
	
	/**
	 * Method addSongs which adds a given song to whatever index
	 * 
	 * @param index --> where the song goes
	 * @param song  --> Song object
	 * @return      --> gives T/F statement if the song was successfully added
	 */
	public boolean addSong(int index, Song song) {
		if(song == null)return false;
		try {
			songs.add(index, song);
		} catch(IndexOutOfBoundsException e) {
			return false;
		}
		
		return true;
	}
	
	// ts (this) dnt wrk gng, ts pmo
	
	/**
	 * Method to add all songs from another playlist
	 * 
	 * @param playlist --> a Playlist object containing songs to add
	 * @return         --> number of songs successfully added
	 */
	public int addSongs(Playlist playlist) {
		int count = 0;
		
		if(playlist == null) return 0;
		
		for(Song s: playlist.getSongs()) {
			songs.add(s);
			count++;
		}
		return count;
	}
	
	/**
	 * Reads songs from a file and adds them to the playlist
	 * 
	 * @param filename --> name of the file containing song data
	 * @return         --> number of songs successfully added
	 */
	public int addSongs(String filename) {
		int count = 0;
		
		try {
			FileReader reader = new FileReader(filename);
			
			BufferedReader bufferedReader = new BufferedReader(reader);
			
			String songInfo;
			
			while((songInfo = bufferedReader.readLine()) != null) {
				songs.add(new Song(songInfo));
				count++;
			}
			bufferedReader.close();
			reader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return count;
	}
	
	/**
	 * Removes the last song from the playlist
	 * 
	 * @return --> the removed Song object, or null if empty
	 */
	public Song removeSong() {
		return removeSong(getNumSongs() - 1);
	}
	
	/**
	 * Removes a song from a specific index in the playlist
	 * 
	 * @param index --> index of the song to remove
	 * @return      --> the removed Song object, or null if index is out of range
	 */
	public Song removeSong(int index) {
		try {
			Song songToRemove = songs.get(index);
			songs.remove(index);
			return songToRemove;
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}
	
	/**
	 * Saves the current playlist to a file
	 * 
	 * @param filename --> name of the file to save the playlist in
	 */
	public void saveSongs(String filename) {
		try {
			BufferedWriter newPlaylist = new BufferedWriter(new FileWriter(filename));
			newPlaylist.write(toString());
			
			newPlaylist.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
	/**
	 * Converts the playlist into a formatted string
	 * 
	 * @return --> a string representation of the playlist
	 */
	public String toString() {
		StringBuilder allSongs = new StringBuilder();
		for(Song s: songs) {
			allSongs.append(s);
			allSongs.append(System.lineSeparator());
		}
		return allSongs.toString().trim();
	}
	
	// arr[0] = seconds,  arr[1] = minutes,  arr[2] = hours
	/**
	 * Calculates the total time duration of all songs in the playlist
	 * 
	 * @return --> an array where [0] = seconds, [1] = minutes, [2] = hours
	 */
	public int[] getTotalTime() { 
		
		int seconds = 0;
		int minutes = 0;
		int hours   = 0;
		
		for(Song s: songs) {
			try {
				int[] timeToAdd= s.getTime();
				seconds += timeToAdd[0];
				minutes += timeToAdd[1];
				hours   += timeToAdd[2];
				
			} catch (IndexOutOfBoundsException e) {
			
			} finally {
				if(seconds >= 60) {
					seconds -= 60;
					minutes++;
				}
				if(minutes >= 60) {
					minutes -= 60;
					hours++;
				}
			}
		}
		if(minutes == 0) return new int[] {seconds};
		if(hours == 0) return new int[] {seconds, minutes};
		return new int[] {seconds, minutes, hours};
	}
	
	public static void main(String[] args) {
		String info0 = "Her Majesty; The Beatles; 23";
		String info1 = "Johnny B. Goode; Chuck Berry; 2:41";
		String info2 = "A Farewell to Kings; Rush; 5:51";
		String info3 = "Can't You Hear Me Knocking; The Rolling Stones; 7:15";
		String info4 = "Stairway to Heaven; Led Zeppelin; 8:02";
		String info5 = "Close to the Edge; Yes; 18:42";
		String info6 = "Supper's Ready; Genesis; 23:06";
		String info7 = "Symphony No. 9; Ludwig van Beethoven; 1:09:00";
		
		Playlist playlistA = new Playlist();
		
		playlistA.getTotalTime();
		playlistA.addSong(new Song(info0));
		System.out.println(Arrays.toString(playlistA.getTotalTime()));
		playlistA.addSong(new Song(info1));
		System.out.println(Arrays.toString(playlistA.getTotalTime()));
	}
}
