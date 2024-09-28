//6.4
import java.util.Scanner;

public class DaysInMonth {
	public static void main(String[] args) {
		//array of valid month input 
		String[] months = {"January", "February", "March", "April",
				"May", "June", "July", "August", "September",
				"October", "November", "December"};
		String[] months_abbr = {"Jan.", "Feb.", "Mar.", "Apr.",
				"May", "June", "July", "Aug.", "Sept.", "Oct.",
				"Nov.", "Dec."};
		String[] months_3 = {"Jan", "Feb", "Mar", "Apr", "May",
				"Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
		String[] months_num = {"1", "2", "3", "4", "5", "6", "7",
				"8", "9", "10", "11", "12"};
		while(true) {
			Scanner inp = new Scanner(System.in);
			//input month and year
			System.out.print("Month: ");
			String month = inp.next();
			System.out.print("Year: ");
			int year = inp.nextInt();
			boolean temp = false;
			//check if inputs are valid
			for (int i = 0; i < 12; i++) {
				temp = (month.equals(months[i]) || month.equals(months_num[i]))
						|| month.equals(months_3[i]) || month.equals(months_abbr[i])
						&& year >= 0;
				if (temp == true) {
					month = months[i];
					break;
					}
				}
			if (temp == true) {
				//check month
				if (month.equals(months[0]) || month.equals(months[2])
						|| month.equals(months[4]) || month.equals(months[6])
						|| month.equals(months[7]) || month.equals(months[9])
						|| month.equals(months[11])) {
					System.out.println("Days: " + 31);
				}
				else if (month.equals(months[1])) {
					//check for leap year
					if ((year % 4 == 0 && year % 100 != 0) ||
							year % 400 == 0) {
						System.out.println("Days: " + 29);
					}
					else {
						System.out.println("Days; " + 28);
					}
				}
				else {
					System.out.println("Days: " + 30);
				}
				break;
			}
			//type again if inputs are invalid
			else {
				System.out.println("Type again: ");
			}
		}
		
	}
}
