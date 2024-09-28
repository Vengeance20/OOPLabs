//6.5
import java.util.Scanner;
import java.util.Arrays;

public class Array {
	public static void main(String[] args) {
		Scanner inp = new Scanner(System.in);
		int n = inp.nextInt();
		int[] arr = new int[n];
		int sum = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = inp.nextInt();
		}
		Arrays.sort(arr);
		System.out.print("Sorted array: ");
		for (int i = 0; i < n; i++) {
			sum += arr[i];
			System.out.print(arr[i] + " ");
		}
		System.out.print("\n");
		System.out.println("Sum: " + sum);
		System.out.println("Average: " + (double)sum / n);
		
	}
}
