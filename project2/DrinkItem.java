package project2;
/**
 * @author Audrey Brio
 * Release Date: February 21, 2019
 * Description: this class is a superclass, and creates new Drink Items
 * **/

import java.util.ArrayList;
import java.util.Collections;

public abstract class DrinkItem implements Comparable<DrinkItem>{
	private String size; //instance variables
	private String sweetness;
	private String name;
	protected static ArrayList<Double> costDrink = new ArrayList<Double>();

	/**
	 * default constructor
	 * **/
	public DrinkItem() {
		name = "Green Tea";
		size = "small";
		sweetness = "1/2 sweet";
	}

	/**
	 * constructor that lets you create a new drink item
	 * @param nm - takes in a string name of drink
	 * @param sz - takes in a string for the size of the drink
	 * @param sweet - takes in a string for the sweetness of the drink
	  **/
	public DrinkItem(String nm,String sz, String sweet) {
		name = nm;
		size = sz;
		sweetness = sweet;
	}
	 /** method returns the name of a drink item
	 * @return name - string name of a drink
	 **/
	public String getName() {
		return name;
	}
	 /** method returns the size of a drink item
	 * @return size - string size of a drink
	 **/
	
	public String getSize() {
		return size;
	}
	 	/** method returns the sweetness of a drink item
		 * @return sweetness - string sweetness of a drink
		 * **/
	public String getSweetness() {
		return sweetness;
	}
	 	/** method allows you to set the name of the drink
	 	 * @param nm - new name of the drink
		 * @return name - string name of a drink
		 * **/
	public String setName(String nm) {
		return name = nm;
	}
	/** method allows you to set the size of the drink
 	 * @param sz - new size of the drink
	 * @return size - string size of a drink
	 * **/
	public String setSize(String sz) {
		return size = sz;
	}
	/** method allows you to set the sweetness of the drink
 	 * @param sweet - new sweetness of the drink
	 * @return sweetness - string sweetness of a drink
	 * **/
	public String setSweetness(String sweet) {
		return sweetness = sweet;
	}
	/**
	 * abstract that gets overridden by the subclasses
	 * @return cost - gets cost for the item
	 * **/
	public abstract double getCost();
	
	
	/**
	 * method to compare objects to one another 
	 *@param other - takes in another drink item to compare to
	 *@return 1 if statement is true, 0 if it is false
	 * **/
	public int compareTo(DrinkItem other) {
		if(getCost() > other.getCost()) {
			return 1;
	}
		else {
			return 0;
	}
}

	/**
	 *method to find the max of a group of total costs
	 *@param costDrink - an arraylist made of doubles that are the costs of different drink items
	 *@return n - the max number from the list
	 * **/
public static Comparable drinkMax(ArrayList costDrink) {
	Comparable n = Collections.max(costDrink);
	return n;
		
}
/**
 * string representation of info to display
 * @return string 
 * **/
	public String toString() {
		return("You odered a: " + size + sweetness + name );
	}
}




