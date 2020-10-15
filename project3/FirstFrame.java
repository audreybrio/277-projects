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
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JPanel;
import javax.swing.SwingUtilities;
	
public class FirstFrame extends JFrame {
		protected JLabel instructions;
		protected JButton coffeeButton;
		protected JButton teaButton;
		protected JButton pastryButton;
		protected JButton done;
		protected JPanel p = new JPanel(); //instance variables
	
		/**
		 * default constructor that creates new frame
		 * **/
		public FirstFrame() {
			createComponents(); //creating the components and adds them to frame
			this.setTitle("New Item");
			this.setSize(500, 200);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		
		/**
		 * creates the components of the frame
		 * adds buttons, labels to panel to add to frame
		 * **/
		private void createComponents() {
			instructions = new JLabel("Choose a drink type: ");
			coffeeButton = new JButton("Coffee");
			teaButton = new JButton("Tea");
			pastryButton = new JButton("Pastry");
			done = new JButton("Done");
				//creates new componets for buttons and labels
			
			ActionListener coffeeListener = new CoffeeListener(); //if coffee button is clicked
			coffeeButton.addActionListener(coffeeListener);
			ActionListener teaListener = new TeaListener(); //if tea button is clicked
			teaButton.addActionListener(teaListener);
			ActionListener pastryListener = new PastryListener(); //if pastry button is clicked
			pastryButton.addActionListener(pastryListener);
			ActionListener doneListener = new DoneListener(); //if done button is clicked
			done.addActionListener(doneListener);
			
			p.add(instructions); //adding label to the panel
			p.add(coffeeButton); 
			p.add(teaButton); //adds button to panel
			p.add(pastryButton);
			p.add(done);
			done.setVisible(false);
			this.add(p); //adding the panel to this frame
		}
		
		
		/**
		 * what happens when coffee button is clicked (reaction)
		 * **/
		//INNER CLASS: ACTION LISTENER CLASS
		class CoffeeListener implements ActionListener
		{
			/**
			 * when the click specifically is performed 
			 * resultant of user clicking coffee
			 * @param arg0 - place holder
			 * **/
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				//Open a different frame with drop menus for the
				//different coffee options
				
				CoffeeFrame coffeeFrame = new CoffeeFrame(); //creates new coffee frame
				coffeeFrame.setVisible(true);
				coffeeFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				done.setVisible(true);
				//p.repaint();
			}
		}
		/**
		 * what happens when tea button is clicked (reaction)
		 * **/
		class TeaListener implements ActionListener
		{
			/**
			 * when the click specifically is performed 
			 * resultant of user clicking tea
			 * @param arg0 - placeholder
			 * **/
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//Open a different frame with drop menus for the
				//different coffee options
				done.setVisible(true);
				p.repaint();
				TeaFrame teaFrame = new TeaFrame(); //creates new tea frame
				teaFrame.setVisible(true);
				teaFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			}
		}
		/**
		 * what happens when pastry button is clicked (reaction)
		 * **/
		class PastryListener implements ActionListener
		{
			/**
			 * when the click specifically is performed 
			 * resultant of user clicking pastry
			 * @param arg0 -place holder
			 * **/
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//Open a different frame with drop menus for the
				//different coffee options
				done.setVisible(true);
				p.repaint();
				PastryFrame pastryFrame = new PastryFrame(); //creates new pastry frame
				pastryFrame.setVisible(true);
				pastryFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			}
		}
		/**
		 * what happens when done button is clicked (reaction)
		 * **/
		class DoneListener implements ActionListener{
			/**
			 * when the click specifically is performed 
			 * resultant of user clicking done
			 * @param click - when a click action is performed
			 * **/
			@Override
			public void actionPerformed(ActionEvent click) {
				
				Component n = (Component) click.getSource();
				JFrame m = (JFrame) SwingUtilities.getRoot(n);
				m.setVisible(false); //terminates program
			}
		}
		

			public static void main(String[] args) {
				FirstFrame n = new FirstFrame();
				n.setVisible(true);

			}


		}

	

