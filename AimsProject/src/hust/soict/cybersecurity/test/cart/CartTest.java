package hust.soict.cybersecurity.test.cart;
import javax.naming.LimitExceededException;

import hust.soict.cybersecurity.aims.cart.Cart;
import hust.soict.cybersecurity.aims.media.DigitalVideoDisc;

public class CartTest {
	public static void main(String[] args) throws LimitExceededException {
		Cart cart = new Cart();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation",
				"Roger Allers", 87, 19.95f);
		cart.addMedia(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction",
				"George Lucas", 87, 24.95f);
		cart.addMedia(dvd2);
		cart.removeMedia(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		cart.addMedia(dvd3);
		
		cart.print();
		
		cart.searchByID(1);
		cart.searchByID(3);
		
		cart.searchByTitle("Aladin");
		cart.searchByTitle("Venom");
	}
}
