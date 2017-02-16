package keyword.processor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseHelper {
  protected static Properties properties;
  protected static String inputFileDirectory;
  protected static String outputFileDirectory;

  static {
    properties = getProperties();
    inputFileDirectory = properties.getProperty("input.directory");
    outputFileDirectory = properties.getProperty("output.directory");
  }

  private static Properties getProperties() {
    Properties properties = new Properties();
    readPropertiesFromFile(properties);
    return properties;
  }

  private static void readPropertiesFromFile(Properties properties) {
    try {
      File configPropFile = new File("config.properties");
      FileInputStream inStream = new FileInputStream(configPropFile);
      properties.load(inStream);
      System.out.println("config.properties loaded");
      inStream.close();
    } catch (FileNotFoundException e) {
      System.out.println("config.properties file doesnot exist");
      return;
    } catch (IOException e) {
      throw new RuntimeException ("Error reading properties file: " + " config.properties", e);
    }
  }

}
