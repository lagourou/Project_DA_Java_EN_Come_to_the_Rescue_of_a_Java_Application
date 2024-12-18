package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Simple brute force implementation of writing symptom data to a file.
 */

public class WriteSymptomDataToFile implements ISymptomWriter {

   private final  String filepath;

   /**
    * Constructs a WriteSymptomDataToFile object.
    *
    * @param filepath the path to the file where symptom data will be written.
    */

   public WriteSymptomDataToFile(String filepath) {
      this.filepath = filepath;
   }

   /**
    * Writes a list of symptoms to a file. Each symptom is written on new line.
    *
    * @param symptoms A list of symptoms to write to the file.
    */

   @Override
   public void writeSymptomDataToFile(List<String> symptoms) {
      try (FileWriter writer = new FileWriter(filepath)) {
         for (String symptom : symptoms) {
            writer.write(symptom + "\n");
         }
      } catch (IOException e) {
         System.out.println("Error message : " + e.getMessage());
      }
   }

   /**
    * This method is not implemented. Returns null.
    * 
    * @return null
    */
   @Override
   public List<String> getSymptoms() {
      return null;
   }
}
