package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * The main class to run the AnalyticsCounter application.
 * 
 * This class is responsible for reading symptom data from a file, counting the
 * occurrences
 * of each symptom, sorting them alphabetically, and writing the results to an
 * output file.
 */

public class Main {

  /**
   * Default constructor for the Main class.
   * This constructor initializes the Main class but does not perform any actions.
   * It is used to create an instance of the Main class.
   * 
   */

  public Main() {
    // Constructor is intentionally left empty.
  }

  /**
   * Entry point of the application.
   * 
   * Initializes the components to read symptoms from a file, count their
   * occurrences,
   * sort them, and write the results to an output file.
   * 
   * @param args Command Line Arguments.
   * @throws IOException If there is an I/O error while reading the file.
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
    for (String symptom : sortedSymptoms.keySet()) {
      symptomsList.add(symptom + ":" + sortedSymptoms.get(symptom));
    }
    writeSymptomDataFromFile.writeSymptomDataToFile(symptomsList);
  }
}