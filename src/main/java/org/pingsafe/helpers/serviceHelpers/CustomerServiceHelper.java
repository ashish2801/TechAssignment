package org.pingsafe.helpers.serviceHelpers;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.pingsafe.RestResource;
import org.pingsafe.constants.APIEndpoints;
import org.pingsafe.pojo.Customer;

import static org.pingsafe.utils.HeaderGenerator.getCustomerServiceHeader;
import static org.pingsafe.utils.QueryParamGenerator.getCustomerQueryParam;

public class CustomerServiceHelper {



    @Step
    public static Response addCustomer(Customer requestPayload){

        return RestResource.post(requestPayload, getCustomerServiceHeader(), APIEndpoints.ADD_OR_FETCH_CUSTOMER);

    }

    @Step
    public static Response addCustomer(Customer requestPayload, String accessToken){

        return RestResource.post(requestPayload, getCustomerServiceHeader(accessToken), APIEndpoints.ADD_OR_FETCH_CUSTOMER);

    }


    @Step
    public static Response fetchCustomerDetail(String customerID){

        return RestResource.get(getCustomerServiceHeader(),getCustomerQueryParam(customerID), APIEndpoints.ADD_OR_FETCH_CUSTOMER);

    }

}
