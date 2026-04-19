package com.example.demo_db.repositories;

import com.example.demo_db.models.Employee;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@Repository
public class EmployeeRepository {

    private Connection connection;

    /**
     * Connection to underlying db related code
     * SQL queries to fetch, insert, update, delete any data

     */

    EmployeeRepository() throws SQLException {
        getConnection();
        createEmployeeTable();
    }

    private void getConnection() throws SQLException {
            if (this.connection == null) {
                this.connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/employees_92", "root", ""
                );
            }
    }

    private void createEmployeeTable() throws SQLException{

        Statement statement = this.connection.createStatement();
        statement.execute("CREATE TABLE if not exists employee(id int auto_increment primary key, firstName varchar(40), " +
                "lastName varchar(40), " +
                "email varchar(50), age int, " +
                "country varchar(30), gender varchar(10), createdAt timestamp, lastUpdatedAt timestamp)");
    }



    public void createEmployee(Employee employee){
        // TODO: insert into ...
    }
}
