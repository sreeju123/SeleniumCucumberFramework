package utils;

import enums.ConfigProperties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author Sreej
 */
public class ConfigFileReader {

    private static final Properties properties = new Properties();
    private static final Map<String, String> MAP = new HashMap<>();


    static {

        try (FileInputStream file = new FileInputStream("src/test/resources/config/config.properties")) {
            properties.load(file);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String get(ConfigProperties key) {
        return properties.getProperty(key.name().toLowerCase());
    }

}
