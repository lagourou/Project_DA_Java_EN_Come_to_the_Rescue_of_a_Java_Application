package com.hemebiotech.analytics;


import java.util.List;



public interface ISymptomWriter {

    void writeSymptomDataToFile(List<String> Symptoms);

    List<String> getSymptoms ();
}

