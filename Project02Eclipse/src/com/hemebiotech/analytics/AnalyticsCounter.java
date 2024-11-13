package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException; // Importe la classe pour gérer les exceptions
import java.util.Map; // Importe la collection Map
import java.util.TreeMap; // Importe la collection TreeMap

 public class AnalyticsCounter {

	
	private static Map<String, Integer>SymptomCounts = new TreeMap<>(); 
	// Déclaration de la Map pour compter les occurrences de chaque symptomes.

		
	
	public static void main(String args[]) throws Exception {
		// first get input
		

		// Ajouter le bloc try pour fermer la ressource BufferedReader
		// Changement du chemin relatif du fichier texte "symptoms.txt"
		try(BufferedReader reader = new BufferedReader (new FileReader("/workspaces/Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application/Project02Eclipse/src/com/hemebiotech/analytics/symptoms.txt"))){
			
		String line = reader.readLine(); 
		
		while (line != null) {
			SymptomCounts.put(line, SymptomCounts.getOrDefault(line, 0) + 1);
                //Compter les occurences de symptomes autres que headache, rash et pupil
				}

			line = reader.readLine();	// get another symptom
			}
		// Ajouter le bloc catch pour gérer les exceptions au cas ou il y a une erreur.
	    catch (IOException e) {
		e.printStackTrace();
	      }
		// next generate output


		// Ajouter le bloc try pour fermer la ressource FileWriter
		try(FileWriter writer = new FileWriter ("result.out")){
			
	    
			
		//Écrivez les autres symptômes et leurs occurrences dans le fichier.
		for (Map.Entry<String, Integer> entry : SymptomCounts.entrySet()) {
			writer.write(entry.getKey() + ":" + entry.getValue() +"\n");
		}
		
		// Ajouter le bloc catch pour gérer les exceptions au cas oú il y a une erreur.
	} catch (IOException e) {
		e.printStackTrace();
	} 
	SymptomCounts.forEach((key, value) -> System.out.println(key + ":" + value));

	}  
  
}
