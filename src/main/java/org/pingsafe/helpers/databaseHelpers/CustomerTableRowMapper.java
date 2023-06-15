package org.pingsafe.helpers.databaseHelpers;

import org.pingsafe.pojo.Customer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerTableRowMapper implements RowMapper<Customer> {


    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        String id = rs.getString("id");
        String name = rs.getString("name");
        String phoneNumber = rs.getString("phone_number");
        Boolean sms_sent = rs.getBoolean("sms_sent");

        return new Customer(id, name, phoneNumber,sms_sent);
    }
}
