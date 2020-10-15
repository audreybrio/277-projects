package project3;
/**
 * @author Audrey Brio
 * @release March 19,2019
 * this class lets creates frame to order a coffee drink
 * **/


import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import project3products.CoffeeItem;

public class CoffeeFrame extends FirstFrame{
	
	private JLabel fl;
	private JLabel sz;
	private JLabel sugar;
	private JLabel mlk;
	private JLabel type;
	private JLabel si;
	private JLabel instructions;
	private JComboBox<String> sizes;
	private JComboBox<String> teaspoons;
	private JComboBox<String> milkBase;
	private JComboBox<String> flav;
	private JComboBox<String> temp;
	private JTextField specialInt;
	private JButton saveButton;
	private JButton closeButton; //instance variables
	
	private double subTotal = 0.00; 
	
	/**
	 * default constructor that creates new frame
	 * **/
	public CoffeeFrame() {
		createComponents();
		this.setTitle("New Coffee Order");
		this.setSize(800, 400);
	}
	/**
	 * creates the components of the frame
	 * creates and adds buttons, labels, combo boxes, text fields to panel to add to frame
	 * **/
	private void createComponents() {
		instructions = new JLabel("Specify the coffee order: ");	
		fl = new JLabel("flavor:");
		String[] flavors = {"Regular", "Mocha", "Hazulnut", "Vanilla"};
		flav = new JComboBox<String>(flavors);
		sz = new JLabel("size:");
		String[] s = {"S", "M" ,"L"};
		sizes = new JComboBox<String>(s);
		sugar = new JLabel("sugar");
		String[] numTeaspoons = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
		teaspoons = new JComboBox<String>(numTeaspoons);
		mlk = new JLabel("milk:");
		String[] bases = {"no milk", "whole milk", "hald-and-half"};
		milkBase = new JComboBox<String>(bases);
		type = new JLabel("type");
		String[] temperature = {"Iced", "Blended", "Hot"};
		temp = new JComboBox<String>(temperature);
		si = new JLabel("Special Instructions:");
		final int SI_WIDTH = 20;
		specialInt = new JTextField(SI_WIDTH);
		saveButton = new JButton("Save Order");
		closeButton = new JButton("Cancel");
				//creates names of labels and buttons and combo boxes
		
		ActionListener saveListener = new SaveButtonListener();
		saveButton.addActionListener(saveListener); //adding reaction instructions
		//to our button
		ActionListener closeListener = new CloseButtonListener();
		closeButton.addActionListener(closeListener); //if button is clicked then go here
		
		JPanel panel = new JPanel(); //creates new panel
		panel.add(instructions);
		panel.add(fl);
		panel.add(flav);
		panel.add(sz);
		panel.add(sizes); //dd menu for sizes added to panel
		panel.add(sugar);
		panel.add(teaspoons); //dd menu for # of teaspoons added to panel
		panel.add(mlk);
		panel.add(milkBase); //dd menu for milk added to panel
		panel.add(type);
		panel.add(temp);
		panel.add(si);
		panel.add(specialInt);
		panel.add(saveButton);
		panel.add(closeButton);
		
		this.add(panel);//adding the panel to this frame
		
	}
	
	/**
	 * what happens when save button is clicked (reaction)
	 * **/
	//INNER CLASS EVENT LISTENER
	class SaveButtonListener implements ActionListener{
		/**
		 * when the click specifically is performed 
		 * resultant of user clicking save
		 * @param click - when a click action is performed
		 * **/
		@Override
		public void actionPerformed(ActionEvent click) {
			Component n = (Component) click.getSource();
			JFrame m = (JFrame) SwingUtilities.getRoot(n);
			m.setVisible(false);
			
			String a = (String) flav.getSelectedItem(); //gets selection of different options
			String b = (String) sizes.getSelectedItem();
			String c = (String) teaspoons.getSelectedItem();
			String d = (String) milkBase.getSelectedItem();
			String e = (String) temp.getSelectedItem();
			String f = specialInt.getText();
			
			CoffeeItem coffee = new CoffeeItem(b,a,d,c,e,f); //creates new coffee item
			String k = coffee.toString();
			subTotal = coffee.getCost();
			
			NewOrderFrame z = new NewOrderFrame(); //creates new order frame
			z.addText(k); //adds order to new frame
			z.setVisible(true);
			z.firstOrder(subTotal);
			z.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		}
		
	}
	/**
	 * what happens when close button is clicked (reaction)
	 * **/
	class CloseButtonListener implements ActionListener{
		
		/**
		 * when the click specifically is performed 
		 * resultant of user clicking close
		 * @param click - when a click action is performed
		 * **/
		@Override
		public void actionPerformed(ActionEvent click) {
			
			
			Component n = (Component) click.getSource(); 
			JFrame m = (JFrame) SwingUtilities.getRoot(n);
			m.setVisible(false);
			FirstFrame fr = new FirstFrame(); //goes back to first frame
			
		}
	}

}
