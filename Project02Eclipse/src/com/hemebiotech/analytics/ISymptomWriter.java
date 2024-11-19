package com.hemebiotech.analytics;

import java.util.List;

/**
 * Anything that allows write symptom data from a source
 * An interface for writing symptom data to a file 
 * 
 */


public interface ISymptomWriter {


    void writeSymptomDataToFile(List<String> symptoms);
    /**
     * 
     * @return a List of strings recover symptom data
     */
    
    List<String> getSymptoms();
    
}
