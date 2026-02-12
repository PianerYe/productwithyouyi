package com.yepianer.product;

import com.yepianer.untils.H2ExcuteSqlUtils;

import java.sql.SQLException;

/**
 * @descripiton 用于产品类的数据库创建
 *
 * @author yepianer
 * @data 2026/02/10
 */
public class H2CreatTable {

    //创建主表配表的SQL语句
    public static final String createTableSQLWithProduct = "create table if not exists products (\r\n" +
            "id varchar(100) primary key,\r\n" +
            "productid varchar(20),\r\n" +
            "productnamefirst varchar(100),\r\n" +
            "productnamesecond varchar(100),\r\n" +
            "producttype varchar(100),\r\n" +
            "producttypeold varchar(100),\r\n" +
            "productimages varchar(255),\r\n" +
            "suppliername varchar(100),\r\n" +
            "remarks varchar(255)\r\n" +
            ");";

    //创建产品大类代码表的SQL语句
    /**
     * private Integer productNameFirstId;
     *     private String productNameFirst;
     *     private String productnameFirstCode;
     */
    public static final String createTableSQLWithProductNameFirst = "create table if not exists productnamefirst( \r\n" +
            "productnamefirstid varchar(20) primary key , \r\n " +
            "productnamefirst varchar(20) , \r\n" +
            "productnamefirstcode varchar(20) \r\n" +
            ");";

    /**
     * private String supplierId;
     *     private String supplierName;
     *     private String supplierCode;
     * @throws SQLException
     */
    //创建供应商代码表的SQL语句
    public static final String createTableSQLWithSuppiler = "create table if not exists suppiler ( \r\n" +
            "suppilerid varchar(20) primary key , \r\n " +
            "suppilername varchar(20) ,\r\n " +
            "suppilercode varchar(20) \r\n " +
            ");";
    //创建供应商代码表
    public void createTableSQLWithSuppiler() throws SQLException {
        H2ExcuteSqlUtils.executeSql(createTableSQLWithSuppiler);
    }

    //创建产品大类代码表
    public void createTableSQLWithProductNameFirst() throws  SQLException {
            H2ExcuteSqlUtils.executeSql(createTableSQLWithProductNameFirst);
    }
    //创建主表配表
    public void createTableWithProduct() throws SQLException {
        H2ExcuteSqlUtils.executeSql(createTableSQLWithProduct);
    }


}
