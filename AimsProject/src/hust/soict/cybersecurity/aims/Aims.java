package hust.soict.cybersecurity.aims;
import java.util.Scanner;

import hust.soict.cybersecurity.aims.cart.Cart;
import hust.soict.cybersecurity.aims.media.Book;
import hust.soict.cybersecurity.aims.media.CompactDisc;
import hust.soict.cybersecurity.aims.media.DigitalVideoDisc;
import hust.soict.cybersecurity.aims.media.Media;
import hust.soict.cybersecurity.aims.media.Playable;
import hust.soict.cybersecurity.aims.media.Track;
import hust.soict.cybersecurity.aims.store.Store;

public class Aims {
	
	public static Cart cart = new Cart();
	public static Store store = new Store();
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int choice;
		do {
			showMenu();
			choice = s.nextInt();
			s.nextLine();

			switch (choice) {
				case 1:
					viewStore(s);
					break;
				case 2:
					updateStore(s, store);
					break;
				case 3:
					seeCurrentCart(s);
					break;
				case 0:
					System.out.println("Goodbye!");
					break;
				default:
					System.out.println("Invalid choice!");
			}
		} while (choice != 0);
		s.close();
	}
	
	public static void showMenu() {
		System.out.println("");
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}
	
	public static void storeMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a media’s details");
		System.out.println("2. Add a media to cart");
		System.out.println("3. Play a media");
		System.out.println("4. See current cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
	}
	
	public static void mediaDetailsMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add to cart");
		System.out.println("2. Play");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}

	public static void cartMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter medias in cart");
		System.out.println("2. Sort medias in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play a media");
		System.out.println("5. Place order");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5");
	}
	
	public static void viewStore(Scanner s) {
		System.out.println("Store Items:");
		store.print();

		int choice;
		do {
			storeMenu();
			choice = s.nextInt();
			s.nextLine();

			switch (choice) {
				case 1:
					seeMediaDetails(s);
					break;
				case 2:
					addMediaToCart(s);
					break;
				case 3:
					playMedia(s);
					break;
				case 4:
					seeCurrentCart(s);
					break;
				case 0:
					break;
				default:
					System.out.println("Invalid choice!");
			}
		} while (choice != 0);
	}
	
	public static void seeMediaDetails(Scanner s) {
		System.out.print("Enter the title: ");
		String title = s.nextLine();
		Media media = store.searchByTitle(title);

		if (media != null) {
			System.out.println(media.toString());
			mediaDetailsMenu(s, media);
		} else {
			System.out.println("Media not found!");
		}
	}
	
	public static void mediaDetailsMenu(Scanner s, Media media) {
		int choice;
		do {
			System.out.println("");
			System.out.println("Options: ");
			System.out.println("--------------------------------");
			System.out.println("1. Add to cart");
			System.out.println("2. Play");
			System.out.println("0. Back");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1-2");

			choice = s.nextInt();
			s.nextLine();

			switch (choice) {
				case 1:
					cart.addMedia(media);
					System.out.println("Media has been added to cart.");
					break;
				case 2:
					if (media instanceof Playable) {
						((Playable) media).play();
					} else {
						System.out.println("This media cannot be played.");
					}
					break;
				case 0:
					break;
				default:
					System.out.println("Invalid choice!");
			}
		} while (choice != 0);
	}
	
	public static void addMediaToCart(Scanner s) {
		System.out.print("Enter the title: ");
		String title = s.nextLine();
		Media media = store.searchByTitle(title);

		if (media != null) {
			cart.addMedia(media);
			System.out.println("Media has been added to cart.");
		} else {
			System.out.println("Media is not in the store.");
		}
	}
	
	public static void playMedia(Scanner s) {
		System.out.print("Enter the title: ");
		String title = s.nextLine();
		Media media = store.searchByTitle(title);

		if (media != null) {
			if (media instanceof Playable) {
				((Playable) media).play();
			} else {
				System.out.println("This media cannot be played.");
			}
		} else {
			System.out.println("Media is not in the store.");
		}
	}
	
	public static void seeCurrentCart(Scanner s) {
		cart.print();
		int choice;
		do {
			cartMenu();
			choice = s.nextInt();
			s.nextLine();

			switch (choice) {
				case 1:
					filterMediasInCart(s);
					break;
				case 2:
					sortMediasInCart(s);
					break;
				case 3:
					removeMediaFromCart(s);
					break;
				case 4:
					playMedia(s);
					break;
				case 5:
					placeOrder();
					break;
				case 0:
					break;
				default:
					System.out.println("Invalid choice!");
			}
		} while (choice != 0);
	}
	
	public static void filterMediasInCart(Scanner s) {
		System.out.println("");
		System.out.println("Filter by: ");
		System.out.println("1. ID");
		System.out.println("2. Title");
		System.out.print("Choose an option: ");
		int choice = s.nextInt();
		s.nextLine();

		if (choice == 1) {
			System.out.print("Enter ID: ");
			int id = s.nextInt();
			s.nextLine();
			cart.searchByID(id);
		} else if (choice == 2) {
			System.out.print("Enter title: ");
			String title = s.nextLine();
			cart.searchByTitle(title);
		} else {
			System.out.println("Invalid option!");
		}
	}
	
	public static void sortMediasInCart(Scanner s) {
		System.out.println("");
		System.out.println("Sort by: ");
		System.out.println("1. Title");
		System.out.println("2. Cost");
		System.out.print("Choose an option: ");
		int choice = s.nextInt();
		s.nextLine();

		if (choice == 1) {
			cart.sortByTitleCost();
		} else if (choice == 2) {
			cart.sortByCostTitle();
		} else {
			System.out.println("Invalid option!");
		}
	}
	
	public static void removeMediaFromCart(Scanner scanner) {
		System.out.print("Enter the title: ");
		String title = scanner.nextLine();
		Media mediaToRemove = cart.takeByTitle(title);
		cart.removeMedia(mediaToRemove);
	}

	public static void placeOrder() {
		System.out.println("Order placed successfully!");
		cart.clear();
	}
	
	public static void updateStore(Scanner s, Store store) {
		System.out.println("");
		System.out.println("Update Store Options: ");
		System.out.println("1. Add a media");
		System.out.println("2. Remove a media");
		System.out.print("Choose an option: ");
		int choice = s.nextInt();
		s.nextLine();

		switch (choice) {
			case 1:
				addMediaStore(s, store);
				break;
			case 2:
				removeMediaStore(s, store);
				break;
			default:
				System.out.println("Invalid option!");
		}
	}
	
	private static void addMediaStore(Scanner s, Store store) {
		System.out.println("");
		System.out.println("Choose the type of media to add: ");
		System.out.println("1. Book");
		System.out.println("2. Digital Video Disc");
		System.out.println("3. Compact Disc");
		System.out.print("Enter your choice: ");
		int choice = s.nextInt();
		s.nextLine();

		Media media = null;

		switch (choice) {
			case 1:
				// Adding a Book
				System.out.print("Enter title: ");
				String bookTitle = s.nextLine();
				System.out.print("Enter category: ");
				String bookCategory = s.nextLine();
				System.out.print("Enter cost: ");
				float bookCost = s.nextFloat();
				s.nextLine();
				Book book = new Book(bookTitle, bookCategory, bookCost);
				while (true) {
					System.out.print("Do you want to add an author of the book? (yes/no): ");
					String addTrack = s.nextLine();
					if (addTrack.equalsIgnoreCase("yes")) {
						System.out.print("Enter author name: ");
						String authorName = s.nextLine();
						book.addAuthor(authorName);
					} else {
						break;
					}
				}
				media = book;
				break;
			case 2:
				// Adding a Digital Video Disc
				System.out.print("Enter title: ");
				String dvdTitle = s.nextLine();
				System.out.print("Enter category: ");
				String dvdCategory = s.nextLine();
				System.out.print("Enter cost: ");
				float dvdCost = s.nextFloat();
				s.nextLine();
				System.out.print("Enter director: ");
				String director = s.nextLine();
				System.out.print("Enter length(in minutes): ");
				int dvdLength = s.nextInt();
				s.nextLine();
				media = new DigitalVideoDisc(dvdTitle, dvdCategory, director, dvdLength, dvdCost);
				break;
			case 3:
				// Adding a Compact Disc
				System.out.print("Enter title: ");
				String cdTitle = s.nextLine();
				System.out.print("Enter category: ");
				String cdCategory = s.nextLine();
				System.out.print("Enter cost: ");
				float cdCost = s.nextFloat();
				s.nextLine();
				System.out.print("Enter artist: ");
				String artist = s.nextLine();
				CompactDisc cd = new CompactDisc(artist, cdTitle, cdCategory, cdCost);
				while (true) {
					System.out.print("Do you want to add a track? (yes/no): ");
					String addTrack = s.nextLine();
					if (addTrack.equalsIgnoreCase("yes")) {
						System.out.print("Enter track title: ");
						String trackTitle = s.nextLine();
						System.out.print("Enter track length: ");
						int trackLength = s.nextInt();
						s.nextLine();
						cd.addTrack(new Track(trackTitle, trackLength));
					} else {
						break;
					}
				}
				media = cd;
				break;
			default:
				System.out.println("Invalid choice.");
				return; // Exit the method
		}

		if (media != null) {
			store.addMedia(media);
			System.out.println("Media has been added to the store.");
		}
	}
	
	private static void removeMediaStore(Scanner scanner, Store store) {
		System.out.println("");
		System.out.print("Enter the title of the media to remove: ");
		String title = scanner.nextLine();
		Media media = store.searchByTitle(title);
		if (media != null) {
			store.removeMedia(media);
			System.out.println("Media has been removed from the store.");
		} else {
			System.out.println("Media is not in the store.");
		}
	}

}
