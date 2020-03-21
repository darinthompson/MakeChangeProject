package makeChange;

import java.util.Scanner;

public class makeChangeApp {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		while (true) { // <-- added this while loop to run the test cases without having to re-run the
						// program
			int tens = 0, fives = 0, ones = 0, qts = 0, dms = 0, nks = 0, pns = 0;
			int[] monies = new int[7];
			double amountLeft;
			System.out.print("Price of item: ");
			double price = sc.nextDouble();

			System.out.print("Amount tendered: ");
			double amount = sc.nextDouble();
			amount += 0.0005;
			if (amount < price) {
				System.out.println("insufficient funds...");
			} else if (amount == price) {
				System.out.println("Nice doing business with you! Come again soon!");
			} else {
				amountLeft = amount - price;
				while (amountLeft >= 10.0) {
					tens++;
					monies[0] = tens;
					amountLeft = amountLeft - 10.0;
					sc.nextLine();
				}
				while (amountLeft >= 5.0) {
					fives++;
					monies[1] = fives;
					amountLeft = amountLeft - 5.0;
				}
				while (amountLeft >= 1.0) {
					ones++;
					monies[2] = ones;
					amountLeft = amountLeft - 1.0;
				}
				while (amountLeft >= .25) {
					qts++;
					monies[3] = qts;
					amountLeft = amountLeft - .25;
				}
				while (amountLeft >= .10) {
					dms++;
					monies[4] = dms;
					amountLeft = amountLeft - .10;
				}
				while (amountLeft >= .05) {
					nks++;
					monies[5] = nks;
					amountLeft = amountLeft - .05;
				}
				while (amountLeft >= .01) {
					pns++;
					monies[6] = pns;
					amountLeft = amountLeft - .01;
				}

				System.out.println("Total Change: $" + String.format("%.2f", (amount - price)));
				for (int i = 0; i < monies.length; i++) {
					if (monies[i] != 0) {
						switch (i) {
						case 0:
							System.out.print("Tens: " + monies[i] + " ");
							break;
						case 1:
							System.out.print("Fives: " + monies[i] + " ");
							break;
						case 2:
							System.out.print("Ones: " + monies[i] + " ");
							break;
						case 3:
							System.out.print("Quarters: " + monies[i] + " ");
							break;
						case 4:
							System.out.print("Dimes: " + monies[i] + " ");
							break;
						case 5:
							System.out.print("Nickels: " + monies[i] + " ");
							break;
						case 6:
							System.out.print("Pennies: " + monies[i] + " ");
						}
					}
				}
			}
			
			System.out.println();
			System.out.println("Press ENTER to continue... (Press esc to end program)");
			sc.nextLine();
		}

	}
}
