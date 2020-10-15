package project4;

/**
 * @author Audrey Brio
 * @release date April 21 2018
 * This class is a subclass of bill that creates a five dollar bill from the clone
 * **/

public class FiveDollarBill extends Bill {
	/**
	 * sets value and face of a five dollar bill
	 * **/
	public FiveDollarBill() {
		super.setValue(5);
		super.setFace("Abraham Lincoln");
	}
	/**
	 * overrides CloneBill method
	 * @return - returns the clone of a bill as a five dollar bill
	 * **/
	@Override
	FiveDollarBill CloneBill() {
		// TODO Auto-generated method stub
		return (FiveDollarBill) super.Clone();
	}
	/**
	 * overrides toString
	 * @return - returns a String for a five dollar bill
	 * **/
	@Override 
	public String toString() {
		return("Five dollar bill: $" + value +", " + face);
		}
}
