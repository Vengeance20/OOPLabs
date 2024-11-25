//6.5
package hust.soict.cybersecurity.lab01;

import java.util.Arrays;
import java.util.Scanner;

public class Array {
	public static void main(String[] args) {
		Scanner inp = new Scanner(System.in);
		//input size of array
		int n = inp.nextInt();
		int[] arr = new int[n];
		int sum = 0;
		//input values into array
		for (int i = 0; i < n; i++) {
			arr[i] = inp.nextInt();
		}
		//sort values in array
		Arrays.sort(arr);
		System.out.print("Sorted array: ");
		//output sorted array, sum and average value
		for (int i = 0; i < n; i++) {
			sum += arr[i];
			System.out.print(arr[i] + " ");
		}
		System.out.print("\n");
		System.out.println("Sum: " + sum);
		System.out.println("Average: " + (double)sum / n);
		
	}
}
