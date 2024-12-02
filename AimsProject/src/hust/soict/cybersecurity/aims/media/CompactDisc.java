package hust.soict.cybersecurity.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {

	private String artist;
	private List<Track> tracks = new ArrayList<Track>();
	
	public CompactDisc(String title, String category, String artist, float cost){
		super(title, category, cost);
		this.artist = artist;
	}
	
	public void addTrack(Track CDtrack) {
		boolean added = false;
		for (Track track: tracks) {
			if (track.equals(CDtrack)) {
				added = true;
				break;
			}
		}
		if (added) {
			System.out.println("This track has already been added");
		}
		else {
			System.out.println("This track has been added");
			tracks.add(CDtrack);
		}
	}
	
	public void removeTrack(Track CDtrack) {
		boolean removed = true;
		for (Track track: tracks) {
			if(track.equals(CDtrack)) {
				removed = false;
				break;
			}
		}
		if (removed) {
			System.out.println("This author does not exist");
		}
		else {
			tracks.remove(CDtrack);
			System.out.println("This author has been removed");
		}
	}
	
	public int getLength() {
		int length = 0;
		for (Track track: tracks) {
			length += track.getLength();
		}
		return length;
	}
	
	public String getArtist() {
		return artist;
	}

	@Override
	public void play() {
		for (Track track: tracks) {
			track.play();
		}
	}
	
	public String toString() {
		String s = "";
		System.out.println(getTitle() + " - " + getCategory() + " - " + this.artist + " - " + getCost() + " $");
		System.out.println("Tracks:");
		for (Track track : tracks) {
			s += "\t" + track.getTitle() + " - " + track.getLength() + " minutes";
			s += "\n";
		}
		return s;
	}
}
