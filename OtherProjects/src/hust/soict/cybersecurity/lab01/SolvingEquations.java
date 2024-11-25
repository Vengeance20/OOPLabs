//2.2.6
package hust.soict.cybersecurity.lab01;

import java.util.Scanner;

public class SolvingEquations {
	public static void main(String[] args) {
		Scanner inp = new Scanner(System.in);
		//first-degree equation with one variable: ax + b = 0
		System.out.println("Solving ax + b = 0");
		//input coefficients
		System.out.print("Input a: ");
		double a = inp.nextDouble();
		System.out.print("Input b: ");
		double b = inp.nextDouble();
		//Case 1: a != 0
		if (a != 0) {
			System.out.println("x = " + (double)-b/a + "\n");
		}
		//Case 2: a = 0
		else {
			//Case b = 0
			if (b == 0) {
				System.out.println("Infinite solutions\n");
			}
			//Case b != 0
			else {
				System.out.println("No solutions\n");
			}
		}
		
		/*system of first-degree equations 
		 * a_11*x_1 + a_12*x_2 = b_1
		 * a_21*x_1 + a_22*x_2 = b_2
		 */
		System.out.println("Solving\na_11*x_1 + a_12*x_2 = b_1\n"
				+ "a_21*x_1 + a_22*x_2 = b_2 ");
		//input coefficients
		System.out.print("Input a_11: ");
		double a_11 = inp.nextDouble();
		System.out.print("Input a_12: ");
		double a_12 = inp.nextDouble();
		System.out.print("Input a_21: ");
		double a_21 = inp.nextDouble();
		System.out.print("Input a_22: ");
		double a_22 = inp.nextDouble();
		System.out.print("Input b_1: ");
		double b_1 = inp.nextDouble();
		System.out.print("Input b_2: ");
		double b_2 = inp.nextDouble();
		//calculating determinants
		double D = a_11 * a_22 - a_21 * a_12;
		double D1 = a_22 * b_1 - a_12 * b_2;
		double D2 = a_11 * b_2 - a_21 * b_1;
		//Case 1: D != 0
		if (D != 0) {
			System.out.println("x1 = " + D1/D + "\n" + "x2 = " + D2/D + "\n");
		}
		//Case 2: D = 0
		else {
			//Case D1 or D2 != 0
			if (D1 != 0 || D2 != 0) {
				System.out.println("No solutions\n");
			}
			//Case D = D1 = D2 = 0
			else {
				System.out.println("Infinite Solutions\n");
			}
		}
		
		//quadratic equation Ax^2 + Bx + C = 0
		System.out.println("Solving Ax^2 + Bx + C = 0");
		//input coefficients
		System.out.print("Input A: ");
		double A = inp.nextDouble();
		System.out.print("Input B: ");
		double B = inp.nextDouble();
		System.out.print("Input C: ");
		double C = inp.nextDouble();
		//calculating delta
		double delta = B * B - 4 * A * C;
		//Case 1: A = 0
		if (A == 0) {
			//Case B = 0
			if (B == 0) {
				if (C != 0) {
					System.out.println("x = " + (double)-C/B + "\n");
				}
				//Case: B = 0
				else {
					//Case C = 0
					if (C == 0) {
						System.out.println("Infinite solutions\n");
					}
					//Case C != 0
					else {
						System.out.println("No solutions\n");
					}
				}
			}
		}
		//Case 2: A != 0
		else {
			if (delta > 0) {
				System.out.println("x1 = " + (-B + Math.sqrt(delta))/(2 * A) + "\n");
				System.out.println("x2 = " + (-B - Math.sqrt(delta))/(2 * A) + "\n");
			}
			else if (delta == 0) {
				System.out.println("x = " + -B/(2 * A) + "\n");
			}
			else {
				System.out.println("No solutions\n");
			}
		}
	}
}
