package unitTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;

import main.Extract;

class ExtractTest {

	final String filePath = "input//test.html";
	final String outputPath1 = "output//test.html";
	final String outputPathNewFile = "output//newFile.html";

	@Test
	void testBoldFaceCorrectResults() {
		Map<String, List<Integer>> fieldMap = new HashMap<String, List<Integer>>();
		String[] diseases = new String[]{"lung cancer", "alzheimer"};
		
		List<Integer> indexList0 = new ArrayList<Integer>() {
			{
				add(15);
				add(53);
			}
		};
		
		List<Integer> indexList1 = new ArrayList<Integer>() {
			{
				add(31);
			}
		};
		
		fieldMap.put(diseases[0],indexList0);
		fieldMap.put(diseases[1],indexList1);
				
		
		String text = "A patient with lung cancer and alzheimer needs care. Lung cancer requires special care";
		Extract ie = new Extract();
		String actual = ie.boldFace(fieldMap,text);
		String expected = "<HTML>A patient with <b>lung cancer</b> and <b>alzheimer</b> needs care. <b>Lung cancer</b> requires special care</HTML>";
		assertEquals(expected, actual);
	}

	@Test
	void testExtractFromSmallFile() {
		List<String> fields = new ArrayList<String>() {
			{
				add("alzheimer");
				add("Lung cancer");
				add("Hepatit");
				add("Heart Disease");
			}
		};
		
		Extract ie = new Extract();
		String actual = ie.extractFromFile(fields, filePath);
		String  expected = "Fields extracted successfully and stored in " + outputPath1 + " file.";
		assertEquals(expected, actual);
	}

	@Test
	void testExtractFromLargerFile() {
		List<String> fields = new ArrayList<String>() {
			{
				add("Thyrotoxicosis");
				add("lobectomy");
				add("hyperthyroidism");
				add("Graves");
				add("anxiety");
				add("irritability");
				add("fever");
				add("blood cancer");
			}
		};
		
		Extract ie = new Extract();
		String actual = ie.extractFromFile(fields, outputPathNewFile);
		String  expected = "Fields extracted successfully and stored in " + outputPathNewFile + " file.";
		assertEquals(expected, actual);
	}

	@Test
	void testExtractFromFileNotFound() {
		List<String> fields = new ArrayList<String>() {
			{
				add("alzheimer");
				add("Lung cancer");
				add("Hepatit");
			}
		};
		
		Extract ie = new Extract();
		String actual = ie.extractFromFile(fields, "notExistingFolder" + filePath);
		String  expected = "File couldn't be read.";
		assertEquals(expected, actual);
	}
}
