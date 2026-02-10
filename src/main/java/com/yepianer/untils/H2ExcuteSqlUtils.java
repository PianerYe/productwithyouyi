package com.yepianer.untils;

import com.yepianer.demo.H2JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author yepianer
 * @descripiton 创建删除类的通用模版
 * @since 2026/2/10
 */
public class H2ExcuteSqlUtils {

    //创建表通用类
    public static void executeSql(String sql) {

        try (Connection connection = H2JDBCUtils.getConnection();
             Statement statement = connection.createStatement();){
            statement.execute(sql);
        }catch (SQLException e){
            H2JDBCUtils.printSQLException(e);
        }
    }
}
