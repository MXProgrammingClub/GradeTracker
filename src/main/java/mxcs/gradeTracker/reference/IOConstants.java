package mxcs.gradeTracker.reference;

import java.lang.reflect.Type;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

import javax.naming.OperationNotSupportedException;

import mxcs.gradeTracker.backend.*;

/**
 * Reference constants for the project.
 * 
 * @author JeremiahDeGreeff
 */
public class IOConstants {
	
	public static final String DATA_VERSION = "0.0";
	public static final String DATA_HEADER = "mxgt version=\"" + DATA_VERSION + "\"\n";
	
	private static final Map<Type, Byte> TYPE_CODES = new TreeMap<Type, Byte>(new Comparator<Type>() {public int compare(Type o1, Type o2) {return o1.getTypeName().compareTo(o2.getTypeName());}});
	
	public static void init() {
		TYPE_CODES.put(boolean.class,	(byte)0x01b);
		TYPE_CODES.put(byte.class,		(byte)0x02b);
		TYPE_CODES.put(char.class,		(byte)0x03b);
		TYPE_CODES.put(short.class,		(byte)0x04b);
		TYPE_CODES.put(int.class,		(byte)0x05b);
		TYPE_CODES.put(long.class,		(byte)0x06b);
		TYPE_CODES.put(float.class,		(byte)0x07b);
		TYPE_CODES.put(double.class,	(byte)0x08b);
		TYPE_CODES.put(String.class,	(byte)0x09b);
		TYPE_CODES.put(Score.class,		(byte)0x0Ab);
		TYPE_CODES.put(Course.class,	(byte)0x0Bb);
		TYPE_CODES.put(Student.class,	(byte)0x0Cb);
	}
	
	public static byte getCode(Type t) throws OperationNotSupportedException {
		if(!TYPE_CODES.containsKey(t))
			throw new OperationNotSupportedException("Invalid Type: " + t);
		return TYPE_CODES.get(t);
	}
	
}
