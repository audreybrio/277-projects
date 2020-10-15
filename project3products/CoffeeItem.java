package project3products;
/**
 * @author Audrey Brio
 * @release March 19,2019
 * this class lets user order a coffee drink
 * **/

public class CoffeeItem extends DrinkItem{
	
	protected String temperature;
	protected String specialInstructions; //instance variables
	
	/**
	 * default constructor that puts in a basic coffee order
	 * **/
	public CoffeeItem() {
		size = "small";
		flavor = "Mocha";
		milk = "whole";
		sweetness = "8";
		temperature = "hot";
		specialInstructions = "none";
	}
	/**
	 * default constructor that lets user put in own inputs for coffee item
	 * @param sz - string that takes in the size of the drink
	 * @param flav - string that takes in the flavor of the drink
	 * @param mlk - string that takes in milk flavor of drink 
	 * @param sweet - string that takes in sweetness of drink
	 * @param temp - string that takes in the temperature of the drink
	 * @param si - string that takes in any special instructions of drink
	 * **/
	public CoffeeItem(String sz, String flav, String mlk, String sweet, String temp, String si) {
		size = sz;
		flavor = flav;
		milk = mlk;
		sweetness = sweet;
		temperature = temp;
		specialInstructions = si;
		
	}
	
	/**
	 * method overrides getCost method in superclass
	 * it gets the cost of a coffee drink based on size, milk type, and temperature
	 * @return cost - total cost of the drink as a double
	 * **/
	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		if(temperature.equals("Hot") || temperature.equals("Iced")) {
			if(size.equals("S")) {
				cost = 1.00;
			}
			else if(size.equals("M")) {
				cost = 1.50;
			}
			else if(size.equals("L")) {
				cost = 2.00;
			}
			if(milk.equals("whole milk") || milk.equals("half-and-half")) {
			cost = cost + 0.25;
			}
		}
		else if(temperature.equals("Blended")) {
			if(size.equals("S")) {
				cost = 1.25;
			}
			else if(size.equals("M")) {
				cost = 1.70;
			}
			else if(size.equals("L")) {
				cost = 2.25;
			}
			if(milk.equals("whole milk") || milk.equals("almond milk")) {
			cost = cost + 0.25;
			}
		}
		return cost;
	}
	
	/**
	 * method overrides toString
	 * @return a - the default constructors as a string
	 * **/
	public String toString() {
		String a = String.format("\n\n- %s Coffee (%s)		$%.2f%n \n	Num of Teaspoons: %s \n 	Milk: %s \n 	Temp: %s \n 	Special Instructions: %s", flavor, size, getCost(), sweetness, milk, temperature, specialInstructions);
		return(a);
	}


}

