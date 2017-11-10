package com.kokoharry.website.manager.dao.impl;

import com.kokoharry.website.manager.bean.Class;
import com.kokoharry.website.manager.bean.Property;
import com.kokoharry.website.manager.dao.IJdbcDao;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import org.springframework.stereotype.Repository;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by luyb on 2017/10/31.
 */
@Repository("jdbcDaoImpl")
public class JdbcDaoImpl implements IJdbcDao{

    @Override
    public List<String> getTables(String jdbcUrl, String userName, String password,String dbName) {
        List<String> result = new ArrayList<>();
        Connection conn = getConn(jdbcUrl,userName,password);
        String sql = "SELECT TABLE_NAME FROM information_schema.TABLES WHERE TABLE_SCHEMA = '"+dbName+"'";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement)conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                result.add(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Class getClassForGenrate(String jdbcUrl, String userName,String password,String dbName ,String tableName) {
        Class result = new Class();
        result.setClassname(tableName);
        Connection conn = getConn(jdbcUrl,userName,password);
        String sql = "SELECT * FROM information_schema.TABLES WHERE table_name =  '"+tableName+"' AND TABLE_SCHEMA = '"
                + dbName + "'";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement)conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                result.setComment(rs.getString("TABLE_COMMENT"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Property> selectColumns(String jdbcUrl, String userName, String password, String dbName, String tableName){
        List<Property> list = new ArrayList<>();
        Connection conn = getConn(jdbcUrl,userName,password);
        String sql = "SELECT * FROM information_schema.COLUMNS WHERE table_name =  '"+tableName+"' AND TABLE_SCHEMA = '"
                + dbName + "'";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement)conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Property property = new Property();
                property.setType(rs.getString("DATA_TYPE"));
                property.setComment(rs.getString("COLUMN_COMMENT"));
                property.setPropertyName(rs.getString("COLUMN_NAME"));
                list.add(property);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    private static Connection getConn(String jdbcUrl, String userName, String password) {
        String driver = "com.mysql.jdbc.Driver";
        Connection conn = null;
        try {
            java.lang.Class.forName(driver); //classLoader,加载对应驱动
            conn = (Connection) DriverManager.getConnection(jdbcUrl, userName, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
