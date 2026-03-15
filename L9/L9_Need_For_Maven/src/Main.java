import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws SQLException {

        // Objective: I need to create a table in a mysql database
        // JDBC - Java database connectivity
        // Protocol
        // HTTP - hyper text transfer protocol - connect b/w client & server over internet / web surfing
        // FTP - file transfer protocol - communicate with a file server
        // SMTP - simple mail transfer protocol - sending emails

        // an address of a server consists of 2 things - IP address + Port
        // IP Address ~ Address of your home
        // Port ~ Floor

        // JDBC - connect java application with a sql database  (not with no-sql databases like mongodb, hbase..)
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test_jbdl_92", "root", "");

        Statement statement = connection.createStatement();
        statement.execute("CREATE TABLE users(id int, name varchar(40))");
    }
}