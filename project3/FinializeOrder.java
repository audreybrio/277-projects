package project3;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import project3.PastryFrame.saveCookieListener;
/**
 * @author Audrey Brio
 * @release March 19,2019
 * this class lets creates frame to order a pick something to order
 * **/
public class FinializeOrder extends NewOrderFrame{
	
	private JTextArea finalReceipt;
	private JLabel amtDue;
	private JLabel stillOwe;
	private JLabel payment;
	private JTextField payHere;
	private JButton pay;
	private JButton payAgain;
	private JButton exit;
	private double a = 0.00;
	private double prevPay = 0.00;
	private JPanel panel;
		//instance variables
	JFrame finalOrder = new JFrame();
	/**
	 * default constructor that creates new frame
	 * **/
	public FinializeOrder() {
		createComponents(); //creating the components and adding 
		//them to this frame
		this.setTitle("Finalize Order");
		this.setSize(700, 700);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	/**
	 * creates the components of the frame
	 * creates and adds buttons, labels, text area, and text field to panel to add to frame
	 * **/
	public void createComponents() {
	
		amtDue = new JLabel("Amount Due: $ ");
		final int ROW = 35;
		final int COLUMN = 60;
		finalReceipt = new JTextArea(ROW, COLUMN);
		finalReceipt.setEditable(false);
		payment = new JLabel("Payment: $");
		final int WIDTH = 10;
		payHere = new JTextField(WIDTH);
		pay = new JButton("Pay");
		payAgain = new JButton("Pay");
		exit = new JButton("Exit"); //creates components
		
		ActionListener payButton = new payListener(); //reaction to when pay button is clicked
		pay.addActionListener(payButton);
		ActionListener payAgainButton = new payAgainListener(); //reaction to when pay again button is clicked
		payAgain.addActionListener(payAgainButton);
		ActionListener exitButton = new exitListener(); //reaction to when exit button is clicked
		exit.addActionListener(exitButton);
		
		
		panel = new JPanel();
		panel.add(amtDue);
		panel.add(finalReceipt);
		JScrollPane scrollPane = new JScrollPane(finalReceipt);
		panel.add(scrollPane);
		panel.add(payment);
		panel.add(payHere);
		panel.add(pay);
		panel.add(payAgain);
		payAgain.setVisible(false);
		panel.add(exit);
		exit.setVisible(false);
		this.add(panel); //adds components to panel
		
	}
	
	/**
	 * gets the cost of the order
	 * @param b - gets final cost from new order frame and saves as a double
	 * @return a - returns the final cost as a double
	 * **/
	public double getCost(double b) {	
		a = b;
		String c = String.format("Amount Due: $%.2f%n", a);
		amtDue.setText(c);
		return a;
	}
	/**
	 * adds text receipt
	 * @param a - takes in a string and adds it to text area
	 * **/
	public void addReceipt(String a) {
		finalReceipt.append(a);
	}
	/**
	 * what happens when pay button is clicked (reaction)
	 * **/
	class payListener implements ActionListener{
		/**
		 * when the click specifically is performed 
		 * resultant of user clicking pay
		 * @param click - when a click action is performed
		 * **/
		public void actionPerformed(ActionEvent click) {
			String g = (String) payHere.getText() ;
			double h = Double.parseDouble(g);
			if(a> h) { //if user gives not enough money 
				double z = a - h;
				prevPay = h;
				String j = String.format("Insufficient funds! You still owe:  $%.2f%n", z);
				amtDue.setText(j);
				panel.remove(pay);
				payAgain.setVisible(true);
				panel.repaint();
			}
			if(a<=h) { //if user gives enough money 
				amtDue.setText("Thank You!");
				double c = h-a;
				String f = String.format("\nPayment: $%.2f%n \nChange: $%.2f%n", h,c);
				finalReceipt.append(f);
				finalReceipt.append("                       ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ THANK YOU ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				panel.remove(pay);
				panel.remove(payment);
				panel.remove(payHere);
				exit.setVisible(true);
				panel.repaint();
		
			}
		}
	}
	/**
	 * what happens when payagain button is clicked (reaction)
	 * **/
	class payAgainListener implements ActionListener{
		/**
		 * when the click specifically is performed 
		 * resultant of user clicking pay
		 * @param click - when a click action is performed
		 * **/
		public void actionPerformed(ActionEvent click) {
	
			String g = (String) payHere.getText() ;
			double h = Double.parseDouble(g);
			double total = h + prevPay;
			if(a<total) {
				amtDue.setText("Thank You!");
				double c = total-a;
				String f = String.format("\nPayment: $%.2f%n \nChange: $%.2f%n", total,c);
				finalReceipt.append(f);
				finalReceipt.append("                       ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ THANK YOU ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				panel.remove(payAgain);
				panel.remove(payment);
				panel.remove(payHere);
				exit.setVisible(true);
				panel.repaint();
			}
			if(a>total) {
				double z = a - total;
				prevPay = total;
				String j = String.format("Insufficient funds! You still owe:  $%.2f%n", z);
				amtDue.setText(j);
				panel.remove(payAgain);
				panel.add(payAgain);
				panel.repaint();
			}
		}
	}
	/**
	 * what happens when close button is clicked (reaction)
	 * **/
	class exitListener implements ActionListener{
		/**
		 * when the click specifically is performed 
		 * resultant of user clicking done
		 * @param click - when a click action is performed
		 * **/
		public void actionPerformed(ActionEvent click) {
			Component n = (Component) click.getSource(); 
			JFrame m = (JFrame) SwingUtilities.getRoot(n);
			m.setVisible(false); //closes frame
			m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			
			}
		}
	}

