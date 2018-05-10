package mxcs.gradeTracker.io;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import mxcs.gradeTracker.backend.Student;
import mxcs.gradeTracker.reference.IOConstants;

/**
 * Encodes a {@link Student} object for storage in a file.
 * 
 * @author JeremiahDeGreeff
 */
public class Encoder {
	
	/**
	 * Encodes a {@code Student} as a {@code byte[]}.
	 * 
	 * @param s the {@code Student} to encode
	 * @return the data to be saved
	 */
	public byte[] encode(Student s) {
		String header = IOConstants.DATA_HEADER;
		
		int length = header.getBytes().length;
		List<byte[]> data = new ArrayList<byte[]>(Arrays.asList(header.getBytes()));
		
		//TODO encoding
		length += addData(data, "this");
		length += addData(data, "is");
		length += addData(data, "a");
		length += addData(data, "test");
		
		byte[] encoded = new byte[length];
		int i = 0;
		for(byte[] bytes : data)
			for(byte b : bytes)
				encoded[i++] = b;
		return encoded;
	}
	
	/**
	 * Adds the encoded data of an Object to a List of data arrays.
	 * 
	 * @param data the List of data arrays
	 * @param o the Object to encode and add
	 * @return the length of the added {@code byte[]}
	 */
	private int addData(List<byte[]> data, Object o) {
		byte[] bytes = encodeObject(o);
		data.add(bytes);
		return bytes.length;
	}
	
	/**
	 * Encodes an Object as a TLV pair.
	 * 
	 * @param o the Object to encode
	 * @return a TLV {@code byte[]} representation of the Object
	 * @see IOConstants#getCode(java.lang.reflect.Type)
	 */
	private byte[] encodeObject(Object o) {
		byte type = 0;
		byte[] value = null;
		try {
			type = IOConstants.getCode(o.getClass());
			value = toBytes(o);
		} catch (UnsupportedOperationException e) {e.printStackTrace();}
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
	
	/**
	 * Converts the data of an Object into bytes.
	 * Only particular types of Objects are supported.
	 * 
	 * @param o the Object to convert
	 * @return a representation of that Object as a {@code byte[]}
	 * @throws UnsupportedOperationException if the type of {@code o} is not supported
	 */
	private byte[] toBytes(Object o) throws UnsupportedOperationException {
		if(o instanceof String)
			return ((String) o).getBytes();
		throw new UnsupportedOperationException("Invalid Type: " + o.getClass());
	}
	
}
