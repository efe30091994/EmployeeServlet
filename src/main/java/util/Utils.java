package util;

import java.sql.*;

public class Utils {
    String url = "jdbc:postgresql://localhost:5432/employee_db";
    String user = "postgres";
    String password = "postgres";

    public Connection getConnection(){
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException | ClassNotFoundException throwables) {
            return null;
        }
    }
}
