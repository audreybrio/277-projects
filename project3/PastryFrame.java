package project3;
/**
 * @author Audrey Brio
 * @release March 19,2019
 * this class lets creates frame to order a pick something to order
 * **/
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

//import project3.TeaFrame.SaveButtonListener;
import project3products.PastryItem;

public class PastryFrame extends FirstFrame{

	private JComboBox<String> pastries;
	private JComboBox<String> flavorCookies;
	private JComboBox<String> flavorMuffins;
	private JComboBox<String> flavorCheesecake;
	private JComboBox<String> flavorDanish;
	private JButton cancel;
	private JButton saveCookie;
	private JButton saveMuffin;
	private JButton saveCheesecake;
	private JButton saveDanish;
	private JCheckBox isHeatedCookie;
	private JCheckBox isHeatedMuffin;
	private JCheckBox isHeatedCheesecake;
	private JCheckBox isHeatedDanish;
	private JPanel panel;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panel4;
	private JPanel panel5;
	
	private double subTotal = 0.00; //instance variables
	
	/**
	 * default constructor that creates new frame
	 * **/
	public PastryFrame() {
		createComponents();
		this.setTitle("New Pastry Item");
		this.setSize(900,400);
		
	}
	/**
	 * creates the components of the frame
	 * creates and adds buttons, labels, combo boxes, and check box to panel to add to frame
	 * **/
	public void createComponents() {
		String[] type = {"Make a Selection", "Cookie", "Muffin", "Cheesecake Slice", "Danish"};
		pastries = new JComboBox<String>(type);
		cancel = new JButton("Cancel");
		String[] cookieFlavor = {"Oatmeal", "Chocolate Chip", "White Chocolate & Macadamias", "Double Fudge"};
		flavorCookies = new JComboBox<String>(cookieFlavor);
		String[] muffinFlavor = {"Banana Nut", "Chocolate Chip", "Blueberry", "Coffee Cake"};
		flavorMuffins = new JComboBox<String>(muffinFlavor);
		String[] cheesecakeFlavor = {"Regular", "Cherry", "Blueberry"};
		flavorCheesecake = new JComboBox<String>(cheesecakeFlavor);
		String[] danishFlavor = {"Apple Cinnamon", "Strawberry & Cheese", "Double Cheese"};
		flavorDanish = new JComboBox<String>(danishFlavor);
		saveCookie = new JButton("Save");
		saveMuffin = new JButton("Save");
		saveCheesecake = new JButton("Save");
		saveDanish = new JButton("Save");
		isHeatedCookie = new JCheckBox("heated?");
		isHeatedMuffin = new JCheckBox("heated?");
		isHeatedCheesecake = new JCheckBox("heated?");
		isHeatedDanish = new JCheckBox("heated?");
		panel = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel4 = new JPanel();
		panel5 = new JPanel();
		
		ActionListener saveCook = new saveCookieListener(); //if save from when cookie is selceted is clicked
		saveCookie.addActionListener(saveCook);
		ActionListener saveMuff = new saveMuffinListener(); //if save from when muffin is selected is clicked
		saveMuffin.addActionListener(saveMuff);
		ActionListener saveCheese = new saveCheesecakeListener(); //if save from when cheesecake is selected is clicked
		saveCheesecake.addActionListener(saveCheese);
		ActionListener saveDan = new saveDanishListener(); //if save from when danish is selected is clicked
		saveDanish.addActionListener(saveDan);
		ActionListener pastriesListener = new pastriesListener(); //when user makes a selection of the pastries
		pastries.addActionListener(pastriesListener);
		ActionListener cancelButton = new cancelListener(); //when user selects cancel button
		cancel.addActionListener(cancelButton);
		
	
		
		panel.add(pastries);
		panel2.add(flavorCookies);
		panel2.add(isHeatedCookie);
		panel2.add(saveCookie);
		panel.add(panel2);
		panel2.setVisible(false);
		panel3.add(flavorMuffins);
		panel3.add(isHeatedMuffin);
		panel3.add(saveMuffin);
		panel.add(panel3);
		panel3.setVisible(false);
		panel4.add(flavorCheesecake);
		panel4.add(isHeatedCheesecake);
		panel4.add(saveCheesecake);
		panel.add(panel4);
		panel4.setVisible(false); //so don't see at first
		panel5.add(flavorDanish);
		panel5.add(isHeatedDanish);
		panel5.add(saveDanish);
		panel.add(panel5);
		panel5.setVisible(false);
		panel.add(cancel);
		this.add(panel); //adds components to panel and adds panel to pane
		
		}
	/**
	 * what happens when option is selected (reaction)
	 * **/
	class pastriesListener implements ActionListener{
		/**
		 * when the click specifically is performed 
		 * resultant of user selecting an option from pastry menu
		 * @param selection - when a option is selected
		 * **/
		public void actionPerformed(ActionEvent selection) {
	
			Component n = (Component) selection.getSource(); //e.getSource() returns Object 
			JFrame m = (JFrame) SwingUtilities.getRoot(n);
			String a = (String) pastries.getSelectedItem();
			if(a.equals("Cookie")){ //if selection choice is cookie
				panel2.setVisible(true); //makes options for cookies visible
				panel3.setVisible(false);
				panel4.setVisible(false);
				panel5.setVisible(false);
			}
			else if(a.equals("Muffin")) {
				panel3.setVisible(true); //if selection choice is muffin
				panel2.setVisible(false); //makes options for muffins visible
				panel4.setVisible(false);
				panel5.setVisible(false);
				}
			else if(a.equals("Cheesecake Slice")) {
				panel4.setVisible(true); //if selection choice is cheesecake
				panel2.setVisible(false); //makes options for cheesecake visible
				panel3.setVisible(false);
				panel5.setVisible(false);
			}
			else if(a.equals("Danish")) { //if selection choice is danish
				panel5.setVisible(true); //makes danish options visible
				panel2.setVisible(false);
				panel3.setVisible(false);
				panel4.setVisible(false);
				
			}
		}
	}
	/**
	 * what happens when save button is clicked on a cookie (reaction)
	 * **/
	class saveCookieListener implements ActionListener{
		/**
		 * when the click specifically is performed 
		 * resultant of user clicking save cookie
		 * @param click - when a click action is performed
		 * **/
		public void actionPerformed(ActionEvent click) {
		Component n = (Component) click.getSource();  
			JFrame m = (JFrame) SwingUtilities.getRoot(n);
			m.setVisible(false);
			String a = (String) pastries.getSelectedItem();
			String b = (String) flavorCookies.getSelectedItem();
			boolean c = isHeatedCookie.isSelected();
			
			PastryItem P = new PastryItem(a,b,c); //calls pastry item with specifications
			String d = P.toString(); 
			subTotal = P.getCost();
			
			NewOrderFrame g = new NewOrderFrame(); //creates new frame
			g.addText(d); //adds order to frame
			g.setVisible(true); 
			g.firstOrder(subTotal); // gets total cost
			g.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		}
		}
	/**
	 * what happens when save button is clicked on a muffin (reaction)
	 * **/
	class saveMuffinListener implements ActionListener{
		/**
		 * when the click specifically is performed 
		 * resultant of user clicking save muffin
		 * @param click - when a click action is performed
		 * **/

		public void actionPerformed(ActionEvent click) {
		Component n = (Component) click.getSource(); 
			JFrame m = (JFrame) SwingUtilities.getRoot(n);
			m.setVisible(false);
			String a = (String) pastries.getSelectedItem();
			String b = (String) flavorMuffins.getSelectedItem();
			boolean c = isHeatedMuffin.isSelected();
			
			PastryItem PM = new PastryItem(a,b,c); //creates new muffin item
			String d = PM.toString();
			subTotal = PM.getCost();
			
			NewOrderFrame g = new NewOrderFrame(); //creates new frame
			g.addText(d); //adds item to frame
			g.setVisible(true); 
			g.firstOrder(subTotal); //gets total cost
			g.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		}
		}
	/**
	 * what happens when save button is clicked on a cheesecake (reaction)
	 * **/
	class saveCheesecakeListener implements ActionListener{
		/**
		 * when the click specifically is performed 
		 * resultant of user clicking save cheesecake
		 * @param click - when a click action is performed
		 * **/

		public void actionPerformed(ActionEvent click) {
		Component n = (Component) click.getSource(); 
			JFrame m = (JFrame) SwingUtilities.getRoot(n);
			m.setVisible(false);
			String a = (String) pastries.getSelectedItem();
			String b = (String) flavorCheesecake.getSelectedItem();
			boolean c = isHeatedCheesecake.isSelected();
			
			PastryItem PC = new PastryItem(a,b,c); //creates new cheesecake pastry item
			String d = PC.toString();
			subTotal = PC.getCost();
			
			NewOrderFrame g = new NewOrderFrame(); //creates a new frame
			g.addText(d); //adds order to frame
			g.setVisible(true);
			g.firstOrder(subTotal);
			g.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		}
		}
	/**
	 * what happens when save button is clicked on a danish (reaction)
	 * **/
	class saveDanishListener implements ActionListener{
		/**
		 * when the click specifically is performed 
		 * resultant of user clicking save a danish
		 * @param click - when a click action is performed
		 * **/

		public void actionPerformed(ActionEvent click) {
		Component n = (Component) click.getSource(); 
			JFrame m = (JFrame) SwingUtilities.getRoot(n);
			m.setVisible(false);
			String a = (String) pastries.getSelectedItem();
			String b = (String) flavorDanish.getSelectedItem();
			boolean c = isHeatedDanish.isSelected();
			
			PastryItem PD = new PastryItem(a,b,c); //creates new item using danish components
			String d = PD.toString();
			subTotal = PD.getCost();
			
			NewOrderFrame g = new NewOrderFrame(); //creates new frame
			g.addText(d); //adds item to frame
			g.setVisible(true);
			g.firstOrder(subTotal); 
			g.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		}
		}
	/**
	 * what happens when close button is clicked (reaction)
	 * **/
	class cancelListener implements ActionListener{
		
		/**
		 * when the click specifically is performed 
		 * resultant of user clicking close
		 * @param click - when a click action is performed
		 * **/
		@Override
		public void actionPerformed(ActionEvent click) {
			
			Component n = (Component) click.getSource(); //e.getSource() returns Object 
			JFrame m = (JFrame) SwingUtilities.getRoot(n);
			m.setVisible(false);
			FirstFrame r = new FirstFrame(); //goes back to first frame
		}
	}

	
}


	
