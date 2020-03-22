package makeChange;

import java.util.Scanner;

/*
 * Thompson, Darin
 * 20 March 2020
 * MakeChange App - Skill Distillery Week 1 Homework Assignment
 * 
 * 
 * I have set up a loop to be able to test all the cases without having to keep re-running the app.
 * just enter 0 for item amount to stop the program
 */

public class makeChangeApp {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("WELCOME TO THE CHANGE MAKER STORE OF MAGIC!!!!!\n");
		while (true) {
			double itemPrice = ValidateInput("Item Amount: ") * 100;

			// Delete these lines of code if need of test case with 0 for price
			if (itemPrice == 0) {
				sc.close();
				System.out.print("Good-Bye!");
				System.exit(0);
			}

			double amountTendered = ValidateInput("Amount tendered: ") * 100;
			makeChange(itemPrice, amountTendered);
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
				System.err.println("Invalid amount(Must be a number).");
				printSpacing();
				System.out.println();
				sc.nextLine();
			}
		}
		return userNum;
	}

	static void makeChange(double _itemPrice, double _amountTendered) {
		int tens = 0, fives = 0, ones = 0, qts = 0, dms = 0, nks = 0, pns = 0;
		int[] monies = new int[7];

		if (_amountTendered < _itemPrice) {
			printSpacing();
			System.err.println("insufficient funds...\n");
		} else if (_amountTendered == _itemPrice) {
			System.out.println("Nice doing business with you! Come again soon!");
		} else {
			double changeLeft = (_amountTendered - _itemPrice);
			while (changeLeft >= 1000) {
				tens++;
				monies[0] = tens;
				changeLeft = changeLeft - 1000;
			}
			while (changeLeft >= 500) {
				fives++;
				monies[1] = fives;
				changeLeft = changeLeft - 500;
			}
			while (changeLeft >= 100) {
				ones++;
				monies[2] = ones;
				changeLeft = changeLeft - 100;
			}
			while (changeLeft >= 25) {
				qts++;
				monies[3] = qts;
				changeLeft = changeLeft - 25;
			}
			while (changeLeft >= 10) {
				dms++;
				monies[4] = dms;
				changeLeft = changeLeft - 10;
			}
			while (changeLeft >= 5) {
				nks++;
				monies[5] = nks;
				changeLeft = changeLeft - 5;
			}
			while (changeLeft >= 1) {
				pns++;
				monies[6] = pns;
				changeLeft = changeLeft - 1;
			}

			System.out.println("");
			System.out.println("Total Change: $" + String.format("%.2f", ((_amountTendered - _itemPrice) / 100)));
			printSpacing();
			PrintChangeArray(monies);
		}
	}

	static void PrintChangeArray(int[] coinArray) {
		for (int i = 0; i < coinArray.length; i++) {
			if (coinArray[i] != 0) {
				switch (i) {
				case 0:
					System.out.print("Tens: " + coinArray[i] + " | ");
					break;
				case 1:
					System.out.print("Fives: " + coinArray[i] + " | ");
					break;
				case 2:
					System.out.print("Ones: " + coinArray[i] + " | ");
					break;
				case 3:
					System.out.print("Quarters: " + coinArray[i] + " | ");
					break;
				case 4:
					System.out.print("Dimes: " + coinArray[i] + " | ");
					break;
				case 5:
					System.out.print("Nickels: " + coinArray[i] + " | ");
					break;
				case 6:
					System.out.print("Pennies: " + coinArray[i] + " | ");
					break;
				}
			}
		}
		System.out.println("\n");
	}

	static void printSpacing() {
		System.out.println("*************************************************");
	}
}
