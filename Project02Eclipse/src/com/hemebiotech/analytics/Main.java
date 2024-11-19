package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main (String[] args) throws IOException {

          SymptomReader readSymptomDataFromFile = new SymptomReader("/workspaces/Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application/Project02Eclipse/src/com/hemebiotech/analytics/symptoms.txt");
          SymptomWriter writeSymptomDataFromFile = new SymptomWriter("/workspaces/Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application/Project02Eclipse/src/result.out");
          AnalyticsCounter analyticsCounter = new AnalyticsCounter(readSymptomDataFromFile, writeSymptomDataFromFile);

            List<String> symptoms = analyticsCounter.getSymptoms();
            Map<String, Integer> symptomCounts = AnalyticsCounter.countSymptoms();
            Map<String, Integer> sortedSymptoms  = AnalyticsCounter.sortSymptoms();
             
            analyticsCounter.writeSymptoms(sortedSymptoms);
    }
}