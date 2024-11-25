package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple brute force implementation of reading symptom data from a file.
 */

public class ReadSymptomDataFromFile implements ISymptomReader {

	private final String filepath;

	/**
	 * Constructs a ReadSymptomDataFromFile object.
	 * 
	 * @param filepath A path to file with symptom strings in it one per line.
	 */

	public ReadSymptomDataFromFile(String filepath) {
		this.filepath = filepath;
	}

	/**
	 * Reads symptoms from a file.
	 * 
	 * @return The list of results.
	 * @throws IOException If there is an I/O error while reading the file.
	 */

	@Override
	public List<String> getSymptoms() throws IOException {
		ArrayList<String> result = new ArrayList<>();

		if (filepath != null) {
			try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
				String line = reader.readLine();

				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
			}
		}
		return result;
	}
}
