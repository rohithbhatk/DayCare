package edu.neu.csye6200.utils;

/*
 * 20 points Code, Compile with no errors using a File Utility class, 
 * i.e. design a useful FileUtility class with useful methods for reading and writing files 
 * and programmed in ‘FileUtil.java’.
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class FileUtil {
	//static ClassRoom school = new ClassRoom(0, null, null);
	
	public static FileReader openFileReader(String filename) throws FileNotFoundException {
		return new FileReader(filename);
	}
	public static BufferedReader openBufferedReader(FileReader filenameobject) {
		return new BufferedReader(filenameobject);
	}
	
	public static String readBufferedReader(BufferedReader bufferedReader) throws IOException {
		return bufferedReader.readLine();

	}
	
	public static FileWriter openFileWriter(String filename) throws IOException {
		return new FileWriter(filename);
	}
	public static BufferedWriter openBufferedWriter(FileWriter filenameobject) {
		return new BufferedWriter(filenameobject);
	}
	
	public static void writeBufferedWriter(BufferedWriter bufferwriter, String lineNo) throws IOException {
		bufferwriter.write(lineNo);
		bufferwriter.newLine();

	}
	
	
	
}
