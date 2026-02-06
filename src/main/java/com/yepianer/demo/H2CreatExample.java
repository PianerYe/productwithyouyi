package com.yepianer.demo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class H2CreatExample {

//    private static final String createTableQSL = "create table users (\r\n" + id int(3) primary key ,\r\n"
//            + "name varchar (20),\r\n " + " email varchar(20),\r\n" + " country varchar(20),\r\n" +
//            " password varchar (20),\r\n " + " );";

    private static final String createTableQSL = "create table if not exists users (\r\n" +
            "id int primary key,\r\n" +
            "name varchar(20),\r\n" +
            "email varchar(20),\r\n" +
            "country varchar(20),\r\n" +
            "password varchar(20)\r\n" +
            ");";

    public static void main(String[] args) throws SQLException{
        H2CreatExample creatExample = new H2CreatExample();
        creatExample.createTable();
    }

    public void createTable() throws SQLException {
        System.out.println(createTableQSL);

        try (Connection connection = H2JDBCUtils.getConnection();
        Statement statement = connection.createStatement();){
            statement.execute(createTableQSL);
        }catch (SQLException e){
            H2JDBCUtils.printSQLException(e);
        }

    }
}
