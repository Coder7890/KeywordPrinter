package keyword.processor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import keyword.util.Contants;

public class KeywordsService {
  File fileName;

  public KeywordsService(File fileName) {
    this.fileName = fileName;
  }

  protected List<String> generateKeywords(List<String> words) {
    List<String> primitiveKeywords = new ArrayList<String>();
    List<String> keywords = new ArrayList<String>();

    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
      String line;
      while ((line = br.readLine()) != null) {
         if (line.startsWith(Contants.HASH.getValue())) {
           continue;
         }

         String[] value = line.split(Contants.SPACE.getValue());
         if (value.length > 0) {
           if (value[1].equals(Contants.PERIOD.getValue())) {
             primitiveKeywords.add(value[0]);
           } else {
             keywords.add(value[0]);
           }
         }

      }
    } catch (FileNotFoundException e) {
      System.err.println("Unable to find the file:" + fileName);
    } catch (IOException e) {
      System.err.println("Unable to read the file" + fileName);
    }

    words.addAll(primitiveKeywords);
    words.addAll(keywords);

    return words;
  }
}
