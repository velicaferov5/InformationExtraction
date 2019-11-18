package unitTests;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import main.RabinKarpSearch;

class RabinCarpTest {

	@Test
	void testFindNoOccurence() {
		RabinKarpSearch search = new RabinKarpSearch("ooooaaks kdfjasds djjaa");
		int actual = search.findFromIndex(0, "abc");
		int expected = -1;
		assertEquals(expected, actual);
	}

	@Test
	void testFindFromBeginning() {
		RabinKarpSearch search = new RabinKarpSearch("aaabc svabca");
		int actual = search.findFromIndex(0, "abc");
		int expected = 2;
		assertEquals(expected, actual);
	}

	@Test
	void testFindAtIndex() {
		RabinKarpSearch search = new RabinKarpSearch("aaabcabca");
		int actual = search.findFromIndex(4, "abc");
		int expected = 5;
		assertEquals(expected, actual);
	}

	@Test
	void testFindOnLargerText() {
		RabinKarpSearch search = new RabinKarpSearch("Hyperthyroidism is the condition that occurs due to excessive production of thyroid hormone by the thyroid gland. Thyrotoxicosis is the condition that occurs due to excessive thyroid hormone of any cause and therefore includes hyperthyroidism. Some, however, use the terms interchangeably. Signs and symptoms vary between people and may include irritability, muscle weakness, sleeping problems, a fast heartbeat, heat intolerance, diarrhea, enlargement of the thyroid, hand tremor, and weight loss. Symptoms are typically less severe in the elderly and during pregnancy. An uncommon complication is thyroid storm in which an event such as an infection results in worsening symptoms such as confusion and a high temperature and often results in death. The opposite is hypothyroidism, when the thyroid gland does not make enough thyroid hormone.\r\n" + 
				"\r\n" + 
				"Graves' disease is the cause of about 50% to 80% of the cases of hyperthyroidism in the United States. Other causes include multinodular goiter, toxic adenoma, inflammation of the thyroid, eating too much iodine, and too much synthetic thyroid hormone. A less common cause is a pituitary adenoma. The diagnosis may be suspected based on signs and symptoms and then confirmed with blood tests. Typically blood tests show a low thyroid stimulating hormone (TSH) and raised T3 or T4. Radioiodine uptake by the thyroid, thyroid scan, and TSI antibodies may help determine the cause.\r\n" + 
				"\r\n" + 
				"");
		int actual = search.findFromIndex(0, "hyperthyroidism");
		int expected = 227;
		assertEquals(expected, actual);
	}
	

	@Test
	void testFindOnLargerTextFromSpecificIndex() {
		RabinKarpSearch search = new RabinKarpSearch("Hyperthyroidism is the condition that occurs due to excessive production of thyroid hormone by the thyroid gland. Thyrotoxicosis is the condition that occurs due to excessive thyroid hormone of any cause and therefore includes hyperthyroidism. Some, however, use the terms interchangeably. Signs and symptoms vary between people and may include irritability, muscle weakness, sleeping problems, a fast heartbeat, heat intolerance, diarrhea, enlargement of the thyroid, hand tremor, and weight loss. Symptoms are typically less severe in the elderly and during pregnancy. An uncommon complication is thyroid storm in which an event such as an infection results in worsening symptoms such as confusion and a high temperature and often results in death. The opposite is hypothyroidism, when the thyroid gland does not make enough thyroid hormone. Graves' disease is the cause of about 50% to 80% of the cases of hyperthyroidism in the United States.\r\n" + 
				"\r\n" + 
				"");
		int actual = search.findFromIndex(900, "hyperthyroidism");
		int expected = 909;
		assertEquals(expected, actual);
	}

	@Test
	void testFindAllNoOccurence() {
		RabinKarpSearch search = new RabinKarpSearch("jddd jsabls");
		List<Integer> actual = search.findAll("abc");
		List<Integer> expected = Arrays.asList();
		assertThat(actual,is(expected));
	}

	@Test
	void testFindAllShortCorrectResult() {
		RabinKarpSearch search = new RabinKarpSearch("aaabc cabca");
		List<Integer> actual = search.findAll("abc");
		List<Integer> expected = Arrays.asList(2, 7);
		assertThat(actual,is(expected));
	}
	
	@Test
	void testFindAllLongerCorrectResult() {
		RabinKarpSearch search = new RabinKarpSearch("aaabcaaaabababbba ccbabcabca abcaaaabc");
		List<Integer> actual = search.findAll("abc");
		List<Integer> expected = Arrays.asList(2, 21, 24, 29, 35);
		assertThat(actual,is(expected));
	}
	
	@Test
	void testFindAllResultSize() {
		RabinKarpSearch search = new RabinKarpSearch("Hyperthyroidism is the condition that occurs due to excessive production of thyroid hormone by the thyroid gland. Thyrotoxicosis is the condition that occurs due to excessive thyroid hormone of any cause and therefore includes hyperthyroidism. Some, however, use the terms interchangeably. Signs and symptoms vary between people and may include irritability, muscle weakness, sleeping problems, a fast heartbeat, heat intolerance, diarrhea, enlargement of the thyroid, hand tremor, and weight loss. Symptoms are typically less severe in the elderly and during pregnancy. An uncommon complication is thyroid storm in which an event such as an infection results in worsening symptoms such as confusion and a high temperature and often results in death. The opposite is hypothyroidism, when the thyroid gland does not make enough thyroid hormone. Graves' disease is the cause of about 50% to 80% of the cases of hyperthyroidism in the United States. Other causes include multinodular goiter, toxic adenoma, inflammation of the thyroid, eating too much iodine, and too much synthetic thyroid hormone. A less common cause is a pituitary adenoma. The diagnosis may be suspected based on signs and symptoms and then confirmed with blood tests. Typically blood tests show a low thyroid stimulating hormone (TSH) and raised T3 or T4. Radioiodine uptake by the thyroid, thyroid scan, and TSI antibodies may help determine the cause.\r\n" + 
				"\r\n" + 
				"");
		List<Integer> actualIndexList = search.findAll("hyperthyroidism");
		int expected = 2;
		assertEquals(actualIndexList.size(),expected);
	}
}
