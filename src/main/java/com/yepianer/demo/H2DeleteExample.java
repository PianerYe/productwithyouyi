package com.yepianer.demo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class H2DeleteExample {
    private static final String DELETE_TABLE_SQL = "delete from users where id = 1";

    public static void main(String[] args) throws SQLException {
        H2DeleteExample deleteExample = new H2DeleteExample();
        deleteExample.deleteRecord();
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
