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

public class AnalyticsCounter {

	private ISymptomReader reader;
	private ISymptomWriter writer;

	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;

	}

	public List<String> getSymptoms() {
		return reader.getSymptoms();
	}

	public Map<String, Integer> countSymptoms(List<String> symptoms) {

		Map<String, Integer> symptomCounts = new HashMap<>();
		// Déclaration de la Map pour compter les occurrences de chaque symptomes.
		for (String symptom : symptoms) {
			symptomCounts.put(symptom, symptomCounts.getOrDefault(symptom, 0) + 1);
		}
		return symptomCounts;
	}

	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {

		return new TreeMap<>(symptoms);
	}

	public void writeSymptoms(Map<String, Integer> symptoms) {
		List<String> dataToWrite = new ArrayList<>();
		for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
			String symptomData = entry.getKey() + ":" + entry.getValue();

			dataToWrite.add(symptomData);
		}
		writer.writeSymptomDataToFile(dataToWrite);
	}

	public static void main(String args[]) throws Exception {
		Map<String, Integer> symptomCounts = new HashMap<>();

		// first get input
		// Ajouter le bloc try pour fermer la ressource BufferedReader
		// Changement du chemin relatif du fichier texte "symptoms.txt"
		try (BufferedReader reader = new BufferedReader(new FileReader(
				"/workspaces/Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application/Project02Eclipse/src/com/hemebiotech/analytics/symptoms.txt"))) {

			String line = reader.readLine();

			while (line != null) {

				symptomCounts.put(line, symptomCounts.getOrDefault(line, 0) + 1);
				// Compter les occurences de chaque symptomes
				line = reader.readLine(); // get another symptom

			}

		}
		// Ajouter le bloc catch pour gérer les exceptions au cas oú il y a une erreur.
		catch (IOException e) {
			e.printStackTrace();
		}

		AnalyticsCounter counter = new AnalyticsCounter(null, null);
		Map<String, Integer> sortedSymptoms = counter.sortSymptoms(symptomCounts);

		// next generate output
		// Ajouter le bloc try pour fermer la ressource FileWriter
		try (FileWriter writer = new FileWriter("result.out")) {

			// Écrivez les autres symptômes et leurs occurrences dans le fichier.
			for (Map.Entry<String, Integer> entry : sortedSymptoms.entrySet()) {
				writer.write(entry.getKey() + ":" + entry.getValue() + "\n");
				// Écrit le symptôme et le nombre d'occurrences dans le fichier "result.out".
			}

			// Ajouter le bloc catch pour gérer les exceptions au cas oú il y a une erreur.
		} catch (IOException e) {
			e.printStackTrace();
		}
		sortedSymptoms.forEach((key, value) -> System.out.println(key + ":" + value));
		// affiche chaque symptôme et le nombre d'occurrences
	}

}
