package project2;
/**
 * @author Audrey Brio
 * Release Date: February 21, 2019
 * Description: this class is a subclass of the dessert ites class, and allows user to order a cookie from 2 different 
 * options and can decide how many cookies they want
 **/
import java.util.ArrayList;
import java.util.Scanner;

public class Cookie extends DessertItem{

	//instance variables
	private String cookie;
	private double costCookie = 0.00;
	private ArrayList<Integer> totalCookies = new ArrayList<Integer>();
	private int totalNum;
	private int totalCC;
	private int totalSC;
	private double tax = 0.098;
	
	/**
	 * method allows user to enter how many cookies they want and how many of each type of cookie they want
	 *@return totalCookies - an arrayList of the total amount of cookies the user wanted as well as the toal num of 
	 *chocolate chip cookies and sugar cookies the user wanted
	 * **/
	public ArrayList allCookies() {
		int cookiesLeft;
		Scanner input = new Scanner(System.in);
		System.out.println("How many cookies would you like to purchase?: ");
		totalNum = input.nextInt();
		totalCookies.add(totalNum);
		if(totalNum == 1) {
			System.out.println("Please choose a cookie:" + "\n1. Chocolate Chip Cookie" + "\n2. Sugar Cookie");
			Scanner input1 = new Scanner(System.in);
			System.out.println("Please make a selection: ");
			cookie = input1.nextLine();
			if(cookie.equals("1")  || cookie.equals("Chocolate Chip Cookie") || cookie.equals("chocolate chip cookie")) {
				totalCC = 1;
			}
			else if(cookie.equals("2")  || cookie.equals("Sugar Cookie") || cookie.equals("sugar cookie")) {	
				totalSC = 1;
			}
		}
		else {
			System.out.println("Cookies: \n1. Chocolate Chip Cookies \n2. Sugar Cookies");
			Scanner input2 = new Scanner(System.in);
			System.out.println("How many chocolate chip cookies would you like?: ");
			totalCC = input2.nextInt();
			totalCookies.add(totalCC);
			cookiesLeft = totalNum - totalCC;
			Scanner input3 = new Scanner(System.in);
			System.out.println("How many sugar cookies would you like?: ");
			totalSC = input3.nextInt();
			totalCookies.add(totalSC);
			cookiesLeft = cookiesLeft - totalSC;
			if(cookiesLeft > 0) {
				System.out.println("You still have "+ cookiesLeft + " cookies left. Please complete your order.");
				System.out.println("You got " + cookiesLeft + " more choclate chip cookies.");
				totalCC = totalCC + cookiesLeft;
				totalCookies.set(1, totalCC);
			}
		}
		return(totalCookies);
		}
	

	/**
	 * method overrides method of dessert item to find specific cost per dozen cookies
	 * @return costCookie - the cost of the amount of cookies the user ordered as a double
	 * **/
	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		if(totalNum >= 12) {
			int a = totalNum / 12;
			int b = totalNum % 12;
			costCookie = (10.00 * a) + (b *0.89);
			
		}
		else {
		costCookie = totalNum * 0.89;
	}
		super.costDessert.add(costCookie);
		return costCookie;
	}
	
	/**
	 * string representation of what the user ordered in terms of cookies
	 * @return a string
	 **/
	@Override
	public String toString() {
		String a = String.format("Cookies (%s total)\n    -%s chocolate chip cookies \n    -%s sugar cookies \n    -Subtotal:		$%.2f%n" , totalNum, totalCC, totalSC, costCookie);
		//return("You ordered " + totalNum + " cookies. You got " + totalCC + " chocolate chip cookies and " + totalSC + " sugar cookies. The total cost was: $" + costCookie);
		return a;
	}
	/**
	 * method overrides a method in super class to compare which cost is greater
	 * @return 1 if statement is true, 0 if it was false
	 * **/
	@Override
	public int compareTo(DessertItem other) {
		if(getCost() > other.getCost()) {
			return 1;
		}
		else {
			return 0;
		}
	}

}
