package project3products;
/**
 * @author Audrey Brio
 * @release March 19,2019
 * this class lets user order a tea drink
 * **/

import java.util.ArrayList;

public class TeaItem extends DrinkItem{
	
	private ArrayList<String> toppings = new ArrayList<String>(); //instance variables
	
	/**
	 * default constructor that puts in a basic tea order
	 * **/
	public TeaItem() {
		size = "small";
		flavor = "Green Tea";
		milk = "whole";
		sweetness = "full";
	}
	/**
	 * default constructor that lets user put in own inputs for tea item
	 * @param sz - string that takes in the size of the drink
	 * @param flav - string that takes in the flavor of the drink
	 * @param mlk - string that takes in milk flavor of drink 
	 * @param sweet - string that takes in sweetness of drink
	 * **/
	public TeaItem(String sz, String flav, String mlk, String sweet) {
		size = sz;
		flavor = flav;
		milk = mlk;
		sweetness = sweet;
	}
	/**
	 * method that allows user to add toppings
	 * @param tops - the toppings the user wishes to add as a string
	 * **/
	public void addTopping(String tops) {
		toppings.add(tops);
	}

	/**
	 * method overrides getCost method in superclass
	 * it gets the cost of a tea drink based on size, milk type, and number of toppings
	 * @return cost - total cost of the drink as a double
	 * **/
	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		cost = getBasePrice(size);
		if(milk.equals("whole milk") || milk.equals("half-and-half")) {
			cost = cost + 0.25;
		}
		cost = cost + (0.25 * toppings.size());
		return cost;
	}	
	/**
	 * gets the base price of a drink based on size 
	 * @return c - cost of size of drink as a double
	 * **/
	public static double getBasePrice(String s) {
		double c = 0.00;
		if(s.equals("S")) {
			c = 2.50;
		}
		else if(s.equals("M")) {
			c = 3.00;
		}
		else if(s.equals("L")) {
			c = 3.50;
		}
		return c;
	}
	/**
	 * method overrides toString
	 * @return a - the default constructors as a string
	 * **/
	public String toString() {
		String a;
		if(toppings.size()>0) {
			a = String.format("\n\n- %s (%s) 			$%.2f%n \n 	Sweetness: %s \n 	Milk: %s \n 	Toppings: %s", flavor, size, getCost(), sweetness, milk, toppings);
		}
		else {
			a = String.format("\n\n- %s (%s) 			$%.2f%n \n 	Sweetness: %s \n 	Milk: %s", flavor, size, getCost(), sweetness, milk);
		}
			return(a);
	
	}
}
