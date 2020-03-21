package makeChange;

import java.util.Scanner;

/*
 * I have set up a loop to be able to test all the cases without having to keep re-running the app.
 * just enter 0 for item amount to stop the program
 */
public class makeChangeApp {

	static Scanner sc = new Scanner(System.in);
	static String ERROR = "\u001B[31m";
	public static void main(String[] args) {

		while (true) {
			int tens = 0, fives = 0, ones = 0, qts = 0, dms = 0, nks = 0, pns = 0;
			int[] monies = new int[7];
			double amountLeft;
			double price = ValidateInput("Item Amount: ");

			if (price == 0) {
				sc.close();
				System.exit(0);
			}

			double amount = ValidateInput("Amount tendered: ");
			amount += 0.0005;
			if (amount < price) {
				printSpacing();
				System.out.println("insufficient funds...\n");
			} else if (amount == price) {
				System.out.println("Nice doing business with you! Come again soon!");
			} else {
				amountLeft = amount - price;
				while (amountLeft >= 10.0) {
					tens++;
					monies[0] = tens;
					amountLeft = amountLeft - 10.0;
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

				System.out.println("");
				System.out.println("Total Change: $" + String.format("%.2f", (amount - price)));
				printSpacing();
				for (int i = 0; i < monies.length; i++) {
					if (monies[i] != 0) {
						switch (i) {
						case 0:
							System.out.print("Tens: " + monies[i] + " | ");
							break;
						case 1:
							System.out.print("Fives: " + monies[i] + " | ");
							break;
						case 2:
							System.out.print("Ones: " + monies[i] + " | ");
							break;
						case 3:
							System.out.print("Quarters: " + monies[i] + " | ");
							break;
						case 4:
							System.out.print("Dimes: " + monies[i] + " | ");
							break;
						case 5:
							System.out.print("Nickels: " + monies[i] + " | ");
							break;
						case 6:
							System.out.print("Pennies: " + monies[i] + " \n\n");
						}
					}
				}
			}
		}
	}

	public static double ValidateInput(String prompt) {
		double userNum;
		while (true) {
			System.out.print(prompt);
			try {
				userNum = sc.nextDouble();
				break;
			} catch (Exception e) {
				System.out.println(ERROR + "Invalid amount.");
				printSpacing();
				System.out.println();
				sc.nextLine();
			}
		}
		return userNum;
	}
	
	static void printSpacing() {
		System.out.println("*************************************************");
	}
}
