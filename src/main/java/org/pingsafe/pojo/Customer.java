package org.pingsafe.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Customer {
    public Customer(String id, String name, String phone_number, Boolean sms_sent) {
        this.id = id;
        this.name = name;
        this.phone_number = phone_number;
        this.sms_sent = sms_sent;
    }

    private String id;

    private String name;

    private String phone_number;

    private Boolean sms_sent;
}
