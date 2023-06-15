package org.pingsafe.builders;

import io.qameta.allure.Step;
import org.pingsafe.pojo.Customer;

public class CustomerBuilder {

    /**Builder Design Pattern to build Customer Object**/
    @Step
    public static Customer addCustomer(String id, String customerName , String phoneNumber){
        return Customer.builder()
                .id(id)
                .name(customerName)
                .phone_number(phoneNumber)
                .build();
    }

}
