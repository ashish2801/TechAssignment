package org.pingsafe.utils;

import java.io.File;
import java.util.Properties;

public class ConfigLoader {

    /**Generic Class to load properties from the file Config.properties**/

    private  static ConfigLoader configLoader;
    private  final  Properties properties;

    private ConfigLoader(){
        properties = PropertyLoader.loadProperty(System.getProperty("user.dir")+"/src"+File.separator+"main"+File.separator+"resources"+File.separator+"config.properties");
    }

    /**SingleTon Design Pattern**/
    public static ConfigLoader getInstance(){
        if(configLoader==null)
            configLoader= new ConfigLoader();

        return configLoader;
    }


    public String getBaseURL(){
        String baseURL = properties.getProperty("api.basePath");
        if(baseURL!=null) return baseURL;
        else
            throw new RuntimeException("Property baseURL is not specified in config.properties");
    }

    public String getDatabasePath(){
        String baseURL = properties.getProperty("database.Path");
        if(baseURL!=null) return baseURL;
        else
            throw new RuntimeException("Property database.Path is not specified in config.properties");
    }


    public String getRetryFailedCases(){
        String baseURL = properties.getProperty("retry_failed_tests");
        if(baseURL!=null) return baseURL;
        else
            throw new RuntimeException("Property retry_failed_tests is not specified in config.properties");
    }




}
