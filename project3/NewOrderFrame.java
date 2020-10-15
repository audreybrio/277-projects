package project3;
/**
 * @author Audrey Brio
 * @release March 19,2019
 * this class lets creates frame to order a pick something to order
 * **/
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import project3.CoffeeFrame.SaveButtonListener;
import project3.FirstFrame.CoffeeListener;
import project3.PastryFrame.pastriesListener;
import project3.PastryFrame.saveCheesecakeListener;
import project3.PastryFrame.saveCookieListener;
import project3.PastryFrame.saveDanishListener;
import project3.PastryFrame.saveMuffinListener;
//import project3.FirstFrame.TeaListener;
import project3products.CoffeeItem;
import project3products.PastryItem;
import project3products.TeaItem;

public class NewOrderFrame extends JFrame{
	
	private String currentOrder;
	private JLabel order;
	private JButton coffee;
	private JButton tea;
	private JButton pastry;
	private JButton done;
	private JTextArea receipt; //instance variables 
	
	private JComboBox<String> sizes;
	private JComboBox<String> teaspoons;
	private JComboBox<String> milkBase;
	private JComboBox<String> flav;
	private JComboBox<String> temp;
	private JTextField specialInt; //instance variables for new coffee item
	
	private JComboBox<String> sizesTea;
	private JComboBox<String> teaspoonsTea;
	private JComboBox<String> milkBaseTea;
	private JComboBox<String> flavTea;
	private JCheckBox boba;
	private JCheckBox poppingBoba;
	private JCheckBox grassJelly;
	private JCheckBox lycheeJelly;
	private JCheckBox coconutJelly;
	private JCheckBox miniMochi; //instance variables for new tea item
	
	private JComboBox<String> pastries;
	private JComboBox<String> flavorCookies;
	private JComboBox<String> flavorMuffins;
	private JComboBox<String> flavorCheesecake;
	private JComboBox<String> flavorDanish;
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
	private JPanel panel5; //instance variables for new pastry item
	
	String q;
	private JTextArea work;
	private double tax = 0.10;
	private double subTotal = 0.00;
	protected double finalCost = 0.00;
	double withTax = 0.00; //instance variables for getting total cost, tax, and subtotal
	private ArrayList<Double> costs = new ArrayList<Double>();

	/**
	 * default constructor that creates new frame
	 * **/
	public NewOrderFrame() {
		this.setSize(700, 750);
		createComponents();
		this.setTitle("New Order");
	}
	/**
	 * creates the components of the frame
	 * creates and adds buttons, labels, text are to panel to add to frame
	 * **/
	private void createComponents() {
		// TODO Auto-generated method stub
		order = new JLabel("Select an item to purchase: ");
		coffee = new JButton("Coffee");
		tea = new JButton("Tea");
		pastry = new JButton("Pastry");
		final int R = 35;
		final int C = 60;
		work = new JTextArea(R,C);
		final int ROW = 35;
		final int COLUMN = 60; //sets row and columns of text area
		receipt = new JTextArea(ROW, COLUMN);
		receipt.setText("                                  ~~~~~~~~~~~~~~~~~~~~~~~~~ Current Order ~~~~~~~~~~~~~~~~~~~~~~~~~");
		work.setText("                                  ~~~~~~~~~~~~~~~~~~~~~~~~~ Current Order ~~~~~~~~~~~~~~~~~~~~~~~~~");
		receipt.setEditable(false);
		done = new JButton("Done"); //creates components
		
		ActionListener coffeeListener = new CoffeeListener(); //reaction to when coffee button is clicked
		coffee.addActionListener(coffeeListener);
		ActionListener teaListener = new TeaListener(); //reaction to when tea button is clicked
		tea.addActionListener(teaListener);
		ActionListener pastryListener = new PastryListener(); //reaction to when pastry button is clicked
		pastry.addActionListener(pastryListener);
		ActionListener doneListener = new DoneListener(); //reaction to when done button is clicked
		done.addActionListener(doneListener);
		
		
		JPanel panel = new JPanel();
		
		panel.add(order);
		panel.add(coffee);
		panel.add(tea);
		panel.add(pastry);
		panel.add(receipt);
		JScrollPane scrollPane = new JScrollPane(receipt);
		panel.add(scrollPane);
		panel.add(work);
		JScrollPane scrollPane2 = new JScrollPane(work);
		panel.add(scrollPane2);
		scrollPane2.setVisible(false);
		work.setVisible(false);
		panel.add(done);
		this.add(panel); //adds components to panel
		
	}
	
	/**
	 *method adds text to end of receipt
	 *@param a - string that is being added to receipt 
	 * **/
	public void addText(String a) {
		receipt.append(a);
		work.append(a);
	}
	
	/**
	 * what happens when option is selected (reaction)
	 * this is for when the user has already ordered an item and wants to order a new coffee item
	 * **/
	class CoffeeListener implements ActionListener
	{
		/**
		 * when the click specifically is performed 
		 * resultant of user selecting an option from pastry menu
		 * @param arg0 - no action yet
		 * **/
		@Override
		public void actionPerformed(ActionEvent arg0) {
//			coffeeFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

			JLabel fl;
			JLabel sz;
			JLabel sugar;
			JLabel mlk;
			JLabel type;
			JLabel si;
			JLabel instructions;
		    JButton saveButton;
			JButton closeButton;
			
			JFrame C = new JFrame();
				C.setVisible(true);
				C.setTitle("New Coffee Order");
				C.setSize(800, 400);
				
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
				String[] bases = {"no milk", "whole milk", "half-and-half"};
				milkBase = new JComboBox<String>(bases);
				type = new JLabel("type");
				String[] temperature = {"Iced", "Blended", "Hot"};
				temp = new JComboBox<String>(temperature);
				si = new JLabel("Special Instructions:");
				final int SI_WIDTH = 20;
				specialInt = new JTextField(SI_WIDTH);
				saveButton = new JButton("Save Order");
				closeButton = new JButton("Cancel");
				
				ActionListener saveListener = new SaveButtonListener();
				saveButton.addActionListener(saveListener); //adding reaction instructions
				//to our button
				ActionListener closeListener = new CloseButtonListener();
				closeButton.addActionListener(closeListener);
				
				JPanel panel = new JPanel();
				panel.add(instructions);
				panel.add(fl);
				panel.add(flav);
				panel.add(sz);
				panel.add(sizes); //dd menu for sizes added to panel
				panel.add(sugar);
				panel.add(teaspoons); //dd menu for # of teaspoons added to panel
				panel.add(mlk);
				panel.add(milkBase);
				panel.add(type);
				panel.add(temp);
				panel.add(si);
				panel.add(specialInt);
				panel.add(saveButton);
				panel.add(closeButton);
				
				C.add(panel);//adding the panel to this frame
				
				
			}
		/**
		 * what happens when option is clicked (reaction)
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
					q = work.getText();
					receipt.setText(q);
					
					Component n = (Component) click.getSource(); 
					JFrame m = (JFrame) SwingUtilities.getRoot(n);
					m.setVisible(false);
					
					String a = (String) flav.getSelectedItem();
					String b = (String) sizes.getSelectedItem();
					String c = (String) teaspoons.getSelectedItem();
					String d = (String) milkBase.getSelectedItem();
					String e = (String) temp.getSelectedItem();
					String f = specialInt.getText();
					
					CoffeeItem coffee = new CoffeeItem(b,a,d,c,e,f);
					double l = coffee.getCost();
					costs.add(l);
					String k = coffee.toString();
					receipt.append(k);
					work.append(k);
					getFinalCost();
				}
				
			}
			/**
			 * what happens when option is clicked (reaction)
			 * **/
			class CloseButtonListener implements ActionListener{
				/**
				 * when the click specifically is performed 
				 * resultant of user clicking close
				 * @param click - when a click action is performed
				 * **/
				public void actionPerformed(ActionEvent click) {
					
					Component n = (Component) click.getSource(); //e.getSource() returns Object 
					JFrame m = (JFrame) SwingUtilities.getRoot(n);
					m.setVisible(false);
				}
			}

		}

	/**
	 * what happens when option is selected (reaction)
	 * this is when the user has already ordered something and wants to order a new tea item
	 * **/
	class TeaListener implements ActionListener
	{
		/**
		 * when the click specifically is performed 
		 * resultant of user selecting an option from pastry menu
		 * @param arg0 - no action yet
		 * **/
		@Override
		public void actionPerformed(ActionEvent arg0) {

			JFrame T = new JFrame();
			T.setTitle("New Tea Order");
			T.setSize(900, 400);
			T.setVisible(true);
			//T.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			JLabel sz;
			JLabel sweet;
			JLabel mlk;
			JLabel instructions;
			JButton saveButton;
			JButton closeButton;
			
				instructions = new JLabel("Specify the tea order: ");
				String[] flavors = {"Green Tea", "Black Tea", "Jasmine Green Tea", "Rose Tea", "Oolong Tea"};
				flavTea = new JComboBox<String>(flavors);
				sz = new JLabel("size:");
				String[] s = {"S", "M" ,"L"};
				sizesTea = new JComboBox<String>(s);
				sweet = new JLabel("sweetness:");
				String[] numTeaspoons = {"full sweet", "3/4 sweet", "1/2 sweet", "1/4 sweet", "unsweetened"};
				teaspoonsTea = new JComboBox<String>(numTeaspoons);
				mlk = new JLabel("milk:");
				String[] bases = {"whole milk", "half-and-half", "no milk"};
				milkBaseTea = new JComboBox<String>(bases);
				boba = new JCheckBox("boba");
				poppingBoba = new JCheckBox("popping boba");
				grassJelly = new JCheckBox("grass jelly");
				lycheeJelly = new JCheckBox("lychee jelly");
				coconutJelly = new JCheckBox("coconut jelly");
				miniMochi = new JCheckBox("mini mochi");
				
				saveButton = new JButton("Save Order");
				closeButton = new JButton("Cancel");
				
				ActionListener saveListener = new SaveButtonListener();
				saveButton.addActionListener(saveListener); //adding reaction instructions
				//to our button
				ActionListener CloseBListener = new CloseButtonListener();
				closeButton.addActionListener(CloseBListener);
				
				JPanel panel = new JPanel();
				panel.add(instructions);	
				panel.add(flavTea);
				panel.add(sz);
				panel.add(sizesTea); //dd menu for sizes added to panel
				panel.add(sweet);
				panel.add(teaspoonsTea); //dd menu for # of teaspoons added to panel
				panel.add(mlk);
				panel.add(milkBaseTea);
				panel.add(saveButton);
				panel.add(closeButton);
				panel.add(boba);
				panel.add(poppingBoba);
				panel.add(grassJelly);
				panel.add(lycheeJelly);
				panel.add(coconutJelly);
				panel.add(miniMochi);
				
				T.add(panel);//adding the panel to this frame
				
			}
			
		/**
		 * what happens when option is clicked (reaction)
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
					q = work.getText();
					receipt.setText(q);
					Component n = (Component) click.getSource(); 
					JFrame m = (JFrame) SwingUtilities.getRoot(n);
					m.setVisible(false);
					
					
					
					String a = (String) flavTea.getSelectedItem();
					String b = (String) sizesTea.getSelectedItem();
					String c = (String) teaspoonsTea.getSelectedItem();
					String d = (String) milkBaseTea.getSelectedItem();
					boolean e = boba.isSelected();
					boolean f = poppingBoba.isSelected();
					boolean g = grassJelly.isSelected();
					boolean h = lycheeJelly.isSelected();
					boolean i = coconutJelly.isSelected();
					boolean j = miniMochi.isSelected();
					
					
					
					TeaItem tea = new TeaItem(b,a,d,c);
					
					if(e == true) {
						tea.addTopping("boba");
					}
					if(f == true) {
						tea.addTopping("popping boba");
					}
					if(g == true) {
						tea.addTopping("grass jelly");
					}
					if(h == true) {
						tea.addTopping("lychee jelly");
					}
					if(i == true) {
						tea.addTopping("coconut jelly");
					}
					if(j == true) {
						tea.addTopping("mini mochi");
					}
					String k = tea.toString();
					Double l = tea.getCost();
					costs.add(l);
					receipt.append(k);
					work.append(k);
					getFinalCost();
					
					
				}
				
			}
			/**
			 * what happens when option is clicked (reaction)
			 * **/
			
			class CloseButtonListener implements ActionListener{
				/**
				 * when the click specifically is performed 
				 * resultant of user clicking close
				 * @param click - when a click action is performed
				 * **/
				public void actionPerformed(ActionEvent click) {
					
					Component n = (Component) click.getSource(); //e.getSource() returns Object 
					JFrame m = (JFrame) SwingUtilities.getRoot(n);
					m.setVisible(false);
				}
			}
			
}
	/**
	 * what happens when option is clicked (reaction) 
	 * this is when they already ordered a first item and are ordering a new pastry item
	 * **/
	class PastryListener implements ActionListener
	{
		/**
		 * when the click specifically is performed 
		 * resultant of user selecting an option from pastry menu
		 * @param arg0 - no action yet
		 * **/
		@Override
		public void actionPerformed(ActionEvent arg0) {
		
			JFrame P = new JFrame();  
			P.setTitle("New Pastry Order");
			P.setSize(900, 400);
			P.setVisible(true);
			JButton cancel;
	
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
				
				ActionListener saveCook = new saveCookieListener();
				saveCookie.addActionListener(saveCook);
				ActionListener saveMuff = new saveMuffinListener();
				saveMuffin.addActionListener(saveMuff);
				ActionListener saveCheese = new saveCheesecakeListener();
				saveCheesecake.addActionListener(saveCheese);
				ActionListener saveDan = new saveDanishListener();
				saveDanish.addActionListener(saveDan);
				ActionListener pastriesListener = new pastriesListener();
				pastries.addActionListener(pastriesListener);
				ActionListener cancelButton = new cancelListener();
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
				panel4.setVisible(false);
				panel5.add(flavorDanish);
				panel5.add(isHeatedDanish);
				panel5.add(saveDanish);
				panel.add(panel5);
				panel5.setVisible(false);
				panel.add(cancel);
				P.add(panel);
				
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
			
					Component n = (Component) selection.getSource(); 
					JFrame m = (JFrame) SwingUtilities.getRoot(n);
					String a = (String) pastries.getSelectedItem();
					if(a.equals("Cookie")){
						panel2.setVisible(true);
						panel3.setVisible(false);
						panel4.setVisible(false);
						panel5.setVisible(false);
					}
					else if(a.equals("Muffin")) {
						panel3.setVisible(true);
						panel2.setVisible(false);
						panel4.setVisible(false);
						panel5.setVisible(false);
						}
					else if(a.equals("Cheesecake Slice")) {
						panel4.setVisible(true);
						panel2.setVisible(false);
						panel3.setVisible(false);
						panel5.setVisible(false);
					}
					else if(a.equals("Danish")) {
						panel5.setVisible(true);
						panel2.setVisible(false);
						panel3.setVisible(false);
						panel4.setVisible(false);
					}
				}
			}
			/**
			 * what happens when option is clicked (reaction)
			 * **/
			
			class saveCookieListener implements ActionListener{
				/**
				 * when the click specifically is performed 
				 * resultant of user clicking save cookie
				 * @param click - when a click action is performed
				 * **/
				public void actionPerformed(ActionEvent click) {
					q = work.getText();
					receipt.setText(q);
				Component n = (Component) click.getSource(); 
					JFrame m = (JFrame) SwingUtilities.getRoot(n);
					m.setVisible(false);
					String a = (String) pastries.getSelectedItem();
					String b = (String) flavorCookies.getSelectedItem();
					boolean c = isHeatedCookie.isSelected();
					
					PastryItem P = new PastryItem(a,b,c);
					String d = P.toString();
					Double l = P.getCost();
					costs.add(l);
					receipt.append(d);
					work.append(d);
					getFinalCost();
				}
			}
			/**
			 * what happens when option is clicked (reaction)
			 * **/
			class saveMuffinListener implements ActionListener{
				/**
				 * when the click specifically is performed 
				 * resultant of user clicking save muffin
				 * @param click - when a click action is performed
				 * **/
				public void actionPerformed(ActionEvent click) {
					q = work.getText();
					receipt.setText(q);
				Component n = (Component) click.getSource();
					JFrame m = (JFrame) SwingUtilities.getRoot(n);
					m.setVisible(false);
					String a = (String) pastries.getSelectedItem();
					String b = (String) flavorMuffins.getSelectedItem();
					boolean c = isHeatedMuffin.isSelected();
					
					PastryItem PM = new PastryItem(a,b,c);
					String d = PM.toString();
					Double l = PM.getCost();
					costs.add(l);
					receipt.append(d);
					work.append(d);
					getFinalCost();
				}
			}
			/**
			 * what happens when option is clicked (reaction)
			 * **/
			class saveCheesecakeListener implements ActionListener{
				/**
				 * when the click specifically is performed 
				 * resultant of user clicking save cheesecake
				 * @param click - when a click action is performed
				 * **/
				public void actionPerformed(ActionEvent click) {
					q = work.getText();
					receipt.setText(q);
				Component n = (Component) click.getSource(); 
					JFrame m = (JFrame) SwingUtilities.getRoot(n);
					m.setVisible(false);
					String a = (String) pastries.getSelectedItem();
					String b = (String) flavorCheesecake.getSelectedItem();
					boolean c = isHeatedCheesecake.isSelected();
					
					PastryItem PC = new PastryItem(a,b,c);
					String d = PC.toString();
					Double l = PC.getCost();
					costs.add(l);
					receipt.append(d);
					work.append(d);
					getFinalCost();
				}
			}
			/**
			 * what happens when option is clicked (reaction)
			 * **/
			class saveDanishListener implements ActionListener{
				/**
				 * when the click specifically is performed 
				 * resultant of user clicking save a danish
				 * @param click - when a click action is performed
				 * **/
				public void actionPerformed(ActionEvent click) {
					q = work.getText();
					receipt.setText(q);
				Component n = (Component) click.getSource(); //e.getSource() returns Object 
					JFrame m = (JFrame) SwingUtilities.getRoot(n);
					m.setVisible(false);
					String a = (String) pastries.getSelectedItem();
					String b = (String) flavorDanish.getSelectedItem();
					boolean c = isHeatedDanish.isSelected();
					
					PastryItem PD = new PastryItem(a,b,c);
					String d = PD.toString();
					Double l = PD.getCost();
					costs.add(l);
					receipt.append(d);
					work.append(d);
					getFinalCost();
			
				}
			}
			/**
			 * what happens when option is selected (reaction)
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
				}
			}
		}
	
	/**
	 * what happens when option is selected (reaction)
	 * **/
	class DoneListener implements ActionListener{
		/**
		 * when the click specifically is performed 
		 * resultant of user clicking done
		 * @param click - when a click action is performed
		 * **/
		public void actionPerformed(ActionEvent click) {
		Component n = (Component) click.getSource(); 
			JFrame m = (JFrame) SwingUtilities.getRoot(n);
			m.setVisible(false);
			Final();
			work.setVisible(true);
			receipt.setVisible(false);
			String a = (String) work.getText();
			FinializeOrder fin = new FinializeOrder();
			fin.getCost(finalCost);
			fin.addReceipt(a);
		}
	}
	
	/**
	 * method gets final cost of order
	 * updates total
	 * @return finalCost - returns the final cost of order
	 * **/
	public double getFinalCost() {
		
		for(int i = 0; i < costs.size(); i++) {
			subTotal = subTotal + costs.get(i) ;
			costs.remove(i);
		}
		withTax = subTotal * tax;
		finalCost = withTax + subTotal;
		String v = String.format("\n\nSubtotal:   $%.2f%n \n Tax:  $%.2f%n \n Total:   $%.2f%n",subTotal, withTax, finalCost);
		receipt.append(v);
		return finalCost;
	}
	/**
	 * adds final cost to end of order
	 * **/
	public void Final() {
		String v = String.format("\n\nSubtotal:   $%.2f%n \nTax:  $%.2f%n \nTotal:   $%.2f%n",subTotal, withTax, finalCost);
		work.append(v);
	}
	/**
	 * method gets the first order from coffee/tea/pastry frame
	 * @param a - takes in the cost of that order
	 * **/
	public void firstOrder(double a) {
		subTotal = a;
		getFinalCost(); 
	}
}

