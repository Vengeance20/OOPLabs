package hust.soict.cybersecurity.test.cart;
import hust.soict.cybersecurity.aims.cart.Cart;
import hust.soict.cybersecurity.aims.disc.DigitalVideoDisc;

public class CartTest {
	public static void main(String[] args) {
		Cart cart = new Cart();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation",
				"Roger Allers", 87, 19.95f);
		cart.addDigitalVideoDisc(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction",
				"George Lucas", 87, 24.95f);
		cart.addDigitalVideoDisc(dvd2);
		cart.removeDigitalVideoDisc(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		cart.addDigitalVideoDisc(dvd3);
		
		cart.print();
		
		cart.searchByID(1);
		cart.searchByID(3);
		
		cart.searchByTitle("The Lion King");
		cart.searchByTitle("Venom");
	}
}