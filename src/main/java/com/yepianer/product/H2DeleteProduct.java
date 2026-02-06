package com.yepianer.product;

import com.yepianer.demo.H2JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class H2DeleteProduct {
    private static final String DELETE_TABLE_SQL = "delete from products where id = 1";

    public static void main(String[] args) throws SQLException {
        H2DeleteProduct deleteProduct = new H2DeleteProduct();
        deleteProduct.deleteRecord();
    }

    private void deleteRecord() throws SQLException {
        System.out.println(DELETE_TABLE_SQL);

        try (Connection connection = H2JDBCUtils.getConnection();
             Statement statement = connection.createStatement();){
            statement.execute(DELETE_TABLE_SQL);
        }catch (SQLException e){
            H2JDBCUtils.printSQLException(e);
        }
    }
}
