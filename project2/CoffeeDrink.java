package project2;
/**
 * @author Audrey Brio

 * Release Date: Febraury 21, 2019
 * Description: this class lets a user order a coffee drink
 * **/
import java.util.Scanner;

public class CoffeeDrink extends DrinkItem {
	//instance variables 
	private String sizeCoffee;
	private String baseCoffee;
	private int sweetnessCoffee;
	private double costCoffee = 0.00;
	
	/**
	 * method to for user to enter what size drink they want
	 * compares the user input to predetermined answers
	 * @return sizeCoffee - the users selection as a string
	 * **/
	public String SizeCoffeeDrink() {
		System.out.println("Please choose a size:" + "\n1. Small" + "\n2. Medium" + "\n3. Large");
		Scanner input = new Scanner(System.in);
		System.out.println("Please make a selection: ");
		sizeCoffee = input.nextLine();
		
		if(sizeCoffee.equals("1")  || sizeCoffee.equals("Small") || sizeCoffee.equals("small")) {
			sizeCoffee = "small";
		}
		else if(sizeCoffee.equals("2")  || sizeCoffee.equals("Medium") || sizeCoffee.equals("medium")) {
			sizeCoffee = "medium";
		}
		else if(sizeCoffee.equals("3")  || sizeCoffee.equals("Large") || sizeCoffee.equals("large")) {
			sizeCoffee = "large";
		}
		else {
			System.out.print("You chose something not on the menu. Please choose a size from the list.\n");
			SizeCoffeeDrink();
		}
		super.setSize(sizeCoffee);
		return sizeCoffee;
		
	}
	/**
	 * method that allows user to enter with what base they want their coffee from predetermined choices
	 * @return baseCoffee - the user's selection as a string
	 **/
	public String baseCoffee() {
		System.out.println("Please choose a flavor for the base tea:" + "\n1. Water" + "\n2. Whole Milk" + "\n3. Almond Milk");
		Scanner input = new Scanner(System.in);
		System.out.println("Please make a selection: ");
		baseCoffee = input.nextLine();
		
		if(baseCoffee.equals("1")  || baseCoffee.equals("Water") || baseCoffee.equals("water")) {
			baseCoffee = "water";
		}
		else if(baseCoffee.equals("2")  || baseCoffee.equals("Whole Milk") || baseCoffee.equals("whole milk")) {
			baseCoffee = "whole milk";
		}
		else if(baseCoffee.equals("3")  || baseCoffee.equals("Almond Milk") || baseCoffee.equals("almond milk")) {
			baseCoffee = "almond milk";
		}
		else {
			System.out.print("You chose something not on the menu. Please choose a coffee base from the list.\n");
			baseCoffee();
		}
		super.setName(baseCoffee);
		return(baseCoffee);
	}
	
	/**
	 * method that allows user to choose how many teaspoons of sugar they want in their drink
	 * @return sweetness coffee - the num of teaspoons the user wishes to add to their drink as a string
	 **/
	
	public int amountofSugar() {
	System.out.println("Please enter how many teaspoons of sugar you would like: ");
	Scanner input = new Scanner(System.in);
	System.out.println("Your selection: ");
	sweetnessCoffee = input.nextInt();
	return(sweetnessCoffee);
}

	/**
	 * method overrides method in super class, determines cost based on requirements and options for coffee drink
	 * @return costCoffee - the cost of the drink as a double varying because of size
	 * **/
	@Override
	public double getCost() {
		if(sizeCoffee.equals("small")) {
			costCoffee = 1.40;
		}
		else if(sizeCoffee.equals("medium")) {
			costCoffee = 1.70;
		}
		else if(sizeCoffee.equals("large")) {
			costCoffee = 2.00;
		}
		super.costDrink.add(costCoffee);
		return costCoffee;
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
	 * string representation of what the user ordered in terms of a coffee drink
	 * @return a string
	 **/
	@Override
	public String toString() {
		String a = String.format("Coffee drink (%s) \n    -%s base \n    -%s teaspoons of sugar \n    -Subtotal:		$%.2f%n", sizeCoffee, baseCoffee, sweetnessCoffee, costCoffee);
		return(a);
		//return("You ordered: A " + sizeCoffee + " coffee with " + baseCoffee + " and " + sweetnessCoffee + " teaspoons of sugar. The total cost for your drink was: $" + costCoffee);
	}



}
