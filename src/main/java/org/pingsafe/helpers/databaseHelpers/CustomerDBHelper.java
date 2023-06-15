package org.pingsafe.helpers.databaseHelpers;

import org.pingsafe.constants.DBQueries;
import org.pingsafe.pojo.Customer;
import org.pingsafe.utils.ConfigLoader;
import org.pingsafe.utils.DatabaseManager;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class CustomerDBHelper {

    /**Fetching corresponding template based on the DB Path set on the config.properties**/
        public static JdbcTemplate customerDBTemplate = DatabaseManager.getJDBCTemplate(ConfigLoader.getInstance().getDatabasePath());


        public static Customer fetchCustomerDetailsFromDB(String customerId){

            /**Serializing the result Set from the Database Query to list of Objects **/
            List<Customer> customerList = customerDBTemplate.query(String.format(DBQueries.GET_A_CUSTOMER_DETAIL,customerId),new CustomerTableRowMapper());
            return customerList.get(0);
        }

}
