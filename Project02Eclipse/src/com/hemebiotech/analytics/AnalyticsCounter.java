package com.hemebiotech.analytics;

import java.util.List; // Importe la collection List
import java.util.ArrayList; // Importe la collection ArrayList
import java.util.Map; // Importe la collection Map
import java.util.TreeMap; // Importe la collection TreeMap
import java.util.HashMap; // Importe la collection HashMap
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException; // Importe la classe pour gérer les exceptions d'entrée/sortie

/**
 * AnalyticsCounter Class analyse symptom data
 */

public class AnalyticsCounter {

	private ISymptomReader reader;
	private ISymptomWriter writer;

	/**
	 *
	 * @param reader
	 * @param writer
	 */

	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;

	}

	/**
	 * 
	 * getSymptoms method of the reader to retieve a list of symptom
	 * 
	 * @return List of symptoms
	 * 
	 */

	public List<String> getSymptoms() {
		return reader.getSymptoms();
	}

	/**
	 * 
	 * @param symptoms List of symptom
	 *                 countSymptoms method counts the number of occurrences of each
	 *                 symptom
	 *                 HashMap to store the number of each symptom
	 * @return Map with symptoms as keys and their counts as values
	 * 
	 */

	public Map<String, Integer> countSymptoms(List<String> symptoms) {

		Map<String, Integer> symptomCounts = new HashMap<>();
		// Déclaration de la Map pour compter les occurrences de chaque symptomes.
		for (String symptom : symptoms) {
			symptomCounts.put(symptom, symptomCounts.getOrDefault(symptom, 0) + 1);
		}
		return symptomCounts;
	}

	/**
	 * 
	 * @param symptoms List of symptom
	 *                 sortSymptoms method sorts the list of symptoms and
	 *                 occurrences alphabetically
	 *                 TreeMap maintains ascending key order
	 * @return Map with symptoms in alphabetical order
	 */

	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {

		return new TreeMap<>(symptoms);
	}

	/**
	 * 
	 * @param symptoms List of symptom
	 *                 Takes a map of symptoms and their occurrences converts to a
	 *                 strings
	 *                 writeSymptoms method write symptom data in a file
	 * 
	 */

	public void writeSymptoms(Map<String, Integer> symptoms) {
		List<String> dataToWrite = new ArrayList<>();
		for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
			String symptomData = entry.getKey() + ":" + entry.getValue();

			dataToWrite.add(symptomData);
		}
		writer.writeSymptomDataToFile(dataToWrite);
	}

	/**
	 * Main method that runs the programm
	 * It reads symptoms from a file, counts their occurrences
	 * sorts them alphabeticelly and writes the results to a file
	 * 
	 * 
	 * @param args Command Line Arguments
	 * @throws Exception if there is an I/O error
	 */

	public static void main(String args[]) throws Exception {
		Map<String, Integer> symptomCounts = new HashMap<>();

		// Première étape: lire les symptômes à partir d'un fichier texte
		try (BufferedReader reader = new BufferedReader(new FileReader(
				"/workspaces/Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application/Project02Eclipse/src/com/hemebiotech/analytics/symptoms.txt"))) {

			String line = reader.readLine();

			while (line != null) {

				// Compter les occurences de chaque symptôme
				symptomCounts.put(line, symptomCounts.getOrDefault(line, 0) + 1);
				line = reader.readLine(); // get another symptom
			}
		}
		// Gérer les exceptions en cas d'erreur d'entrée/sortie
		catch (IOException e) {
			e.printStackTrace();
		}
		AnalyticsCounter counter = new AnalyticsCounter(null, null);
		// Trier les symptômes par ordre alphabétique
		Map<String, Integer> sortedSymptoms = counter.sortSymptoms(symptomCounts);

		// Générer la sortie : écrire les résultats triés dans un fichier
		try (FileWriter writer = new FileWriter("result.out")) {
			// Écrire chaque symptôme et leurs nombre d'occurrences dans le fichier.
			for (Map.Entry<String, Integer> entry : sortedSymptoms.entrySet()) {
				writer.write(entry.getKey() + ":" + entry.getValue() + "\n");
			}
			// Gérer les exceptions en cas d'erreur d'entrée/sortie
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Affiche chaque symptôme et le nombre d'occurrences
		sortedSymptoms.forEach((key, value) -> System.out.println(key + ":" + value));
	}
}
