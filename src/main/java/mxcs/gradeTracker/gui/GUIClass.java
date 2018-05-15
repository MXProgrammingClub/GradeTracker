package mxcs.gradeTracker.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 * This class represents a school class for the GUI, containing the JButton and JLabel associated with it
 * This class can also return a javax.swing.HorizontalBox representation of itself
 * @author Kevin
 *
 */
public class GUIClass {
	
	private JLabel grade;
	private JButton button;
	private String name;
	
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
		this.name = name;
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
	 * @param strutLength The length of the strut that separates the JButton and the JLabel
	 * @return A JPanel holding a singular javax.swing.HorizontalBox component that represents this class object --> can be directly inserted in to mainVertical
	 */
	public Box getBox(int strutLength)
	{		
		Box resultant = Box.createHorizontalBox();
		resultant.add(Box.createHorizontalGlue());
		resultant.add(button);
//		resultant.add(Box.createHorizontalStrut(strutLength));
		resultant.add(Box.createHorizontalGlue());
		resultant.add(grade);
		resultant.add(Box.createHorizontalGlue());

		return resultant;
		
//		JPanel toReturn = new JPanel();
//		toReturn.add(resultant);
//		
//		return toReturn;
	}
	
	public String getClassName()
	{
		return this.button.getText();
	}
}
