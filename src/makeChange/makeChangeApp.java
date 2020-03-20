package makeChange;

import java.util.Scanner;

public class makeChangeApp {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		while (true) {
			double tens = 0, fives = 0, ones = 0, qts = 0, dms = 0, nks = 0, pns = 0;
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
					amountLeft = amountLeft - 10.0;
					System.out.println(amountLeft);
					sc.nextLine();
				}
				while (amountLeft >= 5.0) {
					fives++;
					amountLeft = amountLeft - 5.0;
					System.out.println(amountLeft);
				}
				while (amountLeft >= 1.0) {
					ones++;
					amountLeft = amountLeft - 1.0;
					System.out.println(amountLeft);
				}
				while (amountLeft >= .25) {
					qts++;
					amountLeft = amountLeft - .25;
					System.out.println(amountLeft);
				}
				while (amountLeft >= .10) {
					dms++;
					amountLeft = amountLeft - .10;
				}
				while (amountLeft >= .05) {
					nks++;
					amountLeft = amountLeft - .05;
					System.out.println(amountLeft);
				}
				while (amountLeft >= .01) {
					pns++;
					amountLeft = amountLeft - .01;
					System.out.println(amountLeft);
				}
				System.out.println("Total Change: $" + String.format("%.2f", (amount - price)));
				System.out.println("Denomination: Tens - " + (int)tens + ", Fives - " + (int)fives + ", Ones - " + (int)ones + ", Quarters - " + (int)qts
						+ ", Dimes - " + (int)dms + ", Nickles - " + (int)nks + ", Pennies - " + (int)pns);
			}
			sc.nextLine();
		}

	}
}
