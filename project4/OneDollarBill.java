package project4;
/**
 * @author Audrey Brio
 * @release date April 21 2018
 * This class is a subclass of bill that creates a one dollar bill from the clone
 * **/

public class OneDollarBill extends Bill {
	/**
	 * sets value and face of a one dollar bill
	 * **/
	public OneDollarBill() {
		super.setValue(1);
		super.setFace("George Washington");
	}
	/**
	 * overrides CloneBill method
	 * @return - returns the clone of a bill as a one dollar bill
	 * **/
	@Override
	OneDollarBill CloneBill() {
		// TODO Auto-generated method stub
		return (OneDollarBill) super.Clone();
	}
	/**
	 * overrides toString
	 * @return - returns a String for a one dollar bill
	 * **/
	@Override 
	public String toString() {
		return("One dollar bill: $" + value +", " + face);
		}
}
