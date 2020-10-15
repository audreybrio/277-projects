package project2;

/**
 *@author Audrey Brio
 *Release Date: Feb 21, 2019
 *Description: a subclass of a subclass that lets the user order macaroons 
 * **/

import java.util.ArrayList;
import java.util.Scanner;

public class Macaroon extends Cookie {

	//instance variables
	private String macaroon;
	private double costMacaroon = 0.00;
	private ArrayList<Integer> totalMacaroons = new ArrayList<Integer>();
	private int totalNum;
	private int totalCM;
	private int totalGTM;
	private double tax = 0.098;
	
	/**
	 * method allows user to enter how many macaroons they want and how many of each type of macaroon they want
	 *@return totalMacaroons - an arrayList of the total amount of macaroons the user wanted as well as the toal num of 
	 *chocolate macaroons and green tea macaroons the user wanted
	 * **/
	public ArrayList allMacaroons() {
		int MacaroonsLeft;
		Scanner input = new Scanner(System.in);
		System.out.println("How many macaroons would you like to purchase?: ");
		totalNum = input.nextInt();
		totalMacaroons.add(totalNum);
		if(totalNum == 1) {
			System.out.println("Please choose a macaroon:" + "\n1. Chocolate Macaroon" + "\n2. Green Tea Macaroon");
			Scanner input1 = new Scanner(System.in);
			System.out.println("Please make a selection: ");
			macaroon = input1.nextLine();
			if(macaroon.equals("1")  || macaroon.equals("Chocolate macaroon") || macaroon.equals("chocolate macaroon")) {
				totalCM = 1;
			}
			else if(macaroon.equals("2")  || macaroon.equals("Green Tea Macaroon") || macaroon.equals("green tea macaroon")) {	
				totalGTM = 1;
			}
		}
		else {
			System.out.println("Macaroons: \n1. Chocolate Macaroons \n2. Green Tea Macaroons");
			Scanner input2 = new Scanner(System.in);
			System.out.println("How many chocolate macaroons would you like?: ");
			totalCM = input2.nextInt();
			totalMacaroons.add(totalCM);
			MacaroonsLeft = totalNum - totalCM;
			Scanner input3 = new Scanner(System.in);
			System.out.println("How many green tea macaroons would you like?: ");
			totalGTM = input3.nextInt();
			totalMacaroons.add(totalGTM);
			MacaroonsLeft = MacaroonsLeft - totalGTM;
			if(MacaroonsLeft > 0) {
				System.out.println("You still have "+ MacaroonsLeft + " macaroons left. Please complete your order. You got " + MacaroonsLeft + " more choclate chip cookies.");
				totalCM = totalCM + MacaroonsLeft;
				totalMacaroons.set(1, totalCM);
			}
		}
		return(totalMacaroons);
		}
	/**
	 * method overrides method of dessert item to find specific cost per trio of macaroons
	 * @return costMacaroon - the cost of the amount of macaroons the user ordered as a double
	 * **/

	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		double c = 0.00, f = 0.00;
			int a = totalCM / 3;
			int b = totalCM % 3;
			c = (2.50 * a) + (b *1.00);
			int d = totalGTM / 3;
			int e = totalGTM % 3;
			 f = (3.00 *d) + (e * 1.50);
		costMacaroon = c + f;
		super.costDessert.add(costMacaroon);
		return costMacaroon;
	}
	
	/**
	 * string representation of what the user ordered in terms of cookies
	 * @return a string
	 **/
	@Override
	public String toString() {
		String a = String.format("\nMacaroons (%s total)\n    -%s chocolate macaroons \n    -%s green tea macaroonss \n    -Subtotal:		$%.2f%n"  , totalNum, totalCM, totalGTM, costMacaroon);
		//return("You ordered " + totalNum + " cookies. You got " + totalCC + " chocolate chip cookies and " + totalSC + " sugar cookies. The total cost was: $" + costCookie);
		return a;
	}
}
