package io.techleadacademy.utils;

import org.junit.Assert;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
//    public static String readProperty(String property) {
//        Properties prop;
//        FileInputStream fileInput;
//
//        try {
//            fileInput = new FileInputStream("config-local.properties");
//            prop = new Properties();
//            prop.load(fileInput);
//
//            if (prop.getProperty(property) == null){
//                try {
//                    fileInput = new FileInputStream("config.properties");
//                    prop = new Properties();
//                    prop.load(fileInput);
//                } catch (IOException ex) {
//                    throw new RuntimeException(ex);
//                }
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        return prop.getProperty(property);
//    }

    public static String readProperty(String property) {
        switch (property) {
            case "username-student":
                return System.getenv("STUDENT_USR") != null ? System.getenv("STUDENT_USR") : new ConfigReader().getPropertyFromFile(property);
            case "password-student":
                return System.getenv("STUDENT_PSW") != null ? System.getenv("STUDENT_PSW") : new ConfigReader().getPropertyFromFile(property);
            default:
                return new ConfigReader().getPropertyFromFile(property);
        }
    }

    private String getPropertyFromFile(String property) {
        Properties prop;
        FileInputStream fileInput;

        try {
            fileInput = new FileInputStream("config-local.properties");
            prop = new Properties();
            prop.load(fileInput);

            if (prop.getProperty(property) == null){
                try {
                    fileInput = new FileInputStream("config.properties");
                    prop = new Properties();
                    prop.load(fileInput);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return prop.getProperty(property);
    }


}
