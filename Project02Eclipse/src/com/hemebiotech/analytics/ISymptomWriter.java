package com.hemebiotech.analytics;

import java.util.List;

/**
 * Interface for writing symptom data to a file.
 * This interface defines methods for writing and recovering symptom data.
 * 
 */

public interface ISymptomWriter {
  /**
   * Writes symptoms data to a file.
   * 
   * @param symmptoms A list of Strings representing the symptoms.
   */

  void writeSymptomDataToFile(List<String> symptoms);

  /**
   * Recovers symptom data.
   * 
   * @return A list of strings recover symptom data
   */

  List<String> getSymptoms();

}
