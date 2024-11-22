package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.util.List;
import java.io.IOException;

/**
 * Simple brute force implementation of writing symptom data to a file.
 */

public class WriteSymptomDataToFile implements ISymptomWriter {

   private String filepath;

   /**
    * Constructs a WriteSymptomDataToFile object.
    * 
    * @param filepath A path to file with symptom strings in it one per line.
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
         e.printStackTrace();
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
