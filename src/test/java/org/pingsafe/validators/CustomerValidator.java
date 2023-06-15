package org.pingsafe.validators;


import org.pingsafe.helpers.databaseHelpers.CustomerDBHelper;
import org.pingsafe.pojo.Customer;
import org.testng.Assert;

public class CustomerValidator {


    /**The method validates the attribute from the API response with that of Database **/
    public static void validateCustomerResponse(Customer apiResponse){

        /**Fetching details from Database **/

        Customer customerDB = CustomerDBHelper.fetchCustomerDetailsFromDB(apiResponse.getId());

        /**Asserting the fields API Vs DB **/
        Assert.assertEquals(apiResponse.getId(),customerDB.getId());
        Assert.assertEquals(apiResponse.getName(),customerDB.getName());
        Assert.assertEquals(apiResponse.getPhone_number(),customerDB.getPhone_number());
        Assert.assertEquals(apiResponse.getSms_sent(),customerDB.getSms_sent());

    }
}
