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
import java.sql.Timestamp;

public class Demo4 {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet re = null;
		try {
			//加载驱动类
			Class.forName("com.mysql.jdbc.Driver");
			//建立连接
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "888");
			
			//设置为手动提交
			con.setAutoCommit(false);
			String sql1 = "insert into  student (id,createDate) values (?,?)";
			ps = con.prepareStatement(sql1);
			ps.setObject(1, "6");
			Timestamp date = new Timestamp(System.currentTimeMillis());
			
			ps.setObject(2, date);
			ps.execute();
			con.commit();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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
