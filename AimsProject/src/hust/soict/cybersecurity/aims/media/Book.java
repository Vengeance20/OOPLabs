package hust.soict.cybersecurity.aims.media;

import java.util.ArrayList;
import java.util.List;
public class Book extends Media {

	private List<String> authors = new ArrayList<String>();
	
	public Book(String title, String category, float cost) {
		super(title, category, cost);
	}

	public void addAuthor(String authorName) {
		boolean added = false;
		for (String author: authors) {
			if (author.equals(authorName)) {
				added = true;
				break;
			}
		}
		if (added) {
			System.out.println("This author has already been added");
		}
		else {
			authors.add(authorName);
			System.out.println("Author " + authorName + " has been added");
		}
	}
	
	public void removeAuthor(String authorName) {
		boolean removed = true;
		for (String author: authors) {
			if(author.equals(authorName)) {
				removed = false;
				break;
			}
		}
		if (removed) {
			System.out.println("This author does not exist");
		}
		else {
			authors.remove(authorName);
			System.out.println("This author has been removed");
		}
	}
	
	public String toString() {
		String s = "";
		for (String author : authors) {
			s += author;
			s += ", ";
		}
		return getTitle() + " - " + getCategory() + " - " + s + "- "  + getCost() + " $";
	}
}
