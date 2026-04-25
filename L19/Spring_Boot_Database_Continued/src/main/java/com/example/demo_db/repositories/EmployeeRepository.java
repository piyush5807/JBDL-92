package com.example.demo_db.repositories;

import com.example.demo_db.models.Employee;
import com.example.demo_db.models.Gender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class EmployeeRepository {

    private Connection connection;
    private static Logger logger = LoggerFactory.getLogger(EmployeeRepository.class);

    /**
     * Connection to underlying db related code
     * SQL queries to fetch, insert, update, delete any data

     */

    EmployeeRepository() throws SQLException {
        getConnection();
        createEmployeeTable();
    }

    // Earlier without JPA --> 300 ms : I had to the entire conversion, which is not scalable, not maintainable, error prone
    // With JPA --> 300.5 ms : Everything sorted which was a problem earlier

    // API slower by 0.001% --> for 1 API
    // 1 million - 10%

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



    public void createEmployee(Employee employee) throws SQLException {
        // TODO: insert into ...

        String sql = "INSERT INTO employee(firstName, lastName, email, age, country, gender, createdAt, lastUpdatedAt) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        // placeholder -- ?
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        // Fill in the blanks / Add values to the placeholders
        preparedStatement.setString(1, employee.getFirstName());
        preparedStatement.setString(2, employee.getLastName());
        preparedStatement.setString(3, employee.getEmail());
        preparedStatement.setInt(4, employee.getAge());
        preparedStatement.setString(5, employee.getCountry());
        preparedStatement.setString(6, employee.getGender().name());
        preparedStatement.setTimestamp(7, timestamp);
        preparedStatement.setTimestamp(8, timestamp);

        int result = preparedStatement.executeUpdate();
        logger.info("Insert query executed, result = {} rows affected", result);

    }

    public Employee getEmployee(Integer employeeId) throws SQLException {
        // TODO: select * from employee where id = ...

        String sql = "select * from employee where id = ?";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setInt(1, employeeId);

        ResultSet resultSet = preparedStatement.executeQuery();
//        String temp = resultSet.getString(1);
//        logger.info("temp = {}", temp);
        if(resultSet.next()){

            String fn = resultSet.getString(2);
            String ln = resultSet.getString(3);
            String em = resultSet.getString("email"); // resultSet.getString(4);
            Integer age = resultSet.getInt("age");
            String country = resultSet.getString("country");
            Gender gender = Gender.valueOf(resultSet.getString("gender"));
            Date createdAt = resultSet.getTimestamp("createdAt");
            Date lastUpdatedAt = resultSet.getTimestamp("lastUpdatedAt");

            return new Employee(employeeId, fn, ln, em, age, country, gender, createdAt, lastUpdatedAt);
        }

        return null;

    }

    public List<Employee> getEmployees() throws SQLException {

        String sql = "select * from employee";
        Statement statement = this.connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        List<Employee> result = new ArrayList<>();

        while(resultSet.next()){

            Integer employeeId = resultSet.getInt(1);
            String fn = resultSet.getString(2);
            String ln = resultSet.getString(3);
            String em = resultSet.getString("email"); // resultSet.getString(4);
            Integer age = resultSet.getInt("age");
            String country = resultSet.getString("country");
            Gender gender = Gender.valueOf(resultSet.getString("gender"));
            Date createdAt = resultSet.getTimestamp("createdAt");
            Date lastUpdatedAt = resultSet.getTimestamp("lastUpdatedAt");

            result.add(new Employee(employeeId, fn, ln, em, age, country, gender, createdAt, lastUpdatedAt));
        }

        return result;
    }

    public void deleteEmployee(){

    }
}
