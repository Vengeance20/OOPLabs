//2.2.5
package hust.soict.cybersecurity.lab01;

import java.util.Scanner;

public class TwoNumbers {
	static public void main(String[] args) {
		Scanner inp = new Scanner(System.in);
		//input double numbers
		double a = inp.nextDouble();
		double b = inp.nextDouble();
		double sum = a + b;
		//calculate sum, difference, product and quotient
		System.out.println("Sum: " + sum);
		System.out.println("Difference: " + Math.abs(a - b));
		System.out.println("Product: " + a*b);
		//if b equals 0, quotient cannot be calculated
		if (b == 0) {
			System.out.println("Quotient: Undefined");
		}
		else {
			System.out.println("Quotient: " + a/b);
		}
	}
}
