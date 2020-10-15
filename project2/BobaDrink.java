package project2;

/**
 * @author Audrey Brio

 * Release Date - 2/21/2019
 * This class is a subclass of the DrinkItem class and it gets a order for a boba drink
 *  **/

import java.util.ArrayList;
import java.util.Scanner;

public class BobaDrink extends DrinkItem {
	
	private int numofToppings;	//instance variables
	private String sizeBoba;
	private String baseTea;
	private String Sweetness;
	private String toppings;
	private String milk;
	private ArrayList<String> tops = new ArrayList<String>();
	private double cost = 0.00;

	/**
	 * method to for user to enter what size drink they want
	 * compares the user input to predetermined answers
	 * @return sizeBoba - the users selection as a string
	 * **/
	
	public String SizeDrink() {
		//String size;
		System.out.println("Please choose a size:" + "\n1. Small" + "\n2. Medium" + "\n3. Large");
		Scanner input = new Scanner(System.in);
		System.out.println("Please make a selection: ");
		sizeBoba = input.nextLine();
		
		if(sizeBoba.equals("1")  || sizeBoba.equals("Small") || sizeBoba.equals("small")) {
			sizeBoba = "small";
		}
		else if(sizeBoba.equals("2")  || sizeBoba.equals("Medium") || sizeBoba.equals("medium")) {
			sizeBoba = "medium";
		}
		else if(sizeBoba.equals("3")  || sizeBoba.equals("Large") || sizeBoba.equals("large")) {
			sizeBoba = "large";
		}
		else {
			System.out.print("You chose something not on the menu. Please choose a base tea from the list.\n");
			SizeDrink();
		}
		super.setSize(sizeBoba);
		return sizeBoba;
		
	}
	
	/**
	 * method that allows user to enter a base tea for their boba drink and compares it to predetermined answers
	 * @return baseTea - the user's selection as a string
	 **/
	public String baseTea() {
		System.out.println("Please choose a flavor for the base tea:" + "\n1. Green Tea" + "\n2. Black Tea" + "\n3. Jasmine Green Tea" + "\n4. Rose Tea" + "\n5. Oolong Tea");
		Scanner input = new Scanner(System.in);
		System.out.println("Please make a selection: ");
		baseTea = input.nextLine();
		
		if(baseTea.equals("1")  || baseTea.equals("Green Tea") || baseTea.equals("green tea")) {
			baseTea = "green tea";
		}
		else if(baseTea.equals("2")  || baseTea.equals("Black Tea") || baseTea.equals("black tea")) {
			baseTea = "black tea";
		}
		else if(baseTea.equals("3")  || baseTea.equals("Jasmine Green Tea") || baseTea.equals("jasmine green tea")) {
			baseTea = "jasmine green tea";
		}
		else if(baseTea.equals("4")  || baseTea.equals("Rose Tea") || baseTea.equals("rose tea")) {
			baseTea = "rose tea";
		}
		else if(baseTea.equals("5")  || baseTea.equals("Oolong Tea") || baseTea.equals("oolong tea")) {
			baseTea = "oolong tea";
		}
		else {
			System.out.print("You chose something not on the menu. Please choose a base tea from the list.\n");
			baseTea();
		}
		super.setName(baseTea);
		return(baseTea);
	}
	/**
	 * method that allows user to enter how sweet the want their boba to be from some predetermined choices
	 * @return Sweetness - the user's selection as a string
	 **/
	
	public String levelofSweetness() {
	System.out.println("Please choose how sweet you want your drink:" + "\n1. Full Sweet" + "\n2. 3/4 Sweet" + "\n3. 1/2 Sweet" + "\n4. 1/4 Sweet" + "\n5. Unsweetened ");
	Scanner input = new Scanner(System.in);
	System.out.println("Your selection: ");
	Sweetness = input.nextLine();
	
	if(Sweetness.equals("1")  || Sweetness.equals("Full Sweet") || Sweetness.equals("full sweet")) {
		Sweetness = "full sweet";
	}
	else if(Sweetness.equals("2")  || Sweetness.equals("3/4 Sweet") || Sweetness.equals("3/4 sweet")) {
		Sweetness = "3/4 sweet";
	}
	else if(Sweetness.equals("3")  || Sweetness.equals("1/2 Sweet") || Sweetness.equals("1/2 sweet")) {
		Sweetness = "1/2 sweet";
	}
	else if(Sweetness.equals("4")  || Sweetness.equals("1/4 Sweet") || Sweetness.equals("1/4 sweet")) {
		Sweetness = "1/4 sweet";
	}
	else if(Sweetness.equals("5")  || Sweetness.equals("Unsweetened") || Sweetness.equals("unsweetened")) {
		System.out.println("You chose for your drink to be unsweetened");
	}
	else {
		System.out.print("You chose something not on the menu. Please choose an amount of sweetness from the list.\n");
		levelofSweetness();
	}
	super.setSweetness(Sweetness);
	return(Sweetness);
}
	
	/**
	 * method that allows user to choose which toppings they wish to add to their drink from a predetermined list
	 * @return toppings - the toppings the user wishes to add to the top of their drink as a string
	 **/
	
	public String addToppings() {

	System.out.println("Please choose the topping you want to add:" + "\n1. Boba" + "\n2. Popping Boba" + "\n3. Grass Jelly" + "\n4. Lychee Jelly" + "\n5. Coconut Jelly" + "\n6. Mini Mochi");
	Scanner input = new Scanner(System.in);
	System.out.println("Your selection: ");
	toppings = input.nextLine();
	
		if(toppings.equals("1")  || toppings.equals("Boba") || toppings.equals("boba")) {
			toppings = "boba";
		}
		else if(toppings.equals("2")  || toppings.equals("Popping Boba") || toppings.equals("popping boba")) {
			toppings = "popping boba";
		}
		else if(toppings.equals("3")  || toppings.equals("Grass Jelly") || toppings.equals("grass jelly")) {
			toppings = "grass jelly";
		}
		else if(toppings.equals("4")  || toppings.equals("Lychee Jelly") || toppings.equals("lychee jelly")) {
			toppings = "lychee jelly";
		}
		else if(toppings.equals("5")  || toppings.equals("Coconut Jelly") || toppings.equals("coconut jelly")) {
			toppings = "coconut jelly";
		}
		else if(toppings.equals("6")  || toppings.equals("Mini Mochi") || toppings.equals("mini mochi")) {
			toppings = "mini mochi";
		}
		else {
			System.out.print("You chose something not on the menu. Please choose a topping from the list.\n");
			addToppings();
		}
	
	return(toppings);
}
	
	/**
	 * method that allows user how many toppings they wish to add onto their drink
	 * @return tops - the total number of toppings the user wants as an int
	 * **/
	
	public ArrayList totalToppings() {
		System.out.println("Please enter how many toppings you would like: ");
		Scanner input = new Scanner(System.in);
		numofToppings = input.nextInt();
		
		for(int i = 0; i < numofToppings; i++) {
			String a = addToppings();
			tops.add(a);
		}
		return tops;
	}
	
	/**
	 * method that allows user to enter which milk they want in their drink (if any) from a predetermined list
	 * @return milk - the milk the user wishes to add to their drink as a string
	 **/
	public String addMilk() {
	System.out.println("Please choose the type of milk you want to add:" + "\n1. Whole Milk" + "\n2. Half-and-Half" + "\n3. Almond Milk" + "\n4. Coconut Milk" + "\n5. No Milk");
	Scanner input = new Scanner(System.in);
	System.out.println("Your selection: ");
	milk = input.nextLine();
	
	if(milk.equals("1")  || milk.equals("Whole Milk") || milk.equals("whole milk")) {
		milk = "whole milk";
	}
	else if(milk.equals("2")  || milk.equals("Half-and-Half") || milk.equals("half-and-half")) {
		milk = "half-and-half";
	}
	else if(milk.equals("3")  || milk.equals("Almond Milk") || milk.equals("almond milk")) {
		milk = "almond milk";
	}
	else if(milk.equals("4")  || milk.equals("Coconut Milk") || milk.equals("coconut milk")) {
		milk = "coconut milk";
	}
	else if(milk.equals("5")  || milk.equals("No Milk") || milk.equals("no milk")) {
		milk = "no milk";
	}
	else {
		System.out.print("You chose something not on the menu. Please choose a milk from the list.\n");
		addMilk();
	}
	return(milk);
}

/**
 * method overrides method in super class, determines cost based on requirements and options for boba drink
 * @return cost - the cost of the drink as a double varying becuase of size and number of toppings
 * **/	
	@Override
	public double getCost() {
		if(sizeBoba.equals("small")|sizeBoba.equals("Small")||sizeBoba.equals("1")) {
			cost = 1.50;
		}
		else if(sizeBoba.equals("medium")||sizeBoba.equals("Medium")||sizeBoba.equals("2")) {
			cost = 2.00;
		}
		else if(sizeBoba.equals("large")||sizeBoba.equals("Large")||sizeBoba.equals("3")) {
			cost = 2.50;
		}
		cost = cost + (numofToppings * 0.50);
		super.costDrink.add(cost);
		return cost;
	}
	
	/**
	 * method overrides a method in super class to compare which cost is greater
	 * @param other - takes in another drink item to compare cost to 
	 * @return 1 if statement is true, 0 if it was false
	 * **/
	
	@Override
	public int compareTo(DrinkItem other) {
		if(getCost() > other.getCost()) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
	/**
	 * string representation of what the user ordered in terms of a boba drink
	 * @return a string
	 **/
	@Override
	public String toString() {
		String a = String.format("boba drink (%s) \n    -%s \n    -%s \n    -%s \n    -%s \n    -Subtotal:		$%.2f%n", sizeBoba, baseTea, milk, tops, Sweetness, cost);
		return a;
	}

}