package project2;

import java.util.ArrayList;
import java.util.Scanner;

public class LoungeTester {

	//private static final String Coupon = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		boolean go = true;
		CashRegister money = new CashRegister();
		System.out.println("Welcome to the Boba Tea Lounge! Please select an option: ");
		while(go == true) {
		int choice;
		Scanner input0 = new Scanner(System.in);
		System.out.println("1. New Sale \n2. Print all Sales \n3. Close Register");
		choice = input0.nextInt();
		
			while(choice == 1) {
				int option;
				Scanner input01 = new Scanner(System.in);
				System.out.println("What would you like to order? \n1. Drink \n2. Dessert \n3. End Purchase \n4. Go back to main menu");
				option = input01.nextInt();
				if(option == 1) {
					int numofDrink;
					Scanner input02 = new Scanner(System.in);
					System.out.println("How many drink items do you want to order?:");
					numofDrink = input02.nextInt();
					for(int i = 0; i < numofDrink; i++) {
						String drink;
						Scanner input03 = new Scanner(System.in);
						System.out.println("Would you like to get a coffee or boba drink?: ");
						drink = input03.nextLine();
						money.enterNewDrink(drink);
					}
					continue;
				}
				else if(option == 2) {
					int numofDessert;
					Scanner input04 = new Scanner(System.in);
					System.out.println("How many dessert items do you want to order?:");
					numofDessert = input04.nextInt();
					for(int i = 0; i < numofDessert; i++) {
						String dessert;
						Scanner input05 = new Scanner(System.in);
						System.out.println("Would you like to get a cookie, pastry, or macarroon dessert?: ");
						dessert = input05.nextLine();
						money.enterNewDessert(dessert);
					}
					continue;
				}
				else if(option == 3) {
					String b = money.endSale();
					System.out.println(b);
					String useCoupon;
					Scanner input06 = new Scanner(System.in);
					System.out.println("Would you like to use a coupon on your purchase? (Please enter y/n): ");
					useCoupon = input06.nextLine();
					if(useCoupon.equals("y")) {
						money.applyCoupon();
					}
					money.change();
					money.reset();
					continue;
				}
				else if(option == 4) {
					break;
				}
			}
			while(choice == 2) {
				ArrayList<String> receipt;
				receipt = money.allSales();
				receipt.remove(receipt.size()-1);
				System.out.println(receipt);
				double t = money.money();
				String u = String.format("All Sales: $%.2f%n" , t);
				System.out.println(u);
				break;
			}
			while(choice == 3) {
				System.out.println("Thanks for coming!");
				go=false;
				break;
				
			}
		
		} 
		
	}
	
}


