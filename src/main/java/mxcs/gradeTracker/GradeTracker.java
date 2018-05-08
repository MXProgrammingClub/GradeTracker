package mxcs.gradeTracker;

import java.io.IOException;

import mxcs.gradeTracker.io.IOManager;
import mxcs.gradeTracker.reference.IOConstants;

/**
 * The main class for the Grade Tracker.
 * 
 * @author Middlesex Computer Science Club 2018
 */
public class GradeTracker {
	
	public static void main(String[] args) {
		IOConstants.init();
		
		IOManager manager = new IOManager();
		try {
			manager.loadStudent();
			manager.saveStudent();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
