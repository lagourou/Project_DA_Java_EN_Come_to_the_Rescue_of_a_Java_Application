package com.hemebiotech.analytics;


import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;



public class WriteSymptomDataToFile implements ISymptomWriter {
   private String filepath;
   public writeSymptomDataToFile(String filepath) {
          this.filepath = filepath;
   }
   @Override
   public void writeSymptomDataToFile (List<String> symptoms) {
           try (FileWriter writer = new FileWriter(filepath)) {
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


    
    
    



