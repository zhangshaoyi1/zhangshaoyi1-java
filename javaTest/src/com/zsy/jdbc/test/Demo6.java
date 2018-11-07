package com.zsy.jdbc.test;
/**
 * jdbc查询操作
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo6 {
	public static void main(String[] args) {
		Connection con = null;
		Statement ps = null;
		ResultSet re = null;
		try {
			//加载驱动类
			Class.forName("com.mysql.jdbc.Driver");
			//建立连接
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "888");
			
			//设置为手动提交
			con.setAutoCommit(false);
			ps = con.createStatement();
			/**
			 * *********************************************************
			 */
			//中间为批处理操作
			ps.executeBatch();
			//提交
			con.commit();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//ResultSet ——> PregaredStatement——> connection
			if(con!=null) {
				if(re != null) {
					try {
						re.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(ps != null) {
					try {
						ps.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
