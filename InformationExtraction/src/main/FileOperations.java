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

	/**
	 * Reads and returns content of file.
	 * @param file path (the name of file with its directory).
	 * @return text read
	 */
	public String read(String filePath) throws IOException {
		//read file into stream
			return new String(Files.readAllBytes(Paths.get(filePath)));
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
