package com.hemebiotech.analytics;

import java.util.List;

public interface ISymptomWriter {

    void writeSymptomDataToFile(List<String> symptoms);

    List<String> getSymptoms();
}
