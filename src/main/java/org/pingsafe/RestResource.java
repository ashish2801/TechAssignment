package org.pingsafe;

import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.pingsafe.utils.ConfigLoader;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.pingsafe.builders.SpecificationBuilder.getRequestSpecification;
import static org.pingsafe.builders.SpecificationBuilder.getResponseSpecification;

public class RestResource {


    /**Generic Method for all POST request **/
    public static Response post(Object payLoad , Map<String,String> headers, String resourcePath){

        Response response = given(getRequestSpecification())
                                .headers(headers)
                                .body(payLoad).
                            when()
                                    .post(resourcePath).
                            then()
                                    .spec(getResponseSpecification())
                                    .extract().response();

        return response;

    }

    /**Generic Method for all GET request **/
    public static Response get(Map<String,String> headers,Map<String,String> queryParams, String resourcePath){

        Response response = given(getRequestSpecification())
                .headers(headers).
                queryParams(queryParams).

                when()
                .get(resourcePath).
                then()
                .spec(getResponseSpecification())
                .extract().response();

        return response;

    }
}
