package hust.soict.cybersecurity.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
	private String director;
	private int length;
	private static int nbDigitalVideoDiscs = 0;
	
	public DigitalVideoDisc(String title) {
		super(title);
		nbDigitalVideoDiscs++;
		setId(nbDigitalVideoDiscs);
	}
	
	public DigitalVideoDisc(String title, String category, float cost) {
		super(title, category, cost);
		nbDigitalVideoDiscs++;
		setId(nbDigitalVideoDiscs);
	}
	
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super(title, category, cost);
		this.director = director;
		nbDigitalVideoDiscs++;
		setId(nbDigitalVideoDiscs);
	}
	
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title, category, director, length, cost);
		nbDigitalVideoDiscs++;
		setId(nbDigitalVideoDiscs);
	}
	
	public String toString() {
		return getTitle() + " - " + getCategory() + " - " + director + " - " + length + ": " + getCost() + " $";
	}

	@Override
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
}
