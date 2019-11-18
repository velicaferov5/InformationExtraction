package main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;

/*
 * @author Vali_Jafarov
 * ReadFile class to read any file.
 * */

public class FileOperations {

	private String text;
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	/**
	 * Reads content of file. Returns true if reading is successful (e.g file exists), false in other cases.
	 * If file is read, assigns content to text String which can be retrieved via getText() method.
	 * @param file path (the name of file with its directory).
	 * @return true if reading is completed successfully.
	 */
	public boolean read(String filePath) {
		// validate filePath
		if(!(new File(filePath).exists()))
			return false;
		
		//read file into stream
		String content="";
		try {
			content = new String(Files.readAllBytes(Paths.get(filePath)));
			setText(content);
			return true;

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
     * Exports text into file in given path.
     * @param text to be exported
     * @param outputPath containing name of file to export with its directory
     * @return true if text successfully extracted into file, false if any problem occurs
     */
	public boolean exportToFile(String text, String outputPath) {
		
		// Validate outputPath
		File file = new File(outputPath.substring(0,outputPath.lastIndexOf("/")));
		if(!file.isDirectory())
			return false;

		// Write into file (overwrites if file exists)
		try {
			Writer fileWriter = new FileWriter(outputPath);
			fileWriter.write(text);
			fileWriter.close();
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
