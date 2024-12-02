package hust.soict.cybersecurity.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {

	@Override
	public int compare(Media m1, Media m2) {
        return Comparator.comparingDouble(Media::getCost).reversed()
                .thenComparing(Media::getTitle).compare(m1, m2);
	}
	
}
