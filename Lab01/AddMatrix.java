//6.6
import java.util.Scanner;

public class AddMatrix {
	public static void main(String[] args) {
		Scanner inp = new Scanner(System.in);
		//input matrix size height x width
		System.out.println("Input matrices size: ");
		System.out.print("Height: ");
		int r = inp.nextInt();
		System.out.print("Width: ");
		int c = inp.nextInt();
		int[][] m1 = new int[r][c];
		int[][] m2 = new int[r][c];
		//input 1st matrix
		System.out.println("Input values of matrix 1 : ");
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				m1[i][j] = inp.nextInt();
			}
		}
		//input 2nd matrix
		System.out.println("Input values of matrix 2: ");
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				m2[i][j] = inp.nextInt();
			}
		}
		//output sum of 2 matrices
		System.out.println("Sum of 2 matrices");
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(m1[i][j] + m2[i][j] + "\t");
			}
			System.out.print("\n");
		}
	}
}
