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
            "productid int(10),\r\n" +
            "productnamefirst varchar(100),\r\n" +
            "productnamesecond varchar(100),\r\n" +
            "producttype varchar(100),\r\n" +
            "producttypeold varchar(100),\r\n" +
            "productimages varchar(255),\r\n" +
            "suppliername varchar(100),\r\n" +
            "remarks varchar(255)\r\n" +
            ");";

    //创建产品大类代码表的SQL语句
    public static final String createTableSQLWithProductNameFirst = "create table if not exists productnamefirst ( \r\n" +
            "namefirstid varchar(20) primary key , \r\n " +
            "namefirstcode varchar(20) \r\n" +
            ");";


    //创建产品大类代码表
    public void createTableSQLWithProductNameFirst() throws  SQLException {
            H2ExcuteSqlUtils.executeSql(createTableSQLWithProductNameFirst);
    }
    //创建主表配表
    public void createTableWithProduct() throws SQLException {
        H2ExcuteSqlUtils.executeSql(createTableSQLWithProduct);
    }


}
