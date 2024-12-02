package hust.soict.cybersecurity.aims.media;

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
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
}
