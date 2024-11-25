package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.List;

/**
 * Writes symptom data to a file, with each symptom on a new line, accepts a
 * list of strings representing the symptoms, and has a method to retrieve
 * symptom data from the file, returning a list of strings.
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
