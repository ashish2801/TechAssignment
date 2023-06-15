package org.pingsafe.dataProviders;

import org.pingsafe.utils.FakerUtils;
import org.testng.annotations.DataProvider;

public class CustomerDataProvider {


    @DataProvider(name = "customerData")
    public Object[][] getCustomerData(){
        /**Faker utils to generate random ID , Name and Phone Number for each case  **/
        Object[][] data = {{FakerUtils.generateRandomNumberOfLength(3),FakerUtils.generateRandomStringOfLength(6),FakerUtils.generateRandomNumberOfLength(10)}};
        return data;
    }


    @DataProvider(name = "duplicateCustomerData")
    public Object[][] getDuplicateCustomerData(){

        Object[][] data = {{FakerUtils.generateRandomStringOfLength(6),FakerUtils.generateRandomNumberOfLength(10)}};
        return data;
    }

    @DataProvider(name = "invalidPhone")
    public Object[][] getInvalidPhoneData(){
        /**Faker utils to generate incorrect phoneNumber of length 9 **/
        Object[][] data = {{FakerUtils.generateRandomNumberOfLength(3),FakerUtils.generateRandomStringOfLength(6),FakerUtils.generateRandomNumberOfLength(9)}};
        return data;
    }

    @DataProvider(name = "emptyID")
    public Object[][] getCustomerDataEmptyId(){
        Object[][] data = {{null,FakerUtils.generateRandomStringOfLength(6),FakerUtils.generateRandomNumberOfLength(10)}};
        return data;
    }

    @DataProvider(name = "emptyPhone")
    public Object[][] getCustomerDataEmptyPhone(){

        Object[][] data = {{FakerUtils.generateRandomNumberOfLength(3),FakerUtils.generateRandomStringOfLength(6),null}};
        return data;
    }



}
