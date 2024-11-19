package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.util.List;
import java.io.IOException;

/**
 * Simple brute force implementation
 * 
 * 
 */

public class WriteSymptomDataToFile implements ISymptomWriter {

   @Override
   public void writeSymptomDataToFile(List<String> symptoms) {
      try (FileWriter writer = new FileWriter("result.out")) {
         for (String symptom : symptoms) {
            writer.write(symptom + "\n");
         }
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   @Override
   public List<String> getSymptoms() {
      return null;
   }
}
