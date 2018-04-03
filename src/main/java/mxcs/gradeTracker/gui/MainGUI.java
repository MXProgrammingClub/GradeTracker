package gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 * Initial Tester GUI
 * @author Kevin
 *
 */
public class MainGUI implements ActionListener
{
	/**Main JFrame*/
	private JFrame frame;
	
	/**Main JMenuBar*/
	private JMenuBar menuBar;
	private JMenu file;
	private JMenuItem reallyCoolFeature1, reallyCoolFeature2;
	
	/**Add Class Button*/
	private JButton buttonAddClass;

	/**
	 * Main Method
	 */
	public static void main(String[] args)
	{
		new MainGUI();
	}

	/**
	 * Constructor for all the GUI Components
	 */
	public MainGUI()
	{
		//JFrame Settings
		frame = new JFrame("GradeTracker Prototype");
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//MenuBar Items
		menuBar = new JMenuBar();
		file = new JMenu("File");
		reallyCoolFeature1 = new JMenuItem("reallyCoolFeature1");
		reallyCoolFeature1.addActionListener(this);
		reallyCoolFeature2 = new JMenuItem("reallyCoolFeature2");
		reallyCoolFeature2.addActionListener(this);

		file.add(reallyCoolFeature1);
		file.add(reallyCoolFeature2);
		menuBar.add(file);
		frame.setJMenuBar(menuBar);

		//JPanels and layouts for organization
		JPanel mainPanel = new JPanel();

		//Size of all the buttons
		Dimension buttonSize = new Dimension(200, 30);
		
		//Class 1
		JButton class1 = new JButton("Math 50");
		class1.setSize(buttonSize);
		class1.setMinimumSize(buttonSize);
		class1.setMaximumSize(buttonSize);
		class1.setPreferredSize(buttonSize);
		class1.repaint();
		JLabel class1Grade = new JLabel("100.1%");

		Box boxClass1 = Box.createHorizontalBox();
		boxClass1.add(class1);
		boxClass1.add(Box.createHorizontalStrut(10));
		boxClass1.add(class1Grade);

		//Class 2
		JButton class2 = new JButton("Physics 10");
		class2.setSize(buttonSize);
		class2.setMinimumSize(buttonSize);
		class2.setMaximumSize(buttonSize);
		class2.setPreferredSize(buttonSize);
		class2.repaint();
		JLabel class2Grade = new JLabel("99.96%");

		Box boxClass2 = Box.createHorizontalBox();
		boxClass2.add(class2);
		boxClass2.add(Box.createHorizontalStrut(10));
		boxClass2.add(class2Grade);

		//Class 3
		JButton class3 = new JButton("Spanish 12");
		class3.setSize(buttonSize);
		class3.setMinimumSize(buttonSize);
		class3.setMaximumSize(buttonSize);
		class3.setPreferredSize(buttonSize);
		class3.repaint();
		JLabel class3Grade = new JLabel("60.00%");

		Box boxClass3 = Box.createHorizontalBox();
		boxClass3.add(class3);
		boxClass3.add(Box.createHorizontalStrut(10));
		boxClass3.add(class3Grade);
		
		//Add Class
		buttonAddClass = new JButton("+");
		buttonAddClass.addActionListener(this);
		JLabel addClassDesc = new JLabel("Add Class");
		
		Box boxAddClass = Box.createHorizontalBox();
		boxAddClass.add(buttonAddClass);
		boxAddClass.add(Box.createHorizontalStrut(10));
		boxAddClass.add(addClassDesc);
		boxAddClass.add(Box.createHorizontalStrut(130));


		//Main Organizing Box
		Box mainVertical = Box.createVerticalBox();
		mainVertical.add(Box.createVerticalStrut(40));
		mainVertical.add(boxClass1);
		mainVertical.add(boxClass2);
		mainVertical.add(boxClass3);
		mainVertical.add(Box.createVerticalStrut(60));
		mainVertical.add(boxAddClass);

		mainPanel.add(mainVertical);

		frame.add(mainPanel);
		frame.setVisible(true);
	}

	/**
	 * Super useful getter method
	 */
	public JFrame getFrame()
	{
		return frame;
	}

	/**
	 * Process user interaction
	 */
	public void actionPerformed(ActionEvent e) 
	{
		Object src = e.getSource();

		if (src == reallyCoolFeature1)
			System.out.println("You are cool");

		else if (src == reallyCoolFeature2)
			System.out.println("omegalul");
		
		else if (src == buttonAddClass)
			System.out.println("Wait for implementation OMEGALUL");

	}

}
