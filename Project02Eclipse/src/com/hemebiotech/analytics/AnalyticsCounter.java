package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException; // Importe la classe pour gérer les exceptions d'entrée/sortie
import java.util.Map; // Importe la collection Map
import java.util.List; // Importe la collection List
import java.util.TreeMap;
import com.hemebiotech.analytics.ReadSymptomDataFromFile;
import com.hemebiotech.analytics.WriteSymptomDataToFile;


 public class AnalyticsCounter {
   
	private ISymptomReader symptomReader;
	private ISymptomWriter symptomWriter; 

	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.symptomReader = reader;
		this.symptomWriter = writer;
	       }
	
		public List<String> getSymptoms() {
		  return symptomReader.getSymptoms();
		}

			

    // Déclaration de la Map pour compter les occurrences de chaque symptomes
    public Map<String, Integer>countSymptoms(List<String> symptoms) {
		Map<String, Integer> symptomCounts = new TreeMap<>();
		for (String symptom : symptoms) {
			symptomCounts.put(symptom, symptomCounts.getOrDefault(symptom, 0) + 1);
			//Compter les occurences de chaque symptomes 
		}
		return symptomCounts;
	}

		

	
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		  return new TreeMap<>(symptoms);
		
	      }
		  public void writeSymptoms(Map<String, Integer> symptoms) {

	
		   // next generate output
		   // Ajouter le bloc try pour fermer la ressource FileWriter
		try(FileWriter writer = new FileWriter ("result.out")){
			
			// Écrivez les autres symptômes et leurs occurrences dans le fichier.
			for (String symptom : symptomList ) {
				writer.write(symptom +"\n");
				// Écrit le symptôme et le nombre d'occurrences dans le fichier "result.out".
				}
			
			// Ajouter le bloc catch pour gérer les exceptions au cas oú il y a une erreur.
			} catch (IOException e) {
			e.printStackTrace();
		} 
		 symptomWriter.writeSymptomDataToFile(symptoms);
		}
	
		public static void main(String args[]) throws Exception {

		    // first get input
		   // Ajouter le bloc try pour fermer la ressource BufferedReader
		    // Changement du chemin relatif du fichier texte "symptoms.txt"
			 
				 ISymptomReader reader =  new ReadSymptomDataFromFile ("/workspaces/Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application/Project02Eclipse/src/com/hemebiotech/analytics/symptoms.txt");
	             ISymptomWriter writer = new WriteSymptomDataToFile ("result.out");
			     AnalyticsCounter analyticsCounter = new AnalyticsCounter(reader, writer);
 
			       List<String> symptoms = reader.getSymptoms();
				   List<String> symptomsList = analyticsCounter.getSymptoms();
				   List<String> symptom = writer.getSymptoms();
				
				
				  }
				} 
			
	
 
 

 