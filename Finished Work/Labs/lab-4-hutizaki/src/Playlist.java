
public class Playlist {
	private final Song[] songs;
	private int numSongs;
	private final static int MIN_CAPACITY = 3;

	Playlist() {
		songs = new Song[MIN_CAPACITY];
		numSongs = 0;
	}
	
	Playlist(int capacity) {
		if(capacity < MIN_CAPACITY) {
			songs = new Song[MIN_CAPACITY];
		} else {
			songs = new Song[capacity];
		}
		numSongs = 0;
	}
	
	public int getCapacity() {
		return songs.length;
	}
	
	public int getNumSongs() {
		return numSongs;
	}
	
	public Song getSong(int index) {
		if(index < 0 || index >= numSongs || songs[index] == null) return null;
		return songs[index];
	}

	public Song[] getSongs() {
		
		Song[] p_arr = new Song[numSongs];
		for(int i = 0; i < numSongs; i++) {
			if(songs[i] != null) {
				p_arr[i] = songs[i];
			}
		}
			
		return p_arr;
	}
	
	public boolean addSong(Song song) {
		return addSong(getNumSongs(), song);
	}
	
	public boolean addSong(int index, Song song) {
		Song temp;
		// Base case (method call): put song at end
		// index case:
		// -check numsong < song.length-1
		// -index != 0 || index < song.length-1
		// song != null
		
		if(song == null || index < 0 || index > numSongs ||
		   numSongs == songs.length) {
			return false;
			
		} else if(index == numSongs) {
			songs[numSongs] = song;
			numSongs++;
			return true;
			
		} else {
			temp = songs[index];
			songs[index] = song;
			
			for(int i = index + 1; i < songs.length - 1; i++) {
				songs[i] = temp;
				temp = songs[i + 1];
			}
			
			numSongs++;
			return true;
		}
	}
	
	public int addSongs(Playlist playlist) {
		if(playlist == null) return 0;
		
		int added = 0;
		
		for(Song s: playlist.getSongs()) {
			
			if(addSong(s)) {
				added++;
			}
		}
		
		return added;
	}
	
	public Song removeSong() {
		if(numSongs==0) return null;
		return removeSong(numSongs - 1);
	}
	
	public Song removeSong(int index) {
		if(index < 0 || index >= numSongs) return null;
		
		Song removed = songs[index];
		songs[index] = null;
		
		for(int i = index; i < numSongs - 1; i++) {
			songs[i] = songs[i + 1];
		}
		numSongs--;
		
		return removed;
	}
}
