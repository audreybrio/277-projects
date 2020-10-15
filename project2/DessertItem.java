package project2;
/**
 * @author Audrey Brio
 * Release Date: February 21, 2019
 * Description: this class is a superclass, and creates new Dessert Items
 * **/

import java.util.ArrayList;
import java.util.Collections;

public abstract class DessertItem implements Comparable<DessertItem>{
	
	private String dessertName; //instance variables
	protected static ArrayList<Double> costDessert = new ArrayList<Double>();
	
	/**
	 * default constructor
	 * **/
	
	public DessertItem() {
		dessertName = "brownie";

	}
	/**
	 * method takes in a string and sets it to instance variable
	 * @param dn - is a string that is a dessert name
	 * **/
	
	public DessertItem(String dn) {
		dessertName = dn;
	}
	
	/**
	 * method returns the dessert name of a dessert item
	 * @return dessertName string name of a dessert
	 * **/
	public String getName() {
		return dessertName;
	}

	/**
	 * method sets a new name as dessert name
	 * @param dn - string name of a dessert
	 * @return the new dessert name dn as the instance variable
	 * **/
	public String setName(String dn) {
		return dessertName = dn;
	}

	/**
	 * abstract that gets overridden by the subclasses
	 * @return cost - the amount of cost for the item
	 * **/
	public abstract double getCost();
	
	
	/**
	 * method to compare objects to one another 
	 *@param other - takes in another dessert item to compare to
	 *@return 1 if statement is true, 0 if it is false
	 * **/
	public int compareTo(DessertItem other) {
			if(getCost() > other.getCost()) {
				return 1;
		}
			else {
				return 0;
		}
	}
	
	/**
	 *method to find the max of a group of total costs
	 *@param costDessert - an ArrayList made of doubles that are the costs of different dessert items
	 *@return m - the max number from the list
	 **/
	public static Comparable dessertMax(ArrayList costDessert) {
		Comparable m = Collections.max(costDessert);
		return m;
			
	}
	
	/**
	 * string representation of info to display
	 * @return a string 
	 * **/
	public String toString() {
		return("You odered a: " + dessertName + " max = " + dessertMax(costDessert));
	}
}
