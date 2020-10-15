package project3products;
/**
 * @author Audrey Brio
 * @release March 19,2019
 * this class lets user order a pastry item
 * **/

public class PastryItem extends Item{

	protected String flavor;
	protected boolean isHeated;
	public static final double IS_HEATED = 0.25; //instance variables
	
	

	/**
	 * default constructor that allows user to input type, flavor, and heating option of pastry
	 * @param nm - name of a pastry as a string
	 * @param flav - flavor of a pastry as a string
	 * @param heat - whether or not the pastry is heated up as a boolean
	 * **/
	public PastryItem(String nm, String flav, boolean heat) {
		name = nm;
		flavor = flav;
		isHeated = heat;
	}
	
	/**
	 * method overrides getCost method in superclass
	 * it gets the cost of a pastry drink based on type,flavor, and if it was heated up
	 * @return cost - total cost of the pastry as a double
	 * **/
	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		cost = getPrice(name, flavor);
		if(isHeated == true) {
			cost = cost + IS_HEATED;
		}
		return cost;
	}
	
	/**
	 * method gets price of type and flavor of a pastry
	 * @param nm - string that is that name of the pastry
	 * @param flav - string of the flavor of the pastry
	 * @return c - cost pastry based on flavor and cost
	 * **/
	public static double getPrice(String nm, String flav) {
		double c = 0.00;
		if(nm.equals("Muffin")) {
			c = 2.00;
		}
		else if(nm.equals("Cookie")) {
			c = 1.50;
		}
		else if(nm.equals("Cheesecake Slice")) {
			if(flav.equals("Regular")) {
				c = 4.00;
			}
			else if(flav.equals("Cherry")) {
				c = 4.50;   
			}
			else if(flav.equals("Blueberry")) {
				c = 4.50;
			}
		}
		else if(nm.equals("Danish")) {
			c = 2.50;
		}
		return c;
	}
	
	/**
	 * method overrides toString
	 * @return a - the default constructors as a string
	 * **/
	
	public String toString() {
		String a = null;
		if(isHeated == true) {
			a = String.format("\n\n-%s (heated) 		$%.2f%n\n	 %s", name, getCost(),flavor);
	}
		else if(isHeated == false) {
			a = String.format("\n\n-%s  		$%.2f%n\n 	%s", name, getCost(),flavor);
		}
		return a;
	}
}
