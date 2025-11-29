package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

//Class for Property file reading
public class ReadPropertyFile {

    private static Properties prop = new Properties();

    public static Properties readProperties(String filePath) {
        try (FileInputStream file = new FileInputStream(filePath)) {
            prop.load(file);
            return prop;
        } catch (IOException e) {
            throw new RuntimeException("Can't open properties file, check file location:\n" + filePath + "\n" + e);
        }

    }
}
