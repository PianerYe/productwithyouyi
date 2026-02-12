package com.yepianer.product;

import com.yepianer.demo.ExcelExample;
import com.yepianer.demo.H2InsertExample;
import com.yepianer.demo.H2JDBCUtils;
import com.yepianer.untils.EasyExcelUtil;
import com.yepianer.untils.UUIDUntils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class H2insertProduct {

    /*
    *  private int id;
    private String productId;
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
    private static final String FILE_NAME = "D:\\java\\javafx\\demo\\src\\main\\java\\com\\yepianer\\excel\\产品表.xlsx";

    public static void main(String[] args) throws SQLException {
//        H2insertProduct.insertRecordsInBatches(FILE_NAME);
        H2insertProduct h2insertProduct = new H2insertProduct();
//        h2insertProduct.insertRecord();
        h2insertProduct.insertRecordsInBatches(FILE_NAME);
    }

    public void insertRecordsInBatches(String fileName) {
        System.out.println(INSERT_PRODUCT_SQL);
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<ProductInfo> productInfos = ExcelExample.GetProductInfos(fileName);
        System.out.println(productInfos);
        try {
            connection = H2JDBCUtils.getConnection();
            //关闭自动提交（开启事务）
            connection.setAutoCommit(false);
            for (ProductInfo productInfo : productInfos ) {
                preparedStatement = connection.prepareStatement(INSERT_PRODUCT_SQL);
                preparedStatement.setString(1, productInfo.getId());
                preparedStatement.setString(2,productInfo.getProductId());
                preparedStatement.setString(3,productInfo.getProductNameFirst());
                preparedStatement.setString(4,productInfo.getProductNameSecond());
                preparedStatement.setString(5,productInfo.getProductType());
                preparedStatement.setString(6,productInfo.getProductTypeOld());
                preparedStatement.setString(7,productInfo.getImages());
                preparedStatement.setString(8,productInfo.getSupplierName());
                preparedStatement.setString(9,productInfo.getRemarks());
                System.out.println(preparedStatement);
                preparedStatement.executeUpdate();
                //没异常，手动提交
                connection.commit();
                System.out.println("提交成功");
            }


//            //没异常，手动提交
//            connection.commit();
//            System.out.println("提交成功");

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
