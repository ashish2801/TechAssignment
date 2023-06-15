package org.pingsafe.utils;

import java.io.File;

public class FileUtils {

    /** Method for cleaning past report dumps **/
    public static void deletePastAllureReports(){
        String reportDirectoryPath = System.getProperty("user.dir")+"/target"+File.separator+"allure-results";

        File reportDirectory = new File(reportDirectoryPath);
        if (reportDirectory.exists()) {
            deleteDirectory(reportDirectory);
        }
    }

    private static void deleteDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    deleteDirectory(file);
                } else {
                    file.delete();
                }
            }
        }
    }

    }

