package mxcs.gradeTracker.reference;

import java.nio.file.Files;

/**
 * All settings used by the project.
 * 
 * @author JeremiahDeGreeff
 */
public class Settings {
	
	private static boolean encryptionEnabled = false;
	
	private static String dataPath = "data.bin";
	
	public static void loadSettings() {
		if(Files.exists(FilePaths.SETTINGS)) {
			
		} else {
			loadDefaultSettings();
		}
	}
	
	private static void loadDefaultSettings() {
		
	}
	
	public static boolean isEncryptionEnabled() {
		return encryptionEnabled;
	}
	
	public static String getDataPath() {
		return dataPath;
	}
	
}
