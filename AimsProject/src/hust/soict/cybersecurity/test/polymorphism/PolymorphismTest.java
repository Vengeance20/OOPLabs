package hust.soict.cybersecurity.test.polymorphism;

import java.util.ArrayList;
import java.util.List;

import hust.soict.cybersecurity.aims.media.Book;
import hust.soict.cybersecurity.aims.media.CompactDisc;
import hust.soict.cybersecurity.aims.media.DigitalVideoDisc;
import hust.soict.cybersecurity.aims.media.Media;
import hust.soict.cybersecurity.aims.media.Track;

public class PolymorphismTest {
	public static void main(String[] args) {
		List<Media> mediae = new ArrayList<Media>();
		
		CompactDisc cd = new CompactDisc("Pink Panther", "Cartoon", "Animator", 10.8f);
		
		cd.addTrack(new Track("Episode 1", 10));
		cd.addTrack(new Track("Episode 2", 9));
		
		DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King", "Animation",
				"Roger Allers", 87, 19.95f);
		
		Book book = new Book("HUST", "Education", 5.2f);
		book.addAuthor("Author A");
		book.addAuthor("Author B");
		
		mediae.add(cd);
		mediae.add(dvd);
		mediae.add(book);
		
		System.out.println("Media info:");
		for (Media m: mediae) {
			System.out.println(m.toString());
		}
	}
}
