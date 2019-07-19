package com.wzy.transactional;

import java.sql.*;
import java.util.concurrent.TimeUnit;

/**
 * @author wzy
 * @title: DBUtil
 * @description: TODO
 * @date 2019/7/19 11:33
 */
public class DBUtil {

    private Connection connection;

    public DBUtil() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try {
                connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/practice?useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2B8", "root", "940926");
                connection.setAutoCommit(false);
                //设置事务隔离界别
                connection.setTransactionIsolation(2);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void update(String sql) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.execute();
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void query(String sql) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                System.out.println(resultSet.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
