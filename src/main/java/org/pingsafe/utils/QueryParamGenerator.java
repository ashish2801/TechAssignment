package org.pingsafe.utils;

import java.util.HashMap;

public class QueryParamGenerator {

    public static HashMap<String, String> getCustomerQueryParam(String id){

        HashMap<String,String> queryParamMap = new HashMap<String, String>();
        queryParamMap.put("id",id);

        return queryParamMap;

    }
}
