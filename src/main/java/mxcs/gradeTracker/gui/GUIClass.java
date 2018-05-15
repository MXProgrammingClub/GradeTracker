package mxcs.gradeTracker.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * This class represents a school class for the GUI, containing the JButton and JLabel associated with it
 * This class can also return a javax.swing.HorizontalBox representation of itself
 * @author Kevin
 *
 */
public class GUIClass implements ActionListener{

	private static final Font titleFont = new Font("Dialog", Font.BOLD, 20);
	private static final Font buttonFont = new Font("Dialog", Font.ITALIC, 16);
	private static final Font listFont = new Font("Dialog", Font.PLAIN, 16);

	private JLabel grade;
	private JButton button;
	private String name;
	private boolean hasGradeWindow;

	/**
	 * Constructor for the GUIClass class that initializes the two instance variables to the two parameters
	 */
	public GUIClass(JButton button, JLabel grade, Font font1, Font font2, Color bg, Color fg, String name, String GPA, Dimension d)
	{
		this.grade = grade;
		this.grade.setText(GPA);
		this.grade.setFont(font2);
		this.grade.setAlignmentX(Component.RIGHT_ALIGNMENT);

		this.button = button;
		this.button.setAlignmentX(Component.LEFT_ALIGNMENT);
		this.button.setFocusable(false);
		this.button.setText(name);
		this.button.setFont(font1);
		this.button.setOpaque(true);
		this.button.setPreferredSize(d);
		this.button.setBackground(bg);
		this.button.setForeground(fg);
		this.button.addActionListener(this);
		this.name = name;
		
		hasGradeWindow = false;
	}

	/**
	 * Sets the name of this GUIClass
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * Returns the name of this GUIClass
	 */
	public String getName()
	{
		return this.name;
	}

	/**
	 * Sets the text of this GUIClass' JLabel to grade
	 */
	public void setGrade(int grade)
	{
		this.grade.setText("" + grade);
	}

	/**
	 * Sets the JButton of this GUIClass to the given parameter
	 */
	public void setButton(JButton button)
	{
		this.button = button;
	}

	/**
	 * Sets the dimension of this GUIClass' JButton to d
	 */
	public void setButtonSize(Dimension d)
	{
		this.button.setSize(d);
		this.button.setMinimumSize(d);
		this.button.setMaximumSize(d);
		this.button.setPreferredSize(d);
		this.button.repaint();
		this.button.revalidate();
	}

	/**
	 * @return a JLabel that represents this GUIClass' grade
	 */
	public JLabel getGrade()
	{
		return this.grade;
	}

	/**
	 * @return the JButton associated with this GUIClass
	 */
	public JButton getButton()
	{
		return this.button;
	}

	/**
	 * @return A Box holding a singular javax.swing.HorizontalBox component that represents this class object --> can be directly inserted in to mainVertical
	 */
	public Box getBox()
	{		
		Box resultant = Box.createHorizontalBox();
		resultant.add(Box.createHorizontalGlue());
		resultant.add(button);
		resultant.add(Box.createHorizontalGlue());
		resultant.add(grade);
		resultant.add(Box.createHorizontalGlue());

		return resultant;

		//		JPanel toReturn = new JPanel();
		//		toReturn.add(resultant);
		//		
		//		return toReturn;
	}

	public void openGradeHistory()
	{
		//TODO: REFRESH
		if (hasGradeWindow)
			return;
		
		hasGradeWindow = true;
		
		JFrame historyFrame = new JFrame();
		historyFrame.setTitle("Grade History");
		historyFrame.setSize(600, 600);
		historyFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		//Override of "x" button on the JFrame
		//Sets boolean hasResolutionWindow to false and disposes the JFrame
		historyFrame.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent){
				hasGradeWindow = false;
				historyFrame.dispose();
			}
		});
		
		JPanel titlePanel = new JPanel();
		titlePanel.setBackground(Color.red);

		JPanel gradePanel = new JPanel();
		gradePanel.setBackground(Color.yellow);
//		gradePanel.setLayout(new BoxLayout(gradePanel, BoxLayout.Y_AXIS));
//		gradePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
//		gradePanel.setAlignmentY(Component.CENTER_ALIGNMENT);
		
		//List and History Component
		JList<String> list = new JList<String>();
		list.setFont(listFont);
		String[] testData = {"Ch. 54 Test - Right Triangles     50%", "Ch. 54 Test - Right Triangles     50%", "Ch. 54 Test - Right Triangles     50%", "Ch. 54 Test - Right Triangles     50%", "Ch. 54 Test - Right Triangles     50%", "Ch. 54 Test - Right Triangles     50%", "Ch. 54 Test - Right Triangles     50%", "Ch. 54 Test - Right Triangles     50%", "Ch. 54 Test - Right Triangles     50%", "Ch. 54 Test - Right Triangles     50%", "Ch. 54 Test - Right Triangles     50%", "Ch. 54 Test - Right Triangles     50%", "Ch. 54 Test - Right Triangles     50%", "Ch. 54 Test - Right Triangles     50%", "Ch. 54 Test - Right Triangles     50%", "Ch. 54 Test - Right Triangles     50%", "Ch. 54 Test - Right Triangles     50%", "Ch. 54 Test - Right Triangles     50%", "Ch. 54 Test - Right Triangles     50%", "Ch. 54 Test - Right Triangles     50%", "Ch. 54 Test - Right Triangles     50%", "Ch. 54 Test - Right Triangles     50%", "Ch. 54 Test - Right Triangles     50%", "Ch. 54 Test - Right Triangles     50%", "Ch. 54 Test - Right Triangles     50%", "Ch. 54 Test - Right Triangles     50%", "Ch. 54 Test - Right Triangles     50%", };
		list.setListData(testData);		
		JScrollPane scrollPane = new JScrollPane(list);
		gradePanel.add(scrollPane);

		//TODO ADD JLIST OF EVERYTHING
		
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.green);
		
		Box mainVertical = Box.createVerticalBox();
		mainVertical.add(titlePanel);
		mainVertical.add(gradePanel);
		mainVertical.add(buttonPanel);
		
		JLabel title = new JLabel("Grade History for " + this.name);
		title.setBackground(Color.pink);
		title.setForeground(Color.cyan);
		title.setAlignmentX(Component.LEFT_ALIGNMENT);
		title.setFont(titleFont);
		titlePanel.add(title);
		
		JButton refreshButton = new JButton("Refresh");
		refreshButton.setOpaque(true);
		refreshButton.setFont(buttonFont);
		refreshButton.setBackground(Color.white);
		refreshButton.setForeground(Color.black);
		refreshButton.setFocusable(false);
		refreshButton.setAlignmentY(Component.CENTER_ALIGNMENT);
		refreshButton.addActionListener(this);
		buttonPanel.add(refreshButton);
		
		historyFrame.add(mainVertical);
		
		historyFrame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Object src = e.getSource();
		if (src.equals(this.getButton()))
		{
			System.out.println(this.name + " was clicked.");
			openGradeHistory();
		}

	}
}
