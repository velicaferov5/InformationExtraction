package main;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

/** 
 * @author Vali_Jafarov
 * Extract class extracts information from file.
 * File is parsed and fields are searched, found using Rabin-Karp algorithm.
 * Found fields are boldfaced in file and saves to InformationExtraction/output directory.
 */

public class Extract {
	
	/**
     * BoldFaces all fields in fieldMap indicating fields with beginIndexes of their occurrences.
     * @param fieldMap fields as list of beginIndexes of their occurrences
     * @param text text of document to be parsed and applied IE
     * @return input text, with fields in boldface in HTML format
     */
	
	public String boldFace(Map<String, List<Integer>> occurenceMap, String text) {
		Map<Integer, Integer> indexMap = new TreeMap<Integer, Integer>();
		
		/** 
		 * indexes of fields in fieldMap are assigned as keys to indexMap and length of field as value.
		 * It will ease boldfacing. 
		 */
		occurenceMap.forEach((key,value) -> {
			value.forEach(index->indexMap.put(index,key.length()));
		});
		
		StringBuilder str = new StringBuilder("");
		int beginIndex = 0;
		
		// Boldfacing is applied according to key (index) and values (length) in indexMap
		for(int key:indexMap.keySet()) {
			str.append(text.substring(beginIndex,key) + "<b>" + text.substring(key,key + indexMap.get(key)) + "</b>");
			beginIndex = key + indexMap.get(key);
		}
		
		if(beginIndex<text.length())
			str.append(text.substring(beginIndex));
		
		String resultText = str.toString();
		
		// Add HTML tags if text isn't in HTML format
		if(resultText.indexOf("<HTML>") == -1)
			resultText = "<HTML>" + resultText;
		
		if(resultText.toUpperCase().indexOf("</HTML>") == -1)
			resultText += "</HTML>";
		
		return resultText;
	}
	
	/**
     * Extracts info from file in path to HTML file with same name in /output/ path.
     * Extracted fields are boldfaced in file and saved to /output/ directory.
     * @param fields to be extracted
     * @param filePath containing name of file to be parsed with its directory
     * @return String containing message about result of extraction and export to file
     */
	public String extractFromFile(List<String> fields, String filePath) {
		
		// validate filePath
		FileOperations file = new FileOperations();
		if(!file.read(filePath))
			return "Input file not found.";
		
		String text = file.getText();
		RabinKarpSearch search = new RabinKarpSearch(text);
		Map<String, List<Integer>> occurenceMap = new HashMap<String, List<Integer>>();
		
		// Begin indexes of fields are got via findAll method of RabinKarpSearch class and assigned to fieldMap
		fields.forEach(field-> {
			List<Integer> indexList = search.findAll(field);
			occurenceMap.put(field,indexList);
		});
		
		// Boldface text
		text = boldFace(occurenceMap,text);
		
		// Write into file with same name in html format and store in "/output/" directory
		String fileName = Paths.get(filePath).getFileName().toString();
		String outputPath = "output//"+fileName.substring(0,fileName.indexOf("."))+".html";
		
		if(file.exportToFile(text,outputPath))
			return "Fields extracted successfully and stored in " + outputPath + " file.";
		else return "Problem in generating output file.";
	}
	
}