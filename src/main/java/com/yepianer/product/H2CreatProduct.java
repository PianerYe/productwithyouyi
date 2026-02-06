package com.yepianer.product;

import com.yepianer.demo.H2CreatExample;
import com.yepianer.demo.H2JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class H2CreatProduct {

    private static final String createTableSQL = "create table if not exists products (\r\n" +
            "id varchar(100) primary key,\r\n" +
            "productid int(10),\r\n" +
            "productnamefirst varchar(100),\r\n" +
            "productnamesecond varchar(100),\r\n" +
            "producttype varchar(100),\r\n" +
            "producttypeold varchar(100),\r\n" +
            "productimages varchar(255),\r\n" +
            "suppliername varchar(100),\r\n" +
            "remarks varchar(255)\r\n" +
            ");";

    private static final String deleteTableSQL = "drop table if exists products";

    //productimages
    public static void main(String[] args) throws SQLException {
        H2CreatProduct creatProduct = new H2CreatProduct();
        creatProduct.createTable();

//        H2CreatProduct creatProduct1 = new H2CreatProduct();
//        creatProduct1.deleteTable();

    }

    public void createTable() throws SQLException {
        System.out.println(createTableSQL);

        try (Connection connection = H2JDBCUtils.getConnection();
             Statement statement = connection.createStatement();){
            statement.execute(createTableSQL);
        }catch (SQLException e){
            H2JDBCUtils.printSQLException(e);
        }

    }

    public void deleteTable() throws SQLException{
        System.out.println(deleteTableSQL);

        try (Connection connection = H2JDBCUtils.getConnection();
             Statement statement = connection.createStatement();){
            statement.execute(deleteTableSQL);
        }catch (SQLException e){
            H2JDBCUtils.printSQLException(e);
        }

    }
}
