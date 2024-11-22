package com.hemebiotech.analytics;

import java.util.List; // Imports the List collection 
import java.util.ArrayList; // Imports the ArrayList collection ArrayList
import java.util.Map; // Imports the Map collection 
import java.util.TreeMap; // Imports the TreeMap collection 
import java.util.HashMap; // Imports the HashMap collection 
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException; // Imports the class for managing input/output exceptions

/**
 * The AnalyticsCounter class analyses symptom data.
 */

public class AnalyticsCounter {

	private final ISymptomReader reader;
	private final ISymptomWriter writer;

	/**
	 * Constructs an AnalyticsCounter object.
	 * 
	 * @param reader A symptom-reader object.
	 * @param writer A symptom-writer object.
	 */

	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;

	}

	/**
	 * Retieves a list of symptom.
	 * 
	 * @return A list of symptoms.
	 */

	public List<String> getSymptoms() {
		return reader.getSymptoms();
	}

	/**
	 * Counts the number of occurrences of each symptom.
	 * 
	 * @param symptoms A list of symptom.
	 * @return A map with symptoms as keys and their counts as values.
	 */

	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		// Declaration of HashMap to store symptom names and their occurrences.
		Map<String, Integer> symptomCounts = new HashMap<>();
		for (String symptom : symptoms) {
			symptomCounts.put(symptom, symptomCounts.getOrDefault(symptom, 0) + 1);
		}
		return symptomCounts;
	}

	/**
	 * Sorts the list of symptoms and occurrences in alphabetical order.
	 * 
	 * @param symptoms A map of symptom.
	 * @return A map with symptoms sorted in alphabetical order.
	 */

	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		// TreeMap maintains ascending key order.
		return new TreeMap<>(symptoms);
	}

	/**
	 * Writes symptom data in a file.
	 * 
	 * @param symptoms A map of symptom.
	 */

	public void writeSymptoms(Map<String, Integer> symptoms) {

		// Takes a map of symptoms and their occurrences converts to a strings.
		List<String> dataToWrite = new ArrayList<>();
		for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
			String symptomData = entry.getKey() + ":" + entry.getValue();
			dataToWrite.add(symptomData);
		}
		writer.writeSymptomDataToFile(dataToWrite);
	}

	/**
	 * The main method that runs the program.
	 * 
	 * @param args Command Line Arguments.
	 * @throws Exception If there is an I/O error.
	 */
	public static void main(String args[]) throws Exception {
		Map<String, Integer> symptomCounts = new HashMap<>();

		// Read symptoms from a text file.
		try (BufferedReader reader = new BufferedReader(new FileReader(
				"/workspaces/Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application/Project02Eclipse/src/com/hemebiotech/analytics/symptoms.txt"))) {
			String line = reader.readLine();
			while (line != null) {
				symptomCounts.put(line, symptomCounts.getOrDefault(line, 0) + 1);
				line = reader.readLine(); // Get another symptom.
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		AnalyticsCounter counter = new AnalyticsCounter(null, null);
		Map<String, Integer> sortedSymptoms = counter.sortSymptoms(symptomCounts);

		// Write sorted result to a file
		try (FileWriter writer = new FileWriter("result.out")) {
			for (Map.Entry<String, Integer> entry : sortedSymptoms.entrySet()) {
				writer.write(entry.getKey() + ":" + entry.getValue() + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Display result
		sortedSymptoms.forEach((key, value) -> System.out.println(key + ":" + value));
	}
}
