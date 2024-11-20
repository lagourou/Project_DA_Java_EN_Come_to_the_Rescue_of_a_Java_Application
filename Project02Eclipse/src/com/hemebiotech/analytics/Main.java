package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry; // Importe la collection Map.Entry

/**
 *Main Class to run the AnalyticsCounter application
 */

public class Main {

  /**
   * Main method to run the application
   * 
   * @param args Command Line Arguments
   * @throws IOException if there is an I/O error 
   */

  public static void main(String[] args) throws IOException {

    ISymptomReader readSymptomDataFromFile = new ReadSymptomDataFromFile(
        "/workspaces/Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application/Project02Eclipse/src/com/hemebiotech/analytics/symptoms.txt");
    ISymptomWriter writeSymptomDataFromFile = new WriteSymptomDataToFile(
        "/workspaces/Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application/Project02Eclipse/src/result.out");
    AnalyticsCounter analyticsCounter = new AnalyticsCounter(readSymptomDataFromFile, writeSymptomDataFromFile);

    List<String> symptoms = analyticsCounter.getSymptoms();
    Map<String, Integer> symptomCounts = analyticsCounter.countSymptoms(symptoms);
    Map<String, Integer> sortedSymptoms = analyticsCounter.sortSymptoms(symptomCounts);

    List<String> symptomsList = new ArrayList<>();
    for (Entry<String, Integer> entry : sortedSymptoms.entrySet()) {
      symptomsList.add(entry.getKey() + ":" + entry.getValue());
    }
    writeSymptomDataFromFile.writeSymptomDataToFile(symptomsList);
  }
}