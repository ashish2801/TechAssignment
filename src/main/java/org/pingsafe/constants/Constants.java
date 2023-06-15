package org.pingsafe.constants;

import org.pingsafe.utils.FakerUtils;

public interface Constants {

    String ADD_CUSTOMER_SUCCESS_RESPONSE = "customer created";
    String INVALID_PHONE_RESPONSE = "CHECK constraint failed: length(phone_number) = 10";
    String INVALID_ID_RESPONSE = "UNIQUE constraint failed: customers.id";
    String INVALID_TOKEN_RESPONSE = "request cannot be authenticated!";
    String INVALID_TOKEN = "Invalid Token";
    String EMPTY_ID_RESPONSE = "Key: 'Customer.ID' Error:Field validation for 'ID' failed on the 'required' tag";
    String EMPTY_PHONE_RESPONSE = "Key: 'Customer.PhoneNumber' Error:Field validation for 'PhoneNumber' failed on the 'required' tag";

    String YES = "yes";
}
