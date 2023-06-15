package org.pingsafe.builders;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.pingsafe.utils.ConfigLoader;

public class SpecificationBuilder {


    /**Generic Method for building Request Specification **/
    public static RequestSpecification getRequestSpecification(){

        return new RequestSpecBuilder()
                .setBaseUri(ConfigLoader.getInstance().getBaseURL())
                .setAccept(ContentType.JSON)
                .log(LogDetail.ALL)
                .addFilter(new AllureRestAssured()).build();
    }

    /**Generic Method for building Response Specification **/
    public static ResponseSpecification getResponseSpecification(){

        return new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .log(LogDetail.ALL).build();
    }
}
