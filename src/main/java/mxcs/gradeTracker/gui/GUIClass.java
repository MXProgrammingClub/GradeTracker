package mxcs.gradeTracker.gui;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This class represents a school class for the GUI, containing the JButton and JLabel associated with it
 * This class can also return a javax.swing.HorizontalBox representation of itself
 * @author Kevin
 *
 */
public class GUIClass {
	
	private JLabel grade;
	private JButton button;
	
	/**
	 * Constructor for the GUIClass class that initializes the two instance variables to the two parameters
	 */
	public GUIClass(JButton button, JLabel grade)
	{
		this.grade = grade;
		this.button = button;
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
		resultant.add(button);
		resultant.add(Box.createHorizontalStrut(strutLength));
		resultant.add(grade);
		
		return resultant;
		
//		JPanel toReturn = new JPanel();
//		toReturn.add(resultant);
//		
//		return toReturn;
	}
}
