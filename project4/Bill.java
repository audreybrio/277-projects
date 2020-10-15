package project4;
/**
 * @author Audrey Brio
 * @release date April 21 2018
 * This class is an abstract class of a bill that has copies of it made
 * **/
public abstract class Bill implements Cloneable{
	
	protected int value;
	protected String face; //instance variable
	/**
	 * abstract method that gets overridden to clone bill
	 * **/
	abstract Bill CloneBill();
	
	/**
	 * @return value - the value of the bill as an int
	 * gets value of the bill
	 * **/
	public int getValue() {
		return value;
	}
	
	/**
	 * @param v - the value of the bill as an int
	 * sets value of the bill
	 * **/
	public void setValue(int v) {
		value = v;
	}
	
	/**
	 * @return face - the name of the face on the bill as a string
	 * gets the face of the bill
	 * **/
	public String getFace() {
		return face;
	} 
	
	/**
	 * @param f - the name of the face on the bill as a string
	 * sets the face of the bill
	 * **/
	public void setFace(String f) {
		face = f;
	}
	
	/**
	 * @return clone - returns the clone as an  object
	 * clones the object
	 * **/
	public Object Clone() {
	   Object clone = null;		      
		  try {
	        clone = super.clone();
	        } 
		  catch (CloneNotSupportedException e) {
			e.printStackTrace();
		  }   
		  return clone;
		   }
	
	/**
	 * @return returns a String
	 * **/
	public String toString() {
		return("bill");
	}
}
