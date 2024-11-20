package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.util.List;
import java.io.IOException;

/**
 * Simple brute force implementation
 * Implements the ISymptomWriter interface
 * 
 */

public class WriteSymptomDataToFile implements ISymptomWriter {

   private String filepath;

   /**
    * Takes a list of symptoms and writes each symptom to a file named "result.out"
    * 
    * @param filepath a full or partial path to file with symptom strings in it,
    *                 one per line
    */

   public WriteSymptomDataToFile(String filepath) {
      this.filepath = filepath;
   }

   /**
    * Writes a list of symptoms to a file. Each symptom is written on e new line
    *
    *@param symptoms List of symptoms to write  to the file 
    */


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
