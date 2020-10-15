package project3products;
/**
 * @author Audrey Brio
 * @release March 19,2019
 * this class lets user order a item
 * **/

	
public abstract class Item {
		protected String name;
		protected double cost = 0.00; //instance variables
		
		/**
		 * default constructor that sets name and cost
		 * **/
		public Item() {
			name = "Coffee";
			cost = 2.00;
		}
		/**
		 * default constructor that lets user enter name and cost
		 * @param nm - the name of the item as a string
		 * @param amt - the cost of the item as a double
		 * **/
		public Item(String nm, double amt) {
			name = nm;
			cost = amt;
		}
		/**
		 * setter that sets the name of an item
		 * @param nm - takes in name as a string to set
		 * **/
		public void setName(String nm) {
			nm = name;
		}
		/**
		 * setter that sets the cost of an item
		 * @param amt - takes in cost as a double to set
		 * **/
		public void setCost(double amt) {
			amt = cost;
		}
		/**
		 * getter that gets the name of a item
		 * @return name - the name as a string
		 * **/
		public String getName() {
			return name;
		}
		/**
		 * method that gets overriden since each item has different cost
		 * **/
		public abstract double getCost();
	}

