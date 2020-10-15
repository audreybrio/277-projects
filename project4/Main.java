package project4;
/**
 * @author Audrey Brio
 * @release date April 22 2018
 * This class is the main
 * **/
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			OneDollarBill OneDollar = new OneDollarBill();
			OneDollar = OneDollar.CloneBill();
			System.out.println(OneDollar);
			
			FiveDollarBill FiveDollar = new FiveDollarBill();
			FiveDollar = FiveDollar.CloneBill();
			System.out.println(FiveDollar);
			
			TenDollarBill TenDollar = new TenDollarBill();
			TenDollar = TenDollar.CloneBill();
			System.out.println(TenDollar);
	}

}
