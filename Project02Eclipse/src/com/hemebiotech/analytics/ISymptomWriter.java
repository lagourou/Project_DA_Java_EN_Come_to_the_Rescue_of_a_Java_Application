package com.hemebiotech.analytics;

import java.util.List;
import java.io.IOException;

/**
 * Interface for writing symptom data to a file.
 * 
 * This interface defines methods for writing and recovering symptom data.
 * 
 */

public interface ISymptomWriter {
  /**
   * Writes symptoms data to a file.
   * Each symptom is expected to be written on a new line, that will be written to
   * the file.
   * 
   * @param symptoms A list of Strings representing the symptoms.
   * @throws IOException If there is an error writing to the file.
   */

  void writeSymptomDataToFile(List<String> symptoms) throws IOException;

  /**
   * Recovers symptom data from the file.
   * 
   * @return A list of strings recover symptom data.
   * @throws IOException If there is an error reading the file.
   */

  List<String> getSymptoms() throws IOException;

}
