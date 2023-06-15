package org.pingsafe.utils;

import java.util.HashMap;

public class HeaderGenerator {

    public static HashMap<String, String> getCustomerServiceHeader(){

        HashMap<String,String> headerMap = new HashMap<String, String>();
        headerMap.put("x-session-token","authorized-user");
        headerMap.put("user-agent", "anyHeader");

        return headerMap;

    }

    public static HashMap<String, String> getCustomerServiceHeader(String accessToken){

        HashMap<String,String> headerMap = new HashMap<String, String>();
        headerMap.put("x-session-token",accessToken);
        headerMap.put("user-agent", "anyHeader");

        return headerMap;

    }
}
