package project3products;
/**
 * @author Audrey Brio
 * @release March 19,2019
 * this class lets user order a drink item
 * **/

public abstract class DrinkItem extends Item {

	protected String size;
	protected String flavor;
	protected String sweetness;
	protected String milk; //instance variables
	
	/**
	 * default constructor that puts in a basic drink order
	 * **/
	public DrinkItem() {
		size = "small";
		flavor = "Regular";
		sweetness = "None";
		milk = "half-and-half";
	}
	/**
	 * default constructor that lets user put in own inputs for coffee item
	 * @param sz - string that takes in the size of the drink
	 * @param flav - string that takes in the flavor of the drink
	 * @param sweet - string that takes in sweetness of drink 
	 * * @param mlk - string that takes in milk flavor of drink 
	 * @param nm - name of the drink as a string
	 * **/
	public DrinkItem(String sz, String flav, String sweet, String mlk, String nm) {
		size = sz;
		flavor = flav;
		sweetness= sweet;
		milk = mlk;
		name = nm;
		
	}
	/**
	 * setter that sets the flavor of a drink
	 * @param flav - takes in a flavor as a String to set 
	 * **/
	public void setFlavor(String flav) {
		flav = flavor;
	}
	/**
	 * setter that sets the milk base of a drink
	 * @param mlk - takes in a milk base as a String to set 
	 * **/
	public void setMilk(String mlk) {
		mlk = milk;
	}
	/**
	 * setter that sets the size of a drink
	 * @param sz - takes in a size as a String to set 
	 * **/
	public void setSize(String sz) {
		sz = size;
	}
	/**
	 * setter that sets the sweetness of a drink
	 * @param sweet - takes in sweetness as a string to set
	 * **/
	public void setSweetness(String sweet) {
		sweet = sweetness;
	}
	/**
	 * getter that gets the flavor of a drink
	 * **/
	public String getFlavor() {
		return flavor;
	}
	/**
	 * getter that gets the milk base of a drink
	 * **/
	public String getMilk() {
		return milk;
	}
	/**
	 * getter that gets the size of a drink
	 * **/
	public String getSize() {
		return size;
	}
	/**
	 * getter that gets the sweetness of a drink
	 * **/
	public String getSweetness() {
		return sweetness;
	}
	
	/**
	 * method overrides toString
	 * @return - the default constructors as a string
	 * **/
	public String toString() {
		return("You ordered a: " + size + " " + flavor + " " + name + " with " + sweetness + " sweetness and " + milk + " milk.");
	}

	
	
	
	
}
