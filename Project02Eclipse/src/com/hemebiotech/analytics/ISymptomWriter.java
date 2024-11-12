package com.hemebiotech.analytics;


import java.util.List;



public interface ISymptomWriter {

    void WriteSymptomDataToFile(List<String> Symptoms);

    List<String> getSymptoms ();
}

