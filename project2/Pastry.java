package project2;
/**
 * @author Audrey Brio
 * Release Date: February 21, 2019
 * Description: this class is a subclass of the dessert items class, and allows user to order a pastry from 2 different 
 * options and can decide how many pastries they want in tota,
 **/
import java.util.ArrayList;
import java.util.Scanner;

public class Pastry extends DessertItem{
	//instance variables
	private String pastry;
	private double costPastry = 0.00;
	private ArrayList<Integer> totalPastries = new ArrayList<Integer>();
	private int totalNum;
	private int totalB;
	private int totalM;
	private double tax = 0.098;
	private boolean heated = false;
	int i = 0;
	
	/**
	 * method allows user to enter how many pastries they want and how many of each type of pastry they want
	 *@return totalPastries - an arrayList of the total amount of pastries the user wanted as well as the total num of 
	 *bagels and muffins the user wanted
	 * **/
	
	public ArrayList allPastries() {
		int pastriesLeft;
		Scanner input = new Scanner(System.in);
		System.out.println("How many pastries would you like to purchase?: ");
		totalNum = input.nextInt();
		totalPastries.add(totalNum);
		if(totalNum == 1) {
			System.out.println("Please choose a pastry:" + "\n1. Bagels" + "\n2.  Muffins");
			Scanner input1 = new Scanner(System.in);
			System.out.println("Please make a selection: ");
			pastry = input1.nextLine();
			if(pastry.equals("1")  || pastry.equals("Bagels") || pastry.equals("bagels")) {
				totalB = 1;
			}
			else if(pastry.equals("2")  || pastry.equals("Muffins") || pastry.equals("muffins")) {	
				totalM = 1;
			}
		}
		else {
			System.out.println("Pastries: \n1. Bagels \n2. Muffins");
			Scanner input2 = new Scanner(System.in);
			System.out.println("How many bagels would you like?: ");
			totalB = input2.nextInt();
			totalPastries.add(totalB);
			pastriesLeft = totalNum - totalB;
			String h;
			Scanner input3 = new Scanner(System.in);
			System.out.println("Would you like to heat up your pastry?: ");
			h = input3.nextLine();
			if(h.equals("y")) {
				Scanner input4 = new Scanner(System.in);
				System.out.println("How many would you like heated up?: ");
				i = input4.nextInt();
				heated = true;
			}
			Scanner input5 = new Scanner(System.in);
			System.out.println("How many muffins would you like?: ");
			totalM = input5.nextInt();
			int j;
			String k;
			Scanner input6 = new Scanner(System.in);
			System.out.println("Would you like to heat up your pastry?: ");
			k = input6.nextLine();
			if(k.equals("y")) {
				Scanner input7 = new Scanner(System.in);
				System.out.println("How many would you like heated up?: ");
				j = input7.nextInt();
				i = j + i;
				heated = true;
			}
			totalPastries.add(totalM);
			pastriesLeft = pastriesLeft - totalM;
			if(pastriesLeft > 0) {
				System.out.println("You still have "+ pastriesLeft + " pastries left. Please complete your order.");
				System.out.println("You got " + pastriesLeft + " more bagels.");
				totalB = totalB + pastriesLeft;
				totalPastries.set(1, totalB);
			}
		}
		return(totalPastries);
		}
	
	/**
	 * method overrides method of dessert item to find specific cost for the pastries and whether or not the user wanted
	 * them heated up
	 * @return costPastry - the cost of the amount of pastries the user ordered as a double
	 * **/
	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		double preTax = totalNum * 1.50;
		if(heated == true) {
			preTax = preTax + (i * 0.25);
		}
		double taxAmt = preTax * tax;
		costPastry = taxAmt + preTax;
		super.costDessert.add(costPastry);
		return costPastry;
	}
	/**
	 * string representation of what the user ordered in terms of pastries
	 * @return a string
	 **/
	@Override
	public String toString() {
		String a = String.format("\nPastries (%s total) \n    -%s bagels \n    -%s muffins \n    -Subtotal:	$%.2f%n", totalNum, totalB, totalM, costPastry);
		return a;
	}

}
