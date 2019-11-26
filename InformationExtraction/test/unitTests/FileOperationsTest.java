package unitTests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import main.FileOperations;

class FileOperationsTest {
	final String filePath = "input//test.html";
	final String filePath2 = "input//test2.html";
	final String outputPathWithFile = "output//test.html";
	final String outputPathNewFile = "output//newFile.html";

	@Test
	void testReadFileCorrectContent() throws IOException {
		FileOperations file = new FileOperations();
		String actual = file.read(filePath);
		String expected="Patients with Lung cancer and alzheimer needs care. Lung cancer requires very special care";
		assertEquals(expected, actual);
	}
	
	@Test
	void testReadException() {
		FileOperations file = new FileOperations();

	    assertThrows(IOException.class, () -> {
	    	file.read("not_existing_file.html");
	    });
	}
	
	@Test
	void testExportToExistingFile() {
		String text = "Patients with Lung cancer and alzheimer needs care. Lung cancer requires very special care";
		FileOperations file = new FileOperations();
		boolean actual= file.exportToFile(text, outputPathWithFile);
		assertTrue(actual);
	}
	
	@Test
	void testExportLongerTestToNotExistingFile() throws IOException{
		String text = "Hyperthyroidism is the condition that occurs due to excessive production of thyroid hormone by the thyroid gland. Thyrotoxicosis is the condition that occurs due to excessive thyroid hormone of any cause and therefore includes hyperthyroidism. Some, however, use the terms interchangeably. Signs and symptoms vary between people and may include irritability, muscle weakness, sleeping problems, a fast heartbeat, heat intolerance, diarrhea, enlargement of the thyroid, hand tremor, and weight loss. Symptoms are typically less severe in the elderly and during pregnancy. An uncommon complication is thyroid storm in which an event such as an infection results in worsening symptoms such as confusion and a high temperature and often results in death. The opposite is hypothyroidism, when the thyroid gland does not make enough thyroid hormone.\r\n" + 
				"\r\n" + 
				"Graves' disease is the cause of about 50% to 80% of the cases of hyperthyroidism in the United States. Other causes include multinodular goiter, toxic adenoma, inflammation of the thyroid, eating too much iodine, and too much synthetic thyroid hormone. A less common cause is a pituitary adenoma. The diagnosis may be suspected based on signs and symptoms and then confirmed with blood tests. Typically blood tests show a low thyroid stimulating hormone (TSH) and raised T3 or T4. Radioiodine uptake by the thyroid, thyroid scan, and TSI antibodies may help determine the cause.\r\n" + 
				"\r\n" + 
				"Treatment depends partly on the cause and severity of disease. There are three main treatment options: radioiodine therapy, medications, and thyroid surgery. Radioiodine therapy involves taking iodine-131 by mouth which is then concentrated in and destroys the thyroid over weeks to months. The resulting hypothyroidism is treated with synthetic thyroid hormone. Medications such as beta blockers may control the symptoms, and anti-thyroid medications such as methimazole may temporarily help people while other treatments are having effect. Surgery to remove the thyroid is another option. This may be used in those with very large thyroids or when cancer is a concern. In the United States hyperthyroidism affects about 1.2% of the population. It occurs between two and ten times more often in women. Onset is commonly between 20 and 50 years of age. Overall the disease is more common in those over the age of 60 years.\r\n" + 
				"Hyperthyroidism may be asymptomatic or present with significant symptoms. Some of the symptoms of hyperthyroidism include nervousness, irritability, increased perspiration, heart racing, hand tremors, anxiety, difficulty sleeping, thinning of the skin, fine brittle hair, and muscular weakness—especially in the upper arms and thighs. More frequent bowel movements may occur, and diarrhea is common. Weight loss, sometimes significant, may occur despite a good appetite (though 10% of people with a hyperactive thyroid experience weight gain), vomiting may occur, and, for women, menstrual flow may lighten and menstrual periods may occur less often, or with longer cycles than usual.\r\n" + 
				"\r\n" + 
				"Thyroid hormone is critical to normal function of cells. In excess, it both overstimulates metabolism and disrupts the normal functioning of sympathetic nervous system, causing \"speeding up\" of various body systems and symptoms resembling an overdose of epinephrine (adrenaline). These include fast heart beat and symptoms of palpitations, nervous system tremor such as of the hands and anxiety symptoms, digestive system hypermotility, unintended weight loss, and (in \"lipid panel\" blood tests) a lower and sometimes unusually low serum cholesterol.\r\n" + 
				"\r\n" + 
				"Major clinical signs include weight loss (often accompanied by an increased appetite), anxiety, heat intolerance, hair loss (especially of the outer third of the eyebrows), muscle aches, weakness, fatigue, hyperactivity, irritability, high blood sugar,[citation needed] excessive urination, excessive thirst, delirium, tremor, pretibial myxedema (in Graves' disease), emotional lability, and sweating. Panic attacks, inability to concentrate, and memory problems may also occur. Psychosis and paranoia, common during thyroid storm, are rare with milder hyperthyroidism. Many persons will experience complete remission of symptoms 1 to 2 months after a euthyroid state is obtained, with a marked reduction in anxiety, sense of exhaustion, irritability, and depression. Some individuals may have an increased rate of anxiety or persistence of affective and cognitive symptoms for several months to up to 10 years after a euthyroid state is established.\r\n" + 
				"For patients with sustained forms of hyperthyroidism, such as Graves' disease or toxic nodular goiter, anti-thyroid medications are often used. The goal with this form of drug therapy is to prevent the thyroid from producing hormones.\r\n" + 
				"Two common drugs in this category are methimazole and propylthiouracil (PTU), both of which actually interfere with the thyroid gland's ability to make its hormones. The illustration shows that some hormone is made, but the thyroid becomes much less efficient. When taken faithfully, these drugs are usually very effective in controlling hyperthyroidism within a few weeks.\r\n" + 
				"Anti-thyroid drugs can have side effects such as rash, itching, or fever, but these are uncommon. Very rarely, patients treated with these medications can develop liver inflammation or a deficiency of white blood cells therefore, patients taking antithyroid drugs should be aware that they must stop their medication and call their doctor promptly if they develop yellowing of the skin, a high fever, or severe sore throat. The main shortcoming of antithyroid drugs is that the underlying hyperthyroidism often comes back after they are discontinued. For this reason, many patients with hyperthyroidism are advised to consider a treatment that permanently prevents the thyroid gland from producing too much thyroid hormone.\r\n" + 
				"\r\n" + 
				"Radioactive Iodine Treatment\r\n" + 
				"Radioactive iodine is the most widely-recommended permanent treatment of hyperthyroidism. This treatment takes advantage of the fact that thyroid cells are the only cells in the body which have the ability to absorb iodine. In fact, thyroid hormones are experts at doing just that.\r\n" + 
				"By giving a radioactive form of iodine, the thyroid cells which absorb it will be damaged or killed. Because iodine is not absorbed by any other cells in the body, there is very little radiation exposure (or side effects) for the rest of the body. Radioiodine can be taken by mouth without the need to be hospitalized. This form of therapy often takes one to two months before the thyroid has been killed, but the radioactivity medicine is completely gone from the body within a few days. The majority of patients are cured with a single dose of radioactive iodine.\r\n" + 
				"The only common side effect of radioactive iodine treatment is underactivity of the thyroid gland. The problem here is that the amount of radioactive iodine given kills too many of the thyroid cells so that the remaining thyroid does not produce enough hormone, a condition called hypothyroidism. There is no evidence that radioactive iodine treatment of hyperthyroidism causes cancer of the thyroid gland or other parts of the body, or that it interferes with a woman's chances of becoming pregnant and delivering a healthy baby in the future. It is also important to realize that there are different types of radioactive iodine (isotopes). The type used for thyroid scans (iodine scans) as shown in the picture below give up a much milder type of radioactivity which does not kill thyroid cells.\r\n" + 
				"\r\n" + 
				"Surgical Removal of the Gland or Nodule\r\n" + 
				"Solitary hot nodule of right thyroid lobe. Another permanent cure for hyperthyroidism is to surgically remove all or part. Surgery is not used as frequently as the other treatments for this disease. The biggest reason for this is that the most common forms of hyperthyroidism are a result of overproduction from the entire gland (Graves' disease) and the methods described above work quite well in the vast majority of cases.\r\n" + 
				"Although there are some Graves' disease patients who will need to have surgical removal of their thyroid (cannot tolerate medicines for one reason or another, or who refuse radioactive iodine), other causes of hyperthyroidism are better suited for surgical treatment earlier in the disease.\r\n" + 
				"One such case is illustrated here where a patient has hyperthyroidism due to a hot nodule in the lower aspect of the right thyroid lobe. Depending on the location of the nodule, the surgeon can remove the lower portion of the lobe as illustrated on the left, or he/she may need to remove the entire lobe which contains the hot nodule as shown in the second picture. This should provide a long term cure.\r\n" + 
				"Right thyroid lobectomy. Partial lobectomy for hot nodule.\r\n" + 
				"Concerns about long hospitalizations following thyroid surgery have been all but alleviated over the past few years since many surgeons are now sending their patients home the morning following surgery (23 hour stay). This, of course, depends on the underlying health of the patient and their age, among other factors. Some are even treating partial thyroidectomy as an out-patient procedure where healthy patients can be sent home a few hours after the surgery. Although most surgeons require that the patient be put to sleep for operations on the thyroid gland, a some are even removing one side of the gland under local anesthesia with the aid of IV sedation. These smaller operations tend to be associated with fewer complaints.\r\n" + 
				"";
		FileOperations file = new FileOperations();
		boolean actual= file.exportToFile(text, outputPathNewFile);
		assertTrue(actual);
		
		assertEquals(text,file.read(outputPathNewFile));
	}

	@Test
	void testExportToFileWrongDirectory() {
		String text = "test file content";
		FileOperations file = new FileOperations();
		boolean actual= file.exportToFile(text, "wrongdirectory/test");
		assertFalse(actual);
	}
}
