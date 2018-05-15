package mxcs.gradeTracker.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GUITest extends JFrame implements ActionListener{

	private static JFrame frame;
	private static JPanel titlePanel, classPanel, buttonPanel;
	private static JLabel title; 
	private static final Font titleFont = new Font("Dialog", Font.BOLD, 20);
	private static final Font buttonFont = new Font("Dialog", Font.ITALIC, 16);
	private static final Font classFont = new Font("Dialog", Font.BOLD, 16);
	private static final Font gradeFont = new Font("Dialog", Font.BOLD, 16);
	private static JButton addClassButton;
	private static ArrayList<GUIClass> classes = new ArrayList<GUIClass>();
	private static Dimension classButtonSize = new Dimension(200, 40);
	private static JMenuBar menuBar;
	private static JMenu menuFile;
	private static JMenuItem itemExit;

	public GUITest()
	{
		super("Grade Tracker");
		frame = this;

		menuBar = new JMenuBar();
		itemExit = new JMenuItem("Exit");
		menuFile = new JMenu("File");
		menuFile.add(itemExit);
		itemExit.addActionListener(this);
		
		menuBar.add(menuFile);
		
		frame.setJMenuBar(menuBar);
		
		titlePanel = new JPanel();
		titlePanel.setBackground(Color.red);

		classPanel = new JPanel();
		classPanel.setBackground(Color.yellow);
		classPanel.setLayout(new BoxLayout(classPanel, BoxLayout.Y_AXIS));
		classPanel.setAlignmentX(CENTER_ALIGNMENT);
		classPanel.setAlignmentY(CENTER_ALIGNMENT);
		
		buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.green);
//		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		
		Box mainVertical = Box.createVerticalBox();
		mainVertical.add(titlePanel);
		mainVertical.add(classPanel);
		mainVertical.add(buttonPanel);
		
		title = new JLabel("Welcome to MX GradeTracker!");
		title.setBackground(Color.pink);
		title.setForeground(Color.cyan);
		title.setFont(titleFont);
		titlePanel.add(title);
		
		addClassButton = new JButton("Add Class");
		addClassButton.setOpaque(true);
		addClassButton.setFont(buttonFont);
		addClassButton.setBackground(Color.white);
		addClassButton.setForeground(Color.black);
		addClassButton.setFocusable(false);
		addClassButton.setAlignmentY(CENTER_ALIGNMENT);
		addClassButton.addActionListener(this);
		buttonPanel.add(addClassButton);
		
		frame.add(mainVertical);
		
		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public static void addClass(String name)
	{
		GUIClass newGUIClass = new GUIClass(new JButton(), new JLabel(), classFont, gradeFont, Color.white, Color.black, name, "100%", classButtonSize);
		classes.add(newGUIClass);
		displayClasses();
	}
	
	public static boolean removeClass(String name)
	{
		for(GUIClass c : classes)
			if(c.getName() == name)
			{
				classes.remove(c);
				displayClasses();

				return true;
			}
		
		displayClasses();
		return false;
		
	}
	
	private static void displayClasses()
	{
		classPanel.removeAll();
		for(int i = 0; i < classes.size(); i ++)
		{
			if (i == 0)
				classPanel.add(Box.createVerticalGlue());
			classPanel.add(classes.get(i).getBox());
			classPanel.add(Box.createVerticalGlue());
		}
		
		classPanel.revalidate();
		classPanel.repaint();
	}

	public static void main(String[] args)
	{
		new GUITest();
		GUITest.addClass("AP Calculus BC");		
		GUITest.addClass("AP Physics 1");	
		GUITest.addClass("AP English");	
		GUITest.addClass("US History");	
		GUITest.addClass("Computer Science");	
		GUITest.addClass("AP Art History");	


	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Object src = e.getSource();
		if (src.equals(addClassButton))
		{
			System.out.println("Add class button clicked.");
		}
		
		else if (src.equals(itemExit))
		{
			System.exit(0);
		}
	}

}
