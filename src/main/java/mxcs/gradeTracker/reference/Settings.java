package mxcs.gradeTracker.reference;

import java.io.File;
import java.nio.file.Files;

/**
 * All settings used by the project.
 * 
 * @author JeremiahDeGreeff
 */
public class Settings {
	
	private static boolean encryptionEnabled = false;
	
	private static String dataDirectory = "data";
	
	private static String dataFile = "student.mxgt";
	
	public static void loadSettings() {
		if(Files.exists(FilePaths.SETTINGS)) {
			//TODO Settings from settings file
		} else {
			loadDefaultSettings();
		}
	}
	
	private static void loadDefaultSettings() {
		//TODO default settings
	}
	
	public static boolean isEncryptionEnabled() {
		return encryptionEnabled;
	}
	
	public static String getDataDirectory() {
		return dataDirectory;
	}
	
	public static String getDataPath() {
		return dataDirectory + File.separator + dataFile;
	}
	
}
