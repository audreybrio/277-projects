package project3products;

public class ItemDemo {


	public static void main(String[] args) {
		//Item n = new Item();
		CoffeeItem d = new CoffeeItem("M","black","whole milk", "5 teaspoons", "Hot", "2 shots of vodka");
		TeaItem d2 = new TeaItem("L", "green tea", "half-and-half","full");
		PastryItem d3 = new PastryItem("cookie", "chocolate chip", true);
		PastryItem d4 = new PastryItem("cheesecake", "blueberry", false);
		d2.addTopping("boba");
		d2.addTopping("lychee balls");
		System.out.println(d);
		System.out.println(d2);
		System.out.println(d3);
		System.out.println(d4);
	}


}
