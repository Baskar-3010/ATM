package MainPackage;

import java.util.ArrayList;
import java.util.Scanner;

import customer.Customers;

public class MainClass {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to ATM");
		int f = 0;
		while (true) {
			Customers c = new Customers();
			ArrayList<Customers> al = c.customerDetails();

			System.out.println("\n------Choices-------");
			System.out.println("1.Load Cash \n2.Show Customer Details \n3.Operations \n4.Exit");
			System.out.println("Enter your choice:");
			int ch = sc.nextInt();
			Cash.LoadCash cashLoading = new Cash.LoadCash();
			switch (ch) {
			case 1:

				System.out.println("Enter how many 2000 rupees notes to load:");
				int amt2000 = sc.nextInt();
				System.out.println("Enter how many 500 rupees notes to load:");
				int amt500 = sc.nextInt();
				System.out.println("Enter how many 100 rupees notes to load:");
				int amt100 = sc.nextInt();
				cashLoading.loadCash(amt2000, amt500, amt100);
				break;
			case 2:
				Customers customers = new Customers();
				if (f == 0) {

					customers.writeCustomers();
				} else {
					customers.customerDetails();

				}
				break;
			case 3:

				System.out.println("Enter Account number:");
				int acc_no = sc.nextInt();
				System.out.println("Enter pin:");
				int pin = sc.nextInt();
				int correct_pin = 0;
				int balance = 0;
				for (Customers cus : al) {
					if (cus.getAcc_no() == acc_no) {
						correct_pin = cus.getPin();
						balance = cus.getAcc_balance();
					}
				}

				if (pin == correct_pin) {

					System.out.println("\n------Choices--------");
					System.out.println(
							"1.Check Balance\n2.Withdraw money\n3.Transfer Money\n4.Check ATM Balance\n5.Exit");
					System.out.println("Enter choices");
					int choice = sc.nextInt();
					switch (choice) {
					case 1:
						System.out.println("Available balance id ₹" + balance);
						break;
					case 2:
						withdrawClass wd = new withdrawClass();
						wd.withdraw(acc_no);
						break;
					case 3:
						break;
					case 4:
						cashLoading.Atmbalance();
						break;
					case 5:
						System.exit(0);
						break;
					default:
						System.out.println("Invalid choice");
					}
				}

				else {
					System.out.println("Invalid Account number / pin");
				}
				break;

			case 4:
				System.out.println("Exiting....");
				System.exit(0);
			default:
				System.out.println("Invalid options");
			}

		}
	}
}
