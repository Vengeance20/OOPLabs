package hust.soict.cybersecurity.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {

	@Override
	public int compare(Media m1, Media m2) {
        return Comparator.comparing(Media::getTitle)
                .thenComparing((media1, media2) -> Double.compare(media2.getCost(), media1.getCost()))
                .compare(m1, m2);
	}
	
}
