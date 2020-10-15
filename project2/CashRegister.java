package project2;

/**
 * @author Audrey Brio
 * Release Date: February 21, 2019
 * Description: class is the cashregister, so it gives change, prints recepits, gives total
 * 
 * **/
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class CashRegister {
	//instance variables
	private static double totalC = 0.00;
	private static boolean useCoupon = false;
	static String itemType;
	private String a;
	double subDrink = 0.00;
	double subDessert = 0.00;
	private static double total = 0.00;
	private static double subtotal = 0.00;
	private double totalMoney = 0.00;
	private double change = 0.00;
	private double tax = 0.098;
	private int totalSales = 0;
	
	private int drinkTotal = 0;
	private int dessertTotal = 0;
	static ArrayList<DrinkItem> drinks = new ArrayList<DrinkItem>();
	static ArrayList<DessertItem> desserts = new ArrayList<DessertItem>();
	static ArrayList<Double> costDrink = new ArrayList<Double>();
	static ArrayList<Double> costDessert = new ArrayList<Double>();
	ArrayList<String> r = new ArrayList<String>();

	/**
	 * method gets a new drink in and runs the correct class to get the user's order
	 * @param drink - takes in a new drink as a String
	 * @return subDrink - the subtotal of the drink item
	 * **/
	public double enterNewDrink(String drink) {
		double a = 0.00;
		if(drink.equals("boba")) {
			BobaDrink h = new BobaDrink();
			h.SizeDrink();
			h.baseTea();
			h.levelofSweetness();
			h.totalToppings();
			h.addMilk();
			a = h.getCost();
			costDrink.add(a);
			drinks.add(h);
		}
		else if(drink.equals("coffee")) {
			CoffeeDrink j = new CoffeeDrink();
			j.SizeCoffeeDrink();
			j.baseCoffee();
			j.amountofSugar();
			a = j.getCost();
			costDrink.add(a);
			drinks.add(j);
		}
		subDrink = subDrink + a;
		drinkTotal++;
		return subDrink;
	}
	/**
	 * method gets a new dessert in and runs the correct class to get the user's order
	 * @param dessert - takes in a new dessert as a String
	 * @return subDessert - the subtotal of the dessert item
	 * **/
	public double enterNewDessert(String dessert) {
		double b = 0.00;
		if(dessert.equals("cookie")) { //if user wants cookie
			Cookie k = new Cookie();
			k.allCookies();
			b = k.getCost();
			desserts.add(k);
			costDessert.add(b);
		}
		else if(dessert.equals("pastry")){ //if user wants pastry
			Pastry l = new Pastry();
			l.allPastries();
			b = l.getCost();
			costDessert.add(b);
			desserts.add(l);
		}
		else if(dessert.equals("macaroon")) { //if user wants macaroon
			Macaroon m = new Macaroon();
			m.allMacaroons();
			b= m.getCost();
			costDessert.add(b);
			desserts.add(m);
		}
		subDessert = subDessert + b;
		dessertTotal++;
		return subDessert;
	}
	
	/**
	 * this method returns all the money the register has in it
	 * @return totalMoney - the total money the register has in it
	 * **/
	public double money() {
		return totalMoney;
	}
	
	
	/**
	 * method sets the amount in the register to zero
	 **/
	public void clearRegister(){
		totalMoney = 0.00;
	}
	
	/**
	 * method takes the subtotal and adds tax to it
	 * @return total - the total value of the cost including tax
	 **/
	public double tax() {
		subtotal = subDrink + subDessert;
		double taxAmt = subtotal * tax;
		total = taxAmt + subtotal;
		return total;
	}
	/**
	 * method gives the user the correct amount of change depending and works with them using a coupon or not
	 * @return change - the amount that they overpaid and we give back as a double
	 * **/
	public double change() {
		double cash;
		double hi = tax();
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the amount of cash you're paying with: ");
		cash = input.nextDouble();
		totalMoney = totalMoney + cash;
		if(useCoupon == false) {
			change = cash - hi;
			String y = String.format("Change:  $%.2f%n", change);
			System.out.println(y);
			totalMoney = totalMoney - change;
		}
		else if(useCoupon == true) {
			change = cash - totalC;
			String z = String.format("Change:  $%.2f%n", change);
			System.out.println(z);
			totalMoney = totalMoney - change;
		}
		return change;
	}
	   
	/**
	 * method gives option to user and moves according to their response
	 * if yes, calls the coupon class and gives a discount on most expensive item and subtracts discount from total
	 * **/
	public static void applyCoupon(){
	if(costDrink.size() != 0 && costDessert.size() != 0) {
	Double c = Collections.max(costDrink);
	Double d = Collections.max(costDessert);
	//System.out.println(c);
	if(c > d) {
		itemType = "drink";
		if(itemType.equals("drink")){
			useCoupon = true;
			c = Collections.max(costDrink);	
			Coupon Co = new Coupon("drink", 0.20);
			System.out.println(Co);
			double g = c * 0.20;
			String a = String.format("\nCoupon:	-$%.2f%n", g);
			System.out.println(a);
			totalC = total - g;
			//total = totalC;
			String p = String.format("Total: $%.2f%n", totalC);
			System.out.println(p);
	   
	}
	else{//print error message invalid coupon
		useCoupon = false;
		Coupon C = new Coupon();
		System.out.println(C);
	}	
		}
	else if(c<d) { 
		if(costDessert.size()==5) {
			 	itemType = "drink";
			 	useCoupon = true;
				c = Collections.max(costDrink);
				Coupon Copo = new Coupon("drink", 0.25);
				System.out.println(Copo);
				double g = c * 0.25;
				String a = String.format("\nCoupon:	-$%.2f%n", g);
				System.out.println(a);
				totalC = total - g;
				//total = totalC;
				String p = String.format("Total: $%.2f%n", totalC);
				System.out.println(p);
			}
		else {
		itemType = "dessert";
	 if (itemType.equals("dessert")) {
		 useCoupon = true;
	    //find max dessert item�..
		
		d = Collections.max(costDessert);	
		Coupon Coup = new Coupon("dessert", 0.50);
		System.out.println(Coup);
		double h = d * 0.50;
		String b = String.format("\nCoupon:	-$%.2f%n", h);
		System.out.println(b);
		totalC = total - h;
		//total = totalC;
		String p = String.format("Total: $%.2f%n", totalC);
		System.out.println(p);
	}
	else{//print error message invalid coupon
		Coupon C = new Coupon();
		System.out.println(C);
	}	
		}
	}
	}
	else if(costDrink.size() == 0) {
		Double d = Collections.max(costDessert);
		itemType = "dessert";
		 if (itemType.equals("dessert")) {
			 useCoupon = true;
		    //find max dessert item�..
			d = Collections.max(costDessert);	
			Coupon Coup = new Coupon("dessert", 0.10);
			System.out.println(Coup);
			double h = d * 0.10;
			String b = String.format("\nCoupon:	-$%.2f%n", h);
			System.out.println(b);
			totalC = total - h;
			//total = totalC;
			String p = String.format("Total: $%.2f%n", totalC);
			System.out.println(p);
		}
		else{//print error message invalid coupon
			Coupon C = new Coupon();
			System.out.println(C);
		}	
	}
	else if(costDessert.size() == 0) {
		Double c = Collections.max(costDrink);
		itemType = "drink";
		if(itemType.equals("drink")){
			useCoupon = true;
			c = Collections.max(costDrink);	
			Coupon Co = new Coupon("drink", 0.10);
			System.out.println(Co);
			double g = c * 0.10;
			String a = String.format("\nCoupon:	-$%.2f%n", g);
			System.out.println(a);
			totalC = total - g;
			//total = totalC;
			String p = String.format("Total: $%.2f%n", totalC);
			System.out.println(p);
	   
	}
	else{//print error message invalid coupon
		useCoupon = false;
		Coupon C = new Coupon();
		System.out.println(C);
	}	

	}
	}
	/**
	 * methods ends current sale and prints out receipt
	 * @return - a string receipt
	 * **/
	public String endSale() {
		totalSales++;
		if(desserts.size() > 0 && drinks.size() >0) {
		a = String.format("Sale #%s \nDrinks: \n%s \nDesserts: \n%s. \nThe total for your purchase was $%.2f%n", totalSales, drinks, desserts, tax());
		}
		else if(desserts.size() == 0) {
			a = String.format("Sale #%s Drinks: \n%s  \nThe total for your purchase was $%.2f%n", totalSales, drinks, tax());
		}
		else if(drinks.size()==0) {
			a = String.format("Sale #%s Desserts: \n%s. \nThe total for your purchase was $%.2f%n", totalSales, desserts, tax());
		}
		allSales();
		return(a);
		
		
	}
	
	/**
	 * method prints out receipts of all sales
	 * @return r - arraylist of strings of the receipts of all the sales
	 * **/
	public ArrayList<String> allSales() {
			String e = String.format("Sale #%s: \n%s Desserts	$%.2f%n \n%s Drinks	 $%.2f%n \nTotal:	$%.2f%n", totalSales , dessertTotal, subDessert, drinkTotal , subDrink , total-totalC);
			r.add(e);
		
		return r;
	}
	/**
	 * method resets some of the instance variable so were not adding on top of each other
	 * **/
	public void reset() {
		drinks.removeAll(drinks);
		desserts.removeAll(desserts);
		subDrink = 0.00;
		subDessert = 0.00;
		useCoupon = false;
		dessertTotal = 0;
		drinkTotal = 0;
		totalC = 0.00;
		//costDessert.removeAll(r);
	}

	
/**
 * method overrides a string
 * @return a string
 * **/
	public String toString() {
		return(a);
	}
	
	
}
