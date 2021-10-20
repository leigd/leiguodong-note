package com.lgd.note.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author leiguodong
 * @descirption 数据库工具类
 * @date 2021-10-20 21:29
 */
public class DBUtil {
    //得到配置文件对象
    private static Properties properties=new Properties();
    static {
        try {
            //加载配置文件（输入流）
            InputStream in=DBUtil.class.getClassLoader().getResourceAsStream("db.properties");
            //通过load()方法将输入流的内容加载到配置文件对象中
            properties.load(in);
            //通过配置文件的getProperty()方法获取驱动名，并加载驱动
           // Class.forName(properties.getProperty("driverClass"));
            Class.forName("com.mysql.jdbc.Driver");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接
     * @return
     */
    public static Connection getConnection(){
        Connection connection=null;
        //得到数据库连接的相关信息
        String dbUrl=properties.getProperty("jdbcUrl");
        String dbName=properties.getProperty("user");
        String dbPwd=properties.getProperty("password");
        //得到数据库连接
        try {
            connection= DriverManager.getConnection(dbUrl,dbName,dbPwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 关闭资源
     * @param resultSet
     * @param preparedStatement
     * @param connection
     */
    public static void close(ResultSet resultSet, PreparedStatement preparedStatement,Connection connection){
        try {
            if (resultSet!=null){
                resultSet.close();
            }
            if (preparedStatement!=null){
                preparedStatement.close();
            }
            if (connection!=null){
                connection.close();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}
