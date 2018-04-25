package mxcs.gradeTracker.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * A class that implements the GUI for the "Add Class" button on the MainGUI
 * @author Kevin
 *
 */
public class WindowAddClass extends JFrame implements ActionListener
{

	/**JTextField for the name of the Class*/
	private JTextField textNameClass;

	/**Box that stores all the added subcategories of a class*/
	private Box boxCategories; 

	/**'+category' button*/
	private JButton buttonAddCategory;

	/**Button that tells the program that the user has entered everything*/
	private JButton buttonComplete;

	/**
	 * Instantiates a WindowAddClass JFrame
	 */
	public WindowAddClass()
	{	
		super("Add a Class");
		System.out.println("New WindowAddClass instantiated");
		this.setSize(MainGUI.curWidth, MainGUI.curHeight);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


		//3 Horizontal Boxes
		//Name & 'Categories'
		//All added subcategories
		//'Add Category' and 'Complete'


		/**
		 * Box that aligns the JLabels 'name' and 'categories'
		 */
		JLabel labelName = new JLabel("Name: ");
		JLabel labelTitle = new JLabel("Categories: ");

		JPanel panelLabelName = new JPanel();
		panelLabelName.add(labelName);

		JPanel panelLabelTitle = new JPanel();
		panelLabelTitle.add(labelTitle);

		Box miniVert = Box.createVerticalBox();
		miniVert.add(panelLabelName);
		miniVert.add(panelLabelTitle);


		/**
		 * Box that ensures the textNameClass stays aligned with ONLY the lableName
		 */
		textNameClass = new JTextField("OMG I LOVE WRITING WORKSHOP");
		JTextField textFiller = new JTextField(textNameClass.getColumns());
		textFiller.setVisible(false);
		textFiller.setEditable(false);

		JPanel panelTextNameClass = new JPanel();
		panelTextNameClass.add(textNameClass);

		JPanel panelTextFiller = new JPanel();
		panelTextFiller.add(textFiller);

		Box miniVert2 = Box.createVerticalBox();
		miniVert2.add(panelTextNameClass);
		miniVert2.add(panelTextFiller);

		//Box 1
		Box box1 = Box.createHorizontalBox();
		box1.add(miniVert);
		box1.add(miniVert2);

		//Box 2
		boxCategories = Box.createVerticalBox();

		//Box 3
		buttonAddCategory = new JButton("Add Category");
		buttonAddCategory.addActionListener(this);
		buttonComplete = new JButton("Complete");
		buttonComplete.addActionListener(this);
		
		JPanel panelButtonAddCategory = new JPanel();
		panelButtonAddCategory.add(buttonAddCategory);
		
		JPanel panelButtonComplete = new JPanel();
		panelButtonComplete.add(buttonComplete);
		
		
		Box box3 = Box.createHorizontalBox();
		box3.add(panelButtonAddCategory);
		box3.add(panelButtonComplete);



		//Final GUI and JFrame stuff :D
		Box mainVertical = Box.createVerticalBox();
		mainVertical.add(box1);
		mainVertical.add(boxCategories);
		mainVertical.add(box3);

		JPanel mainPanel = new JPanel();
		mainPanel.add(mainVertical);
		this.add(mainPanel);
		this.setVisible(true);

	}

	private void addCategory()
	{

	}
	
	/**
	 * Displays a "Invalid Class Settings" MessageDialog JOptionPane to the user
	 */
	private void showError()
	{
		JOptionPane.showMessageDialog(this,
				"Invalid Class Settings",
				"Error",
				JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * Disposes this WindowAddClass JFrame
	 */
	public void close()
	{
		this.dispose();
	}

	/**
	 * Event handler for the WindowAddClass Class
	 */
	public void actionPerformed(ActionEvent e) 
	{
		Object source = e.getSource();

		if (source.equals(buttonAddCategory))
		{
			System.out.println("User wants to add a category");
		}
		
		else if (source.equals(buttonComplete))
		{
			System.out.println("User thinks he is better than me D:");
		}
	}
}
