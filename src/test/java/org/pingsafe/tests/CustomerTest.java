package org.pingsafe.tests;


import com.jayway.jsonpath.JsonPath;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.pingsafe.dataProviders.CustomerDataProvider;
import org.pingsafe.enums.StatusCodes;
import org.pingsafe.helpers.serviceHelpers.CustomerServiceHelper;
import org.pingsafe.pojo.Customer;
import org.pingsafe.builders.CustomerBuilder;
import org.pingsafe.validators.CustomerValidator;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.pingsafe.constants.Constants.*;


public class CustomerTest extends BaseTest{


    private static String customerID; /**customerID static variable to be used in the GET call for 2nd test case**/

    @Description("Verify if able to Add A Customer")/** Adding description for Allure reporting **/
    @Test(groups = {"Sanity","Regression"},dataProviderClass = CustomerDataProvider.class, dataProvider = "customerData") /** Driving the input values via the data provider **/
    public void verify_able_to_add_customer(String id, String customerName, String phoneNumber){


        customerID = id; /**initializing variable**/

        /**Serialization of the request  to CustomerRequest class**/
        Customer customer = CustomerBuilder.addCustomer(id,customerName,phoneNumber);

        /**Firing the POST call**/
        Response response = CustomerServiceHelper.addCustomer(customer);

        /**Asserting for the response code **/
        Assert.assertEquals(response.getStatusCode(), StatusCodes.CODE_200.code);

        /**Asserting for the response message **/
        String message = JsonPath.read(response.getBody().asString(), "$.message");
        Assert.assertEquals(message,ADD_CUSTOMER_SUCCESS_RESPONSE);

        /**Introducing an explicit delay of 10 seconds at the end of POST call for the DB insertion to complete **/
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }


    @Description("Verify If able to fetch Customer Details") /** Adding description for Allure reporting **/
    @Test(groups = {"Sanity","Regression"})
    public void verify_able_to_get_customer_Details(){

        /**Firing the GET call**/
        Response response = CustomerServiceHelper.fetchCustomerDetail(customerID); /**reusing customerID variable from first test case**/

        /**Asserting for the response code **/
        Assert.assertEquals(response.getStatusCode(), StatusCodes.CODE_200.code);

        /**Deserialization of the response object to CustomerResponse class**/
        Customer customerResponse =  response.as(Customer.class);

        /**Asserting for the different attributes for the response json **/
        CustomerValidator.validateCustomerResponse(customerResponse);

    }

    @Description("Verify error when creating customer with invalid phoneNumber")/** Adding description for Allure reporting **/
    @Test(groups = {"Regression"},dataProviderClass = CustomerDataProvider.class, dataProvider = "invalidPhone") /** Driving the input values via the data provider **/
    public void verify_error_for_invalid_phone(String id, String customerName, String phoneNumber){

        /**Serialization of the request  to CustomerRequest class**/
        Customer customer = CustomerBuilder.addCustomer(id,customerName,phoneNumber);

        /**Firing the POST call**/
        Response response = CustomerServiceHelper.addCustomer(customer);

        /**Asserting for the response code **/
        Assert.assertEquals(response.getStatusCode(), StatusCodes.CODE_500.code);

        /**Asserting for the response message **/
        String message = JsonPath.read(response.getBody().asString(), "$.error");
        Assert.assertEquals(message,INVALID_PHONE_RESPONSE);

    }

    @Description("Verify Error When trying to create duplicate customer entries")/** Adding description for Allure reporting **/
    @Test(groups = {"Regression"},dataProviderClass = CustomerDataProvider.class, dataProvider = "duplicateCustomerData") /** Driving the input values via the data provider **/
    public void verify_error_for_invalid_id(String customerName, String phoneNumber){


        /**Serialization of the request  to CustomerRequest class**/
        Customer customer = CustomerBuilder.addCustomer(customerID,customerName,phoneNumber);

        /**Firing the POST call**/
        Response response = CustomerServiceHelper.addCustomer(customer);

        /**Asserting for the response code **/
        Assert.assertEquals(response.getStatusCode(), StatusCodes.CODE_500.code);

        /**Asserting for the response message **/
        String message = JsonPath.read(response.getBody().asString(), "$.error");
        Assert.assertEquals(message,INVALID_ID_RESPONSE);

    }

    @Description("Verify Error with invalid Access Token")/** Adding description for Allure reporting **/
    @Test(groups = {"Regression"},dataProviderClass = CustomerDataProvider.class, dataProvider = "customerData") /** Driving the input values via the data provider **/
    public void verify_error_for_invalid_token(String id,String customerName, String phoneNumber){


        /**Serialization of the request  to CustomerRequest class**/
        Customer customer = CustomerBuilder.addCustomer(id,customerName,phoneNumber);

        /**Firing the POST call**/
        Response response = CustomerServiceHelper.addCustomer(customer, INVALID_TOKEN);

        /**Asserting for the response code **/
        Assert.assertEquals(response.getStatusCode(), StatusCodes.CODE_403.code);

        /**Asserting for the response message **/
        String message = JsonPath.read(response.getBody().asString(), "$.error");
        Assert.assertEquals(message,INVALID_TOKEN_RESPONSE);

    }

    @Description("Verify that the CustomerID field is mandatory")/** Adding description for Allure reporting **/
    @Test(groups = {"Regression"},dataProviderClass = CustomerDataProvider.class, dataProvider = "emptyID") /** Driving the input values via the data provider **/
    public void verify_error_for_empty_id(String id,String customerName, String phoneNumber){


        /**Serialization of the request  to CustomerRequest class**/
        Customer customer = CustomerBuilder.addCustomer(id,customerName,phoneNumber);

        /**Firing the POST call**/
        Response response = CustomerServiceHelper.addCustomer(customer);

        /**Asserting for the response code **/
        Assert.assertEquals(response.getStatusCode(), StatusCodes.CODE_400.code);

        /**Asserting for the response message **/
        String message = JsonPath.read(response.getBody().asString(), "$.error");
        Assert.assertEquals(message,EMPTY_ID_RESPONSE);

    }

    @Description("Verify that the PhoneNumber field is mandatory")/** Adding description for Allure reporting **/
    @Test(groups = {"Regression"},dataProviderClass = CustomerDataProvider.class, dataProvider = "emptyPhone") /** Driving the input values via the data provider **/
    public void verify_error_for_empty_phone(String id,String customerName, String phoneNumber){


        /**Serialization of the request  to CustomerRequest class**/
        Customer customer = CustomerBuilder.addCustomer(id,customerName,phoneNumber);

        /**Firing the POST call**/
        Response response = CustomerServiceHelper.addCustomer(customer);

        /**Asserting for the response code **/
        Assert.assertEquals(response.getStatusCode(), StatusCodes.CODE_400.code);

        /**Asserting for the response message **/
        String message = JsonPath.read(response.getBody().asString(), "$.error");
        Assert.assertEquals(message,EMPTY_PHONE_RESPONSE);

    }



}
