package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException; //Importe la classe pour gérer les exceptions
import java.util.Map; //importer la collection Map
import java.util.HashMap; //importer la collection HashMap

 public class AnalyticsCounter {
	private static Map<String, Integer>symptomCounts = new HashMap<>(); 
	//Déclaration de la Map pour compter les occurrences de chaque symptomes.

	// initialize all counters to 0
	private static int headacheCount = 0;	
	private static int rashCount = 0;		
	private static int pupilCount = 0;		
	
	public static void main(String args[]) throws Exception {
		// first get input

		//Ajouter le bloc try pour fermer la ressource BufferedReader
		try(BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"))){
			
		String line = reader.readLine(); 
		
		while (line != null) {
			
			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headacheCount++;
				System.out.println("number of headaches: " + headacheCount);
			}
			else if (line.equals("rash")) {
				rashCount++;
				System.out.println("number of rash: " + rashCount);
                 //afficher le résultat du nombre de symptomes rash
			}
			else if (line.contains("pupils")) {
				pupilCount++;
				System.out.println("number of pupils: " + pupilCount);
                //afficher le résultat du nombre de symptomes rash

			} else {
				SymptomCounts.put(line, SymptomCounts.getOrDefault(line, 0) + 1);
				//Compte les occurences de symptomes autres que headache, rash et pupil
			}

			line = reader.readLine();	// get another symptom
		}
		//Ajouter le bloc catch pour gérer les exceptions au cas ou il y a une erreur.
	   } catch (IOException e) {
		e.printStackTrace();
	}
		// next generate output


		//Ajouter le bloc try pour fermer la ressource FileWriter
		try(FileWriter writer = new FileWriter ("result.out")){
	    writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		
		//Écrit les autres symptômes et leurs occurrences dans le fichier.
		for (Map.Entry<String, Integer> entry : symptomCounts.entrySet()) {
			writer.write(entry.getKey() + ":" + entry.getValue() +"\n");
		}
		
		//Ajouter le bloc catch pour gérer les exceptions au cas ou il y a une erreur.
	} catch (IOException e) {
		e.printStackTrace();
	} 
	}  
  
}
