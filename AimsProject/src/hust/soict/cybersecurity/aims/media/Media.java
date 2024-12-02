package hust.soict.cybersecurity.aims.media;

import java.util.Comparator;

public abstract class Media implements Comparable<Media> {
	
	private int id;
	private String title;
	private String category;
	private float cost;
	
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = 
			new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = 
			new MediaComparatorByCostTitle();

	public Media(String title) {
		super();
		this.title = title;
	}

	public Media(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}

	public String getCategory() {
		return category;
	}

	public float getCost() {
		return cost;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || !(o instanceof Media)) {
			return false;
		}
		
		Media other = (Media) o;
		
		return this.title != null && this.title == (other.title);
	}
	
    public int compareTo(Media m) {
        int titleComparison = this.title.compareTo(m.title);
        if (titleComparison != 0) {
            return titleComparison;
        }
        return Double.compare(m.cost, this.cost);
    }
}
