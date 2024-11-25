//6.3
package hust.soict.cybersecurity.lab01;

import java.util.Scanner;
public class Triangle {
	public static void main(String[] args) {
		Scanner inp = new Scanner(System.in);
		//input height
		int n = inp.nextInt();
		//adding blanks and stars to form a triangle
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
