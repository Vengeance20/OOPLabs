package hust.soict.cybersecurity.aims.store;
import java.util.ArrayList;

import hust.soict.cybersecurity.aims.media.Media;

public class Store {
	private ArrayList<Media> itemsInStore;
	
	public Store() {
		this.itemsInStore = new ArrayList<Media>();
	}
	public void addMedia(Media media) {
		itemsInStore.add(media);
	}
	
	public void removeMedia(Media media) {
		itemsInStore.remove(media);
	}
	
	public Media searchByTitle(String title) {
		boolean found = false;
		for (int i = 0; i < itemsInStore.size(); i++) {
			if (itemsInStore.get(i).getTitle().equals(title)) {
				System.out.println("Media found: " + itemsInStore.get(i).toString());
				found = true;
				return itemsInStore.get(i);
			}
		}
		if (!found) {
			System.out.println("There are no medias that match your search");
		}
		return null;
	}
	
	public void print() {
		System.out.println("***********************STORE***********************");
		System.out.println("Store:");
		for (int i = 0; i < itemsInStore.size(); i++) {
			System.out.println((i + 1) + ". DVD - " + itemsInStore.get(i).toString());
		}
		System.out.println("***************************************************");
	}
	
	public ArrayList<Media> getItemsInStore() {
		return itemsInStore;
	}
}
