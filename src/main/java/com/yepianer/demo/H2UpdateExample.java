package com.yepianer.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class H2UpdateExample {
    private static final String UPDATE_USERS_SQL = "update users set name = ? where id =?;";

    public static void main(String[] args) throws SQLException {
        H2UpdateExample updateExample = new H2UpdateExample();
        updateExample.updateRecord();
    }

    public void updateRecord() throws SQLException{
        System.out.println(UPDATE_USERS_SQL);
        try (Connection connection = H2JDBCUtils.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL)){
            preparedStatement.setString(1,"Ram");
            preparedStatement.setInt(2,1);

            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            H2JDBCUtils.printSQLException(e);
        }
    }
}
