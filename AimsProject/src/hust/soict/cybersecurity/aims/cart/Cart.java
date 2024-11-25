package hust.soict.cybersecurity.aims.cart;
import hust.soict.cybersecurity.aims.disc.DigitalVideoDisc;
public class Cart {
	
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0;
	private float total = 0;
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered < MAX_NUMBERS_ORDERED) {
			itemsOrdered[qtyOrdered] = disc;
			qtyOrdered++;
			System.out.println("The disc has been added");
		}
		else {
			System.out.println("The cart is almost full");
		}
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc[] dvdlist) {
		for (DigitalVideoDisc disc: dvdlist) {
			if (qtyOrdered < MAX_NUMBERS_ORDERED) {
				itemsOrdered[qtyOrdered] = disc;
				qtyOrdered++;
				System.out.println("The disc has been added");
			}
			else {
				System.out.println("The cart is full");
				break;
			}
		}
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2) {
		if (qtyOrdered <= MAX_NUMBERS_ORDERED - 2) {
			itemsOrdered[qtyOrdered] = dvd1;
			qtyOrdered++;
			itemsOrdered[qtyOrdered] = dvd2;
			qtyOrdered++;
			System.out.println("The discs have been added");
		}
		else if (qtyOrdered <= MAX_NUMBERS_ORDERED - 1) {
			itemsOrdered[qtyOrdered] = dvd1;
			qtyOrdered++;
			System.out.println("The first disc has been added. The other one cannot be added"
					+ " since the cart is full");
		}
		else {
			System.out.println("The cart is full");
		}
	}
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		int ind = 0;
		for (int i = 0; i < qtyOrdered; i++) {
			if(disc.equals(itemsOrdered[i])) {
				ind = i;
			}
		}
		for (int i = ind; i < qtyOrdered - 1; i++) {
			itemsOrdered[i] = itemsOrdered[i + 1];
		}
		itemsOrdered[qtyOrdered] = null;
		qtyOrdered--;
		System.out.println("The disc has been removed");	
	}
	
	public float totalCost() {
		total = 0;
		for(int i = 0; i < qtyOrdered; i++) {
			total += itemsOrdered[i].getCost();
		}
		return total;
	}
	
	public void print() {
		total = 0;
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		for (int i = 0; i < qtyOrdered; i++) { 
			System.out.println((i + 1) + ". DVD - " + itemsOrdered[i].toString());
		}
		System.out.println("Total cost: " + totalCost());
		System.out.println("***************************************************");
	}
	
	public void searchByID(int id) {
		boolean found = false;
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsOrdered[i].getID() == id) {
				System.out.println("DVD found: " + itemsOrdered[i].toString());
				found = true;
				break;
			}
		}
		if (!found) {
			System.out.println("There are no DVDs that match your serach");
		}
	}
	
	public void searchByTitle(String title) {
		boolean found = false;
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsOrdered[i].isMatch(title)) {
				System.out.println("DVD found: " + itemsOrdered[i].toString());
				found = true;
				break;
			}
		}
		if (!found) {
			System.out.println("There are no DVDs that match your serach");
		}
	}
}
