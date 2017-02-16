package keyword.processor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import keyword.util.Contants;

public class KeywordPrintDriver extends BaseHelper {
  private static String outputFileName;
  static KeywordsService kservice;

  public static void main(String[] args) {
    final File dir = new File(inputFileDirectory);

    for(final File fileName : dir.listFiles()) {
      kservice = new KeywordsService(fileName);
      System.out.println("Processing input file:" + fileName );
      List<String> words = new ArrayList<String>();
      kservice.generateKeywords(words);

    try {
      int index = fileName.getName().lastIndexOf(Contants.PERIOD.getValue());
      outputFileName = fileName.getName().substring(0, index) + "_output";
      PrintWriter outputFile = new PrintWriter(new FileWriter(outputFileDirectory + outputFileName + ".txt"));
      for (String word: words) {
        outputFile.print(word + Contants.SPACE.getValue());
      }

      System.out.println("Processed output written to file:" + (outputFileDirectory + outputFileName + ".txt"));

      outputFile.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  }

}
