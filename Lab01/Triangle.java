//6.3

import java.util.Scanner;
public class Triangle {
	public static void main(String[] args) {
		Scanner inp = new Scanner(System.in);
		int n = inp.nextInt();
		for (int i = 0; i < n; i++) {
			String blank = "";
			String stars = "";
			for (int j = 1; j < n - i; j++) {
				blank += " ";
			}
			for (int k = 0; k < 2*i + 1; k++) {
				stars += "*";
			}
			System.out.println(blank + stars);
		}
	}
}
