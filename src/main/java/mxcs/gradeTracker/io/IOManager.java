package mxcs.gradeTracker.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import com.sun.webkit.ThemeClient;

import mxcs.gradeTracker.reference.Settings;

/**
 * Manages the I/O operations for the project.
 * 
 * @author JeremiahDeGreeff
 */
public class IOManager {
	
	/**
	 * The path to the data file. @see Settings
	 */
	private Path path;
	
	/**
	 * The Student object which is loaded from and saved to the file.
	 */
	private Student student;
	
	/**
	 * The raw data which is loaded from and saved to the file.
	 */
	private byte[] data;
	
	/**
	 * The user's password for encryption.
	 */
	private String password;
	
	/**
	 * Instantiates an {@code IOManger} with a given password.
	 * 
	 * @param student the {@code Student} object to save the data of
	 * @param password a password for encryption - must be at most 16 bytes (ASCII characters)
	 */
	public IOManager() {
		this.path = Paths.get(Settings.getDataPath());
	}
	
	/**
	 * Loads the student data from the file.
	 * If the file does not exist it is created to represent a new {@code Student} which is returned.
	 * 
	 * @return the student which the file represents
	 * @throws IOException if an I/O error occurs
	 */
	public Student loadStudent() throws IOException {
		if(Files.exists(path)) {
			loadFile();
			decode();
		} else {
			student = new Student();
			saveStudent();
		}
		return student;
	}
	
	/**
	 * Saves the data of the {@code Student} associated with this {@code IOManager} to the specified file.
	 * 
	 * @return true if successful, false otherwise
	 * @throws IOException if an I/O error occurs
	 */
	public boolean saveStudent() throws IOException {
		encode();
		return saveFile();
	}
	
	/**
	 * Loads the data from the data file if it exists.
	 * 
	 * @return true if successful, false otherwise
	 * @throws IOException if an I/O error occurs
	 */
	private boolean loadFile() throws IOException {
		data = Files.readAllBytes(path);
		return true;
	}
	
	/**
	 * Saves the data to the data file.
	 * 
	 * @return true if successful, false otherwise
	 * @throws IOException if an I/O error occurs
	 */
	private boolean saveFile() throws IOException {
		Files.write(path, data);
		return true;
	}
	
	/**
	 * Decodes {@code data} into a {@code Student} object and saves it as {@code student}.
	 */
	private void decode() {
		//TODO decoding
	}
	
	/**
	 * Encodes {@code student} into a {@code byte[]} and saves it as the {@code data}.
	 */
	private void encode() {
		//TODO encoding
	}
	
}
