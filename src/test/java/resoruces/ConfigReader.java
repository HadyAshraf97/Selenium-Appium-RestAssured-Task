package resoruces;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties = new Properties();

    static {

        String configFilePath = System.getProperty("user.dir") + "/src/test/java/resoruces/config.properties";
        try (InputStream input = new FileInputStream(configFilePath)) {
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Failed to load config properties file");
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
