package com.yepianer.product;

import com.yepianer.demo.H2InsertExample;
import com.yepianer.demo.H2JDBCUtils;
import com.yepianer.untils.EasyExcelUtil;
import com.yepianer.untils.UUIDUntils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class H2insertProduct {

    /*
    *  private int id;
    private int productId;
    private String productNameFirst;
    private String productNameSecond;

    private String productType;
    private String productTypeOld;

    private String images;

    private String supplierName;

    private String remarks;
    *
    * */
    private static final String INSERT_PRODUCT_SQL = "INSERT INTO products" +
            " (id,productid,productnamefirst,productnamesecond,producttype," +
            "producttypeold,productimages,suppliername,remarks) VALUES " +
            "(?,?,?,?,?,?,?,?,?);";

    public static void main(String[] args) throws SQLException {
        H2insertProduct h2insertProduct = new H2insertProduct();
        h2insertProduct.insertRecord();

    }

    private void insertRecordsInBatches(List<Map<Integer, String>> products) {
        System.out.println(INSERT_PRODUCT_SQL);
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String fileName = "D:\\java\\javafx\\demo\\src\\main\\java\\com\\yepianer\\excel\\产品表.xlsx";
        List<Map<Integer, String>> productinfo = EasyExcelUtil.syncRead(fileName);
        System.out.println(productinfo);
        int size = productinfo.size();
        try {
            connection = H2JDBCUtils.getConnection();
            //关闭自动提交（开启事务）
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(INSERT_PRODUCT_SQL);
            preparedStatement.setString(1, UUIDUntils.generateUUIDWithoutHyphens());
            preparedStatement.setInt(2,1);
            preparedStatement.setString(3,"A1");
            preparedStatement.setString(4,"实用专业款");
            preparedStatement.setString(5,"DLX-9141");
            preparedStatement.setString(6,null);
            preparedStatement.setString(7,null);
            preparedStatement.setString(8,"B1");
            preparedStatement.setString(9,null);
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();

            //没异常，手动提交
            connection.commit();
            System.out.println("提交成功");

        }catch (SQLException e){
            H2JDBCUtils.printSQLException(e);
            System.out.println("发生异常，开始回滚");
            if (connection != null){
                try {
                    connection.rollback();
                    System.out.println("回滚成功");
                }catch (SQLException ex){
                    ex.printStackTrace();
                }
            }
        }finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }


    private void insertRecord() {
        System.out.println(INSERT_PRODUCT_SQL);

        try (Connection connection = H2JDBCUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT_SQL)){
            preparedStatement.setString(1, UUIDUntils.generateUUIDWithoutHyphens());
            preparedStatement.setInt(2,1);
            preparedStatement.setString(3,"A1");
            preparedStatement.setString(4,"实用专业款");
            preparedStatement.setString(5,"DLX-9141");
            preparedStatement.setString(6,null);
            preparedStatement.setString(7,null);
            preparedStatement.setString(8,"B1");
            preparedStatement.setString(9,null);
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();

        }catch (SQLException e){
            H2JDBCUtils.printSQLException(e);
        }
    }


}
