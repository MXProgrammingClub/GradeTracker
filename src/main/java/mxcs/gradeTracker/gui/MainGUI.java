package mxcs.gradeTracker.gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Initial Tester GUI
 * @author Kevin
 *
 */
public class MainGUI implements ActionListener
{
	/**Main JFrame*/
	private JFrame frame;

	/**Constants that track the default width and height of the Main GUI*/
	private static final int DEFAULTWIDTH = 400, DEFAULTHEIGHT = 400;

	/**The Current Width and Height of all Windows*/
	private int curWidth, curHeight;

	/**Main JMenuBar*/
	private JMenuBar menuBar;
	private JMenu file;
	private JMenuItem reallyCoolFeature1, reallyCoolFeature2;

	/**Add Class Button*/
	private JButton buttonAddClass, buttonSetRes, buttonDefaultRes;

	/**Booleans to make sure multiple instances of a single type of window aren't instantiated*/
	private boolean hasResolutionWindow;

	/**Change resolution fields*/
	private JTextField widthField, heightField;
	
	/**Notification Label*/
	private JLabel infoLabel;
	
	/**Array of all current classes*/
	private ArrayList<> classes;
	
	/**Dimension of the buttons for the classes*/
	private Dimension buttonSize;

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
		frame.setSize(DEFAULTWIDTH, DEFAULTHEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		curWidth = DEFAULTWIDTH;
		curHeight = DEFAULTHEIGHT;

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
		buttonSize = new Dimension(200, 30);

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

		//Welcome Message
		JPanel panelInfo = new JPanel();
		infoLabel = new JLabel("Welcome!");
		panelInfo.add(infoLabel);
		
		
		

		//Main Organizing Box
		Box mainVertical = Box.createVerticalBox();
		mainVertical.add(panelInfo);
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
	 * Updates the Graphical Interface of the program
	 */
	private void updateUI()
	{
		//TODO: CALCULATE DIMENSION USED BY CLASSTYPE
		frame.setSize(curWidth, curHeight);
		frame.repaint();
	}

	/**
	 * Super useful getter method
	 */
	public JFrame getFrame()
	{
		return frame;
	}
	
	public Dimension getButtonSize()
	{
		
	}


	/**
	 * Private helper method that is called when the user wants to change the resolution
	 * If a resolution window doesn't already exist, creates a new resolution JFrame/Window
	 */
	private void promptUserChangeResolution()
	{
		//A resolution window already exists
		if (hasResolutionWindow)
		{
			System.out.println("A Resolution Window already exists");
			return;
		}

		hasResolutionWindow = true;

		//New Choose Resolution Window
		JFrame frameRes = new JFrame("Change Resolution");
		frameRes.setSize(400, 400);
		frameRes.setVisible(true);
		frameRes.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		//Override of "x" button on the JFrame
		//Sets boolean hasResolutionWindow to false and disposes the JFrame
		frameRes.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent){
				hasResolutionWindow = false;
				frameRes.dispose();
			}
		});

		//Width JLabel
		JLabel widthLabel = new JLabel("Width:");
		JPanel widthPanel1 = new JPanel();
		widthPanel1.add(widthLabel);

		//Width JTextField
		widthField = new JTextField(30);
		JPanel widthPanel2 = new JPanel();
		widthField.setText("" + curWidth);
		widthPanel2.add(widthField);


		//Height JLabel
		JLabel heightLabel = new JLabel("Height:");
		JPanel heightPanel1 = new JPanel();
		heightPanel1.add(heightLabel);

		//Height JTextField
		heightField = new JTextField(30);
		JPanel heightPanel2 = new JPanel();
		heightField.setText("" + curHeight);
		heightPanel2.add(heightField);

		buttonSetRes = new JButton("Set Resolution");
		buttonSetRes.addActionListener(this);
		buttonDefaultRes = new JButton("Default Resolution");
		buttonDefaultRes.addActionListener(this);

		//Set Res Button
		JPanel setResPanel = new JPanel();
		setResPanel.add(buttonSetRes);

		//Default Res Button
		JPanel defaultResPanel = new JPanel();
		defaultResPanel.add(buttonDefaultRes);


		//Main Vertical Box
		Box vertBox = Box.createVerticalBox();
		//		vertBox.add(Box.createVerticalGlue());
		vertBox.add(widthPanel1);
		vertBox.add(widthPanel2);
		vertBox.add(heightPanel1);
		vertBox.add(heightPanel2);
		vertBox.add(setResPanel);
		vertBox.add(defaultResPanel);

		frameRes.add(vertBox);


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
			promptUserChangeResolution();

		else if (src == buttonAddClass)
			infoLabel.setText("Something Happened");

		else if (src == buttonDefaultRes)
		{
			widthField.setText("" + DEFAULTWIDTH);
			heightField.setText("" + DEFAULTHEIGHT);
		}

		else if (src == buttonSetRes)
		{
			try{
				int width = Integer.parseInt(widthField.getText());
				int height = Integer.parseInt(heightField.getText());
				curWidth = width;
				curHeight = height;
			} catch (Exception e2)
			{
				System.out.println("Error parsing integer value from field");
			}

			updateUI();
		}
	}
}
