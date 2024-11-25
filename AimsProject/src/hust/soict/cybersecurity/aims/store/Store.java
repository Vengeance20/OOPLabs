package hust.soict.cybersecurity.aims.store;
import hust.soict.cybersecurity.aims.disc.*;

public class Store {
	private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[10000000];
	private int storeQty = 0;
	public void addDVD(DigitalVideoDisc disc) {
		itemsInStore[storeQty] = disc;
		storeQty++;
	}
	
	public void removeDVD(DigitalVideoDisc disc) {
		int ind = 0;
		for (int i = 0; i < storeQty; i++) {
			if(disc.equals(itemsInStore[i])) {
				ind = i;
			}
		}
		for (int i = ind; i < storeQty - 1; i++) {
			itemsInStore[i] = itemsInStore[i + 1];
		}
		itemsInStore[storeQty] = null;
		storeQty--;
	}
	
	public void print() {
		System.out.println("***********************STORE***********************");
		System.out.println("Store:");
		for (int i = 0; i < storeQty; i++) {
			System.out.println((i + 1) + ". DVD - " + itemsInStore[i].toString());
		}
		System.out.println("***************************************************");
	}
}
