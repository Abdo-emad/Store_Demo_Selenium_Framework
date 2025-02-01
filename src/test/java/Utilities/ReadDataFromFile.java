package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromFile {


    public static String ReadDataFromPropFile(String key) throws IOException {
        Properties properties = new Properties();
        String path = System.getProperty("user.dir")+"./src/main/resources/get.properties";
        FileInputStream fileInputStream = new FileInputStream(path);
        properties.load(fileInputStream);
        return properties.getProperty(key);
    }
}
