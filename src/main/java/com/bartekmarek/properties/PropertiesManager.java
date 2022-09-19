package com.bartekmarek.properties;

import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class PropertiesManager {
    private final static String PROPERTIES_FILE_PATH = "src/main/resources/routes.properties";
    private final static Properties properties= new Properties();

    public static synchronized String getBaseUrl() {
        return loadPropertiesFile().getProperty("baseUrl");
    }

    @SneakyThrows
    private static Properties loadPropertiesFile() {
        FileInputStream in = new FileInputStream(PROPERTIES_FILE_PATH);
        properties.load(in);
        in.close();
        return properties;
    }

    @SneakyThrows
    private void saveProperty(String key, String value) {
        FileOutputStream out = new FileOutputStream(PROPERTIES_FILE_PATH);
        properties.setProperty(key, value);
        properties.store(out, null);
        out.close();
    }
}
