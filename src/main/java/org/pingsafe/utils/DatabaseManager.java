package org.pingsafe.utils;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class DatabaseManager {


    /**Generic Method for returning DB Template Object as per specified 'databasePath'**/
    public static JdbcTemplate getJDBCTemplate(String databasePath){

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.sqlite.JDBC");
        dataSource.setUrl("jdbc:sqlite:"+databasePath);
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        return jdbcTemplate;

    }
}
