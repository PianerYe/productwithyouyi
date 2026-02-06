package com.yepianer.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2JDBCUtils {

    private static String jdbcURL = "jdbc:h2:~/test";
    private static String jdbcUsername = "sa";
    private static String jdbcPassword = "";

    public static Connection getConnection(){
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return connection;
    }

    public static void printSQLException(SQLException ex){
        for (Throwable e : ex){
            if (e instanceof SQLException)
            e.printStackTrace(System.err);
            System.out.println("SQLState: " +((SQLException) e ).getSQLState());
            System.out.println("Error Code: " + ((SQLException) e ).getErrorCode());
            System.out.println("Message: " + e.getMessage());
            Throwable t = ex.getCause();
            while (t !=null){
                System.out.println("Cause:" + t);
                t = t.getCause();
            }
        }
    }
}
