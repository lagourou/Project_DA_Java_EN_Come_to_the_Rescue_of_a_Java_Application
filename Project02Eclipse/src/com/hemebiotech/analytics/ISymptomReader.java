package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.List;

/**
 * Reads symptom data from a source and returns a list of strings, possibly with
 * duplicates and unordered, or an empty list if no data is available.
 * 
 */
public interface ISymptomReader {
	/**
	 * If no data is available, return an empty List.
	 * 
	 * @return a raw listing of all Symptoms obtained from a data source, duplicates
	 *         are possible/probable.
	 * 
	 * @throws IOException If there is an I/O error while reading the file.
	 */
	List<String> getSymptoms() throws IOException;
}
