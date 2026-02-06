package com.yepianer.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class H2InsertExample {
    private static final String INSERT_USERS_SQL = "INSERT INTO users" +
            " (id,name,email,country,password) VALUES " +
            "(?,?,?,?,?);";

    public static void main(String[] args) throws SQLException {
        H2InsertExample creatTableExample = new H2InsertExample();
        creatTableExample.insertRecord();
    }

    public void insertRecord() throws SQLException{
        System.out.println(INSERT_USERS_SQL);
        try (Connection connection = H2JDBCUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)){
            preparedStatement.setInt(1,2);
            preparedStatement.setString(2,"Tony");
            preparedStatement.setString(3,"tony@gmail.com");
            preparedStatement.setString(4,"US");
            preparedStatement.setString(5,"secret");

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();

        }catch (SQLException e){
            H2JDBCUtils.printSQLException(e);
        }
    }
}
