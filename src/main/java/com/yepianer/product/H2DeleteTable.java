package com.yepianer.product;

import com.yepianer.untils.H2ExcuteSqlUtils;

import java.sql.SQLException;

import static com.yepianer.untils.H2ExcuteSqlUtils.executeSql;

/**
 * @author yepianer
 * @descripiton 删除创建的库
 * @since 2026/2/10
 */
public class H2DeleteTable {

    //删除主表配表的语句
    public static final String deleteTableSQLWithProduct = "drop table if exists products";

    //删除产品大类代码表的SQL语句
    public static final String deleteTableSQLWithProductNameFirst = "drop table if exists productnamefirst";

    //删除供应商代码表的SQL语句
    public static final String deleteTableSQLWithSuppiler = "drop table if exists suppiler";
    //删除主表配表
    public void deleteTableWithProduct() throws SQLException {
        H2ExcuteSqlUtils.executeSql(deleteTableSQLWithProduct);
    }
    //删除产品大类代码表
    public void deleteTableWithroductNameFirst() throws SQLException{
        H2ExcuteSqlUtils.executeSql(deleteTableSQLWithProductNameFirst);
    }
    //删除供应商代码表
    public void DeleteTableSQLWithSuppiler() throws SQLException{
        H2ExcuteSqlUtils.executeSql(deleteTableSQLWithSuppiler);
    }


}
