package project4;

/**
 * @author Audrey Brio
 * @release date April 21 2018
 * This class is a subclass of bill that creates a ten dollar bill from the clone
 * **/

public class TenDollarBill extends Bill {
	/**
	 * sets value and face of a ten dollar bill
	 * **/
	public TenDollarBill() {
		super.setValue(10);
		super.setFace("Alexander Hamilton");
	}
	/**
	 * overrides CloneBill method
	 * @return - returns the clone of a bill as a ten dollar bill
	 * **/
	@Override
	TenDollarBill CloneBill() {
		// TODO Auto-generated method stub
		return (TenDollarBill) super.Clone();
	}
	/**
	 * overrides toString
	 * @return - returns a String for a ten dollar bill
	 * **/
	@Override 
	public String toString() {
		return("Ten dollar bill: $" + value +", " + face);
		}
}
