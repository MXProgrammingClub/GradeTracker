package mxcs.gradeTracker.gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
public class MainGUI implements ActionListener, KeyListener
{
	/**Main JFrame*/
	private static JFrame frame;

	/**Constants that track the default width and height of the Main GUI*/
	private static final int DEFAULTWIDTH = 400, DEFAULTHEIGHT = 400;

	/**The Current Width and Height of all Windows*/
	public static int curWidth, curHeight;

	/**Main JMenuBar*/
	private JMenuBar menuBar;
	private JMenu file;
	private JMenuItem reallyCoolFeature1, buttonChangeRes;

	/**Add Class Button*/
	private JButton buttonAddClass, buttonSetRes, buttonDefaultRes;

	/**Booleans to make sure multiple instances of a single type of window aren't instantiated*/
	private boolean hasResolutionWindow;

	/**Change resolution fields*/
	private JTextField widthField, heightField;

	/**Notification Label*/
	private JLabel infoLabel;

	/**Array of all current Boxes that hold classes
	 * Format: index 0 - JButton for class, index 1 - Horizontal Strut, index 2 - JLabel for grade
	 */
	private ArrayList<GUIClass> arrayClasses = new ArrayList<GUIClass>();

	/**Dimension of the buttons for the classes*/
	private Dimension buttonSize;

	/**Main organizing Box in the default startup menu*/
	private static Box mainVertical;

	private Box boxAddClass;

	/**Main organizing panel for the main JFrame*/
	private JPanel mainPanel = new JPanel();

	/**Main notification message*/
	private JPanel panelInfo = new JPanel();

	/**
	 * Main Method
	 */
	public static void main(String[] args)
	{
		MainGUI yay1 = new MainGUI();
//		yay1.updateUI();
//		yay1.removeClass("Math 50f");
//		yay1.updateUI();
		//		yay1.updateUI();
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
		buttonChangeRes = new JMenuItem("Change Resolution");
		buttonChangeRes.addActionListener(this);

		file.add(reallyCoolFeature1);
		file.add(buttonChangeRes);
		menuBar.add(file);
		frame.setJMenuBar(menuBar);

		//Size of all the buttons
		buttonSize = new Dimension(200, 30);

		//Class 1
		JButton class1Button = new JButton("Math 50");
		class1Button.setSize(buttonSize);
		class1Button.setMinimumSize(buttonSize);
		class1Button.setMaximumSize(buttonSize);
		class1Button.setPreferredSize(buttonSize);
		class1Button.repaint();
		JLabel class1Grade = new JLabel("100.1%");

		GUIClass class1 = new GUIClass(class1Button, class1Grade);
		arrayClasses.add(class1);

		//Class 2
		JButton class2Button = new JButton("Physics 10");
		class2Button.setSize(buttonSize);
		class2Button.setMinimumSize(buttonSize);
		class2Button.setMaximumSize(buttonSize);
		class2Button.setPreferredSize(buttonSize);
		class2Button.repaint();
		JLabel class2Grade = new JLabel("99.96%");

		GUIClass class2 = new GUIClass(class2Button, class2Grade);
		arrayClasses.add(class2);

		//Class 3
		JButton class3Button = new JButton("Spanish 12");
		class3Button.setSize(buttonSize);
		class3Button.setMinimumSize(buttonSize);
		class3Button.setMaximumSize(buttonSize);
		class3Button.setPreferredSize(buttonSize);
		class3Button.repaint();
		JLabel class3Grade = new JLabel("60.00%");

		GUIClass class3 = new GUIClass(class3Button, class3Grade);
		arrayClasses.add(class3);

		//Add Class
		buttonAddClass = new JButton("+");
		buttonAddClass.addActionListener(this);
		JLabel addClassDesc = new JLabel("Add Class");

		boxAddClass = Box.createHorizontalBox();
		boxAddClass.add(buttonAddClass);
		boxAddClass.add(Box.createHorizontalStrut(10));
		boxAddClass.add(addClassDesc);
		boxAddClass.add(Box.createHorizontalStrut(130));

		infoLabel = new JLabel("Welcome!");
		panelInfo.add(infoLabel);



		//Main Organizing Box
		mainVertical = Box.createVerticalBox();

		//TODO HERE
		mainVertical = Box.createVerticalBox();

		mainVertical.add(panelInfo);
		mainVertical.add(Box.createVerticalStrut(40)); //TODO MAKE VARIABLE THAT CHANGES WITH RES
		for (GUIClass c : arrayClasses)
		{
			c.setButtonSize(buttonSize); //TODO MAKE VARIABLE THAT CHANGES WITH RES
			mainVertical.add(c.getBox(10)); //TODO MAKE VARIABLE THAT CHANGES WITH RES

		}
		mainVertical.add(Box.createVerticalStrut(60)); //TODO MAKE VARIABLE THAT CHANGES WITH RES
		mainVertical.add(boxAddClass);
		mainVertical.repaint();
		mainVertical.revalidate();
		mainPanel.repaint();
		mainPanel.revalidate();

		mainPanel.add(mainVertical);
		frame.add(mainPanel);
		frame.setVisible(true);

	}

	/**
	 * Updates the Graphical Interface of the program
	 */
	public static void updateUI()
	{
		System.out.println("updateGUI Called");

		//TODO: CALCULATE DIMENSION
		frame.setSize(curWidth, curHeight);
		frame.repaint();
		frame.revalidate();

	}

	/**
	 * Super useful getter method
	 */
	public JFrame getFrame()
	{
		return frame;
	}

	/**
	 * @return the standard buttonSize of all the class JButtons
	 */
	public Dimension getButtonSize()
	{
		return buttonSize;
	}

	/**
	 * Removes a given class from arrayClasses, based on the name displayed on the JButton
	 * @param clas5
	 */
	private void removeClass(String clas5)
	{
		int index = 0;
		for (int i = 0; i < arrayClasses.size(); i ++)
			if(arrayClasses.get(i).getClassName().equals(clas5))
			{
				System.out.println("Class found :D");
				index = i;
				break;
			}

		arrayClasses.remove(index);
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

		frameRes.getRootPane().setDefaultButton(buttonSetRes);
		frameRes.add(vertBox);


	}

	/**
	 * Process user interaction
	 */
	public void actionPerformed(ActionEvent e) 
	{
		Object src = e.getSource();

		if (src == reallyCoolFeature1)
			MainGUI.updateUI();

		else if (src == buttonChangeRes)
			promptUserChangeResolution();

		else if (src == buttonAddClass)
		{
			if (!WindowAddClass.exists)
			{
				new WindowAddClass();
			}
		}


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
	
	private static void newClassOptionsWindow()
	{
		JFrame temp = new JFrame();
		temp.setSize(DEFAULTWIDTH/2, DEFAULTHEIGHT/2);
		Box mainHorizontal = Box.createHorizontalBox();
		JPanel mainPanel = new JPanel();

		
		
		
	}

	/**
	 * Process user key presses
	 */
	public void keyPressed(KeyEvent e) 
	{
		
	}

	@Override
	public void keyReleased(KeyEvent e) 
	{

	}

	@Override
	public void keyTyped(KeyEvent e) 
	{

	}
}
