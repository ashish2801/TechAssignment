package org.pingsafe.utils;

import com.github.javafaker.Faker;

public class FakerUtils {

    /**Generic Method for generating random Numbers**/
    public static String generateRandomNumberOfLength(int length){
        Faker faker = new Faker();
        return faker.regexify("\\d{" + length + "}");
    }

    /**Generic Method for generating random String**/
    public static String generateRandomStringOfLength(int length){
        Faker faker = new Faker();
        return faker.regexify("[a-zA-Z]{" + length + "}");
    }

}
