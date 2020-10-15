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
import javax.swing.SwingUtilities;

import project3products.TeaItem;



public class TeaFrame extends FirstFrame{
	
	private JLabel sz;
	private JLabel sweet;
	private JLabel mlk;
	private JLabel instructions;
	private JComboBox<String> sizesTea;
	private JComboBox<String> teaspoonsTea;
	private JComboBox<String> milkBaseTea;
	private JComboBox<String> flavTea;
	private JButton saveButton;
	private JButton closeButton;
	private JCheckBox boba;
	private JCheckBox poppingBoba;
	private JCheckBox grassJelly;
	private JCheckBox lycheeJelly;
	private JCheckBox coconutJelly;
	private JCheckBox miniMochi;
	
	private double subTotal = 0.00; //instance variables
	
	/**
	 * default constructor that creates new frame
	 * **/
	public TeaFrame() {
		createComponents();
		this.setTitle("New Tea Order");
		this.setSize(900, 400);
	}

	/**
	 * creates the components of the frame
	 * creates and adds buttons, labels, combo boxes, and check booxes to panel to add to frame
	 * **/
	private void createComponents() {
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
		miniMochi = new JCheckBox("mini mochi"); //creates new components
		
		saveButton = new JButton("Save Order");
		closeButton = new JButton("Cancel");
		
		ActionListener saveListener = new SaveButtonListener(); //when save button is clicked
		saveButton.addActionListener(saveListener); 
		ActionListener closeListener = new CloseButtonListener(); //when close button is clicked
		closeButton.addActionListener(closeListener);
		
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
		panel.add(poppingBoba); //adds check box option of toppings
		panel.add(grassJelly);
		panel.add(lycheeJelly);
		panel.add(coconutJelly);
		panel.add(miniMochi);
		
		this.add(panel);//adding the panel to frame
		
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
			
			String a = (String) flavTea.getSelectedItem();
			String b = (String) sizesTea.getSelectedItem();
			String c = (String) teaspoonsTea.getSelectedItem();
			String d = (String) milkBaseTea.getSelectedItem(); //gets users selections
			boolean e = boba.isSelected();
			boolean f = poppingBoba.isSelected();
			boolean g = grassJelly.isSelected();
			boolean h = lycheeJelly.isSelected();
			boolean i = coconutJelly.isSelected();
			boolean j = miniMochi.isSelected();
			
			TeaItem tea = new TeaItem(b,a,d,c); //creates new tea item using specifications
			
			if(e == true) {
				tea.addTopping("boba"); //if user selected toppings, added to toppings list it tea item
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
			subTotal = tea.getCost();
			
			NewOrderFrame z = new NewOrderFrame(); //creates new frame
			z.addText(k); //adds tea item to frame
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
			FirstFrame r = new FirstFrame(); //goes back to first frame
		}
	}
	
	
}