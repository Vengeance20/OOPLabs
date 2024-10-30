public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0;
	private float total = 0;
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered < 20) {
			itemsOrdered[qtyOrdered] = disc;
			qtyOrdered++;
			System.out.println("The disc has been added");
		}
		else {
			System.out.println("The cart is almost full");
		}
	}
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		int ind = 0;
		for (int i = 0; i < qtyOrdered; i++) {
			if(disc.equals(itemsOrdered[i])) {
				ind = i;
			}
		}
		for (int i = ind; i < qtyOrdered; i++) {
			itemsOrdered[i] = itemsOrdered[i + 1];
		}
		qtyOrdered--;
		System.out.println("The disc has been removed");	
	}
	public float totalCost() {
		for(int i = 0; i < qtyOrdered; i++) {
			if (itemsOrdered[i] == null) {
				continue;
			}
			total += itemsOrdered[i].getCost();
		}
		return total;
	}
}
