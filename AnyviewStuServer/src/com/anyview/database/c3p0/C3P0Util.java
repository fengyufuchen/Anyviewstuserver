package com.anyview.database.c3p0;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
  
import com.mchange.v2.c3p0.ComboPooledDataSource;  

/** 
 * C3P0数据库连接工具类
 * @author Wangyang Wu
 * 
 */  
public class C3P0Util {
    
	public static ComboPooledDataSource cpds = new ComboPooledDataSource("mysql");
    
    /**
     * 获取连接
     * @return   Connection
     */  
    public static Connection getConnection() {
        try {
            return cpds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();  
            return null;  
        }  
    }  
      
    /** 
     * 关闭连接
     * @param conn
     * @param st
     * @param pst
     * @param rs
     */  
    public static void close(Connection conn, PreparedStatement pst, ResultSet rs) {
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(pst!=null){
            try {
                pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
  
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    /**
     * 测试
     * @param args
     */
    /*
    public static void main(String[] args) {
        Connection conn = getConnection();
        System.out.println(conn.getClass().getName());
        close(conn,null,null);
    }
    */
}
