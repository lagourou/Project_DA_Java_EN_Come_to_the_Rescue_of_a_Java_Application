package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.util.List;
import java.io.IOException;

/**
 * Simple brute force implementation
 * 
 */

public class WriteSymptomDataToFile implements ISymptomWriter {

   private String filepath;

   /**
    * Takes a list of symptoms and writes each symptom to a file named
    * "result.out"
    * 
    * @param filepath a full or partial path to file with symptom strings in it,
    *                 one per line
    */

   public WriteSymptomDataToFile(String filepath) {
      this.filepath = filepath;
   }

   @Override
   public void writeSymptomDataToFile(List<String> symptoms) {
      try (FileWriter writer = new FileWriter(filepath)) {
         for (String symptom : symptoms) {
            writer.write(symptom + "\n");
         }
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   /**
    * @return null
    */
   @Override
   public List<String> getSymptoms() {
      return null;
   }
}
