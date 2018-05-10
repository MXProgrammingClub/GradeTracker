package mxcs.gradeTracker.reference;

import java.io.File;
import java.nio.file.Files;

/**
 * All settings used by the project.
 * 
 * @author JeremiahDeGreeff
 */
public class Settings {
	
	/**
	 * Whether encryption is enabled or disabled.
	 */
	private static boolean encryptionEnabled = false;
	/**
	 * The directory of the data file.
	 */
	private static String dataDirectory = "data";
	/**
	 * The name of the data file.
	 */
	private static String dataFile = "student.mxgt";
	
	/**
	 * Loads the user preferences from the settings file.
	 */
	public static void loadSettings() {
		if(Files.exists(FilePaths.SETTINGS)) {
			//TODO Settings from settings file
		} else {
			loadDefaultSettings();
		}
	}
	
	/**
	 * Loads the default settings.
	 */
	private static void loadDefaultSettings() {
		//TODO default settings
	}
	
	/**
	 * @return true if encryption is enabled, false otherwise
	 */
	public static boolean isEncryptionEnabled() {
		return encryptionEnabled;
	}
	
	/**
	 * @return the directory of the data file
	 */
	public static String getDataDirectory() {
		return dataDirectory;
	}
	
	/**
	 * @return the path to the data file
	 */
	public static String getDataPath() {
		return dataDirectory + File.separator + dataFile;
	}
	
}
