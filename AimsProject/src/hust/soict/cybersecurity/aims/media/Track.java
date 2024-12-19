package hust.soict.cybersecurity.aims.media;

import hust.soict.cybersecurity.aims.exception.PlayerException;

public class Track implements Playable{
	private String title;
	private int length;
	
	public Track(String title, int length) {
		super();
		this.title = title;
		this.length = length;
	}
	
	public String getTitle() {
		return title;
	}
	public int getLength() {
		return length;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null || !(o instanceof Media)) {
			return false;
		}
		
		Track other = (Track) o;
		
		return (this.title != null && this.length != 0) && 
				(this.title == (other.title) && this.length == (other.length));
	}
	
	@Override
	public void play() throws PlayerException {
		if (this.getLength() > 0) {
			System.out.println("Playing track: " + this.getTitle());
			System.out.println("Track length: " + this.getLength());
		}
		else {throw new PlayerException("Error: Track length is non-positive!");}
	}
}
