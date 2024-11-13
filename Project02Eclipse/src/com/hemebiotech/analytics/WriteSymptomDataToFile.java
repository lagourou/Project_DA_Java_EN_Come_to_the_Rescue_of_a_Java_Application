package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;



public class WriteSymptomDataToFile implements ISymptomWriter {

   
   private String filepath;

   public WriteSymptomDataToFile(String filepath) {
    		 

        this.filepath = filepath;
   }
 public List<String> GetSymptoms() {
    ArrayList<String> result = new ArrayList<String>();

    if (filepath != null) {
        try(BufferedWriter writer = new BufferedWriter (new FileWriter(filepath))){
            String line = writer.writeLine();
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
    return result;
 }

}
