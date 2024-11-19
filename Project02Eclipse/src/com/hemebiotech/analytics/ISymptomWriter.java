package com.hemebiotech.analytics;

import java.util.List;

/**
 * Anything that allows write symptom data from a source
 * An interface for writing symptom data to a file 
 * 
 */


public interface ISymptomWriter {
     /** 
      * Writes symptoms data to a file
      * @param symmptoms a List of Strings representing the symptoms
      */

    void writeSymptomDataToFile(List<String> symptoms);
    /**
     * recover symptom data
     * @return a List of strings recover symptom data
     */
    
    List<String> getSymptoms();
    
}
