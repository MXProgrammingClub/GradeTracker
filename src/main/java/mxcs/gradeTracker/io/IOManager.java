package mxcs.gradeTracker.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import mxcs.gradeTracker.backend.Student;
import mxcs.gradeTracker.reference.IOConstants;
import mxcs.gradeTracker.reference.Settings;

/**
 * Manages the I/O operations for the project.
 * 
 * @author JeremiahDeGreeff
 */
public class IOManager {
	
	/**
	 * The path to the data file.
	 * @see Settings
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
		try {Files.createDirectories(Paths.get(Settings.getDataDirectory()));}
		catch (IOException e) {e.printStackTrace();}
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
		String header = IOConstants.DATA_HEADER;
		
		int length = header.getBytes().length;
		List<byte[]> data = new ArrayList<byte[]>(Arrays.asList(header.getBytes()));
		
		//TODO encoding
		length += addData(data, "test");
		
		this.data = new byte[length];
		int i = 0;
		for(byte[] bytes : data)
			for(byte b : bytes)
				this.data[i++] = b;
	}
	
	private int addData(List<byte[]> data, Object o) {
		byte[] bytes = encode(o);
		data.add(bytes);
		return bytes.length;
	}
	
	private byte[] encode(Object o) {
		byte type = 0;
		byte[] value = null;
		try {
			type = IOConstants.getCode(o.getClass());
			value = toBytes(o);
		} catch (OperationNotSupportedException e) {e.printStackTrace();}
		byte[] data = new byte[value.length + 5];
		data[0] = type;
		data[1] = (byte)(value.length >> 12);
		data[2] = (byte)(value.length >> 8);
		data[3] = (byte)(value.length >> 4);
		data[4] = (byte)(value.length);
		for(int i = 0; i < value.length; i++)
			data[i + 5] = value[i];
		return data;
	}
	
	private byte[] toBytes(Object o) throws OperationNotSupportedException {
		if(o instanceof String)
			return ((String) o).getBytes();
		throw new OperationNotSupportedException("Invalid Type: " + o.getClass());
	}
	
}
