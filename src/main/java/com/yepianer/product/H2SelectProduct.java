package com.yepianer.product;

import com.yepianer.demo.H2JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class H2SelectProduct {
    private static final String QUERY = "select id,productid,productnamefirst,productnamesecond,producttype,producttypeold,productimages,suppliername,remarks from products where productid = ?";

    public static void main(String[] args) {
        try (Connection connection = H2JDBCUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(QUERY);){
            preparedStatement.setInt(1,11);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                String id = rs.getString("id");
                String productid = rs.getString("productid");
                String productnamefirst = rs.getString("productnamefirst");
                String productnamefirstsecond = rs.getString("productnamesecond");
                String producttype = rs.getString("producttype");
                String producttypeold = rs.getString("producttypeold");
                String productimages = rs.getString("productimages");
                String suppliername = rs.getString("suppliername");
                String remarks = rs.getString("remarks");


                System.out.println(id + "," +productid + "," + productnamefirst + "," + productnamefirstsecond + "," +
                        producttype + "," + producttypeold + "," + productimages + "," + suppliername + "," + remarks);
            }
        } catch (SQLException e){
            H2JDBCUtils.printSQLException(e);
        }
    }
}
