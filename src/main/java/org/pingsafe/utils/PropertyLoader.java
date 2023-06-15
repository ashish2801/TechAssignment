package org.pingsafe.utils;

import java.io.*;
import java.util.Properties;

public class PropertyLoader {


    /**Generic Method for loading any property file as specified by the 'filePath' **/
    public static Properties loadProperty(String filePath){
        Properties properties = new Properties();
        BufferedReader reader;


        try {
            reader = new BufferedReader(new FileReader(filePath));

            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Failed to load Property. Failure in reading property file");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load Property. Property file not found");
        }

        return properties;

    }
}
