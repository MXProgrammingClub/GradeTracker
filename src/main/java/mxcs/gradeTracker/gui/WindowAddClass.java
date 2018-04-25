package mxcs.gradeTracker.gui;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * A class that implements the GUI for the "Add Class" button on the MainGUI
 * @author Kevin
 *
 */
public class WindowAddClass extends JFrame
{
	
	/**JTextField for the name of the Class*/
	private JTextField textNameClass;
	
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
		
		//Sub-top level
		

		
		//Box 1
		Box box1 = Box.createHorizontalBox();
		box1.add(miniVert);
		box1.add(miniVert2);
		
		Box mainVertical = Box.createVerticalBox();
		mainVertical.add(box1);
		JPanel mainPanel = new JPanel();
		mainPanel.add(mainVertical);
		this.add(mainPanel);
		this.setVisible(true);
		
	}
	
	/**
	 * Disposes this WindowAddClass JFrame
	 */
	public void close()
	{
		this.dispose();
	}
}
