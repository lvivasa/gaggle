package com.gaggle.sdetassesment.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static java.lang.String.format;
import static java.lang.System.getProperty;

@Slf4j
public class ConfigureProperties {
    public static String getProperty(String propertyName) {
        Properties properties = new Properties();
        try {
            InputStream inputStream = new FileInputStream("configuration.properties");
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty(propertyName);
    }
}
