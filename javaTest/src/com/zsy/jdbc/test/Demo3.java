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

public class Demo3 {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet re = null;
		try {
			//加载驱动类
			Class.forName("com.mysql.jdbc.Driver");
			//建立连接
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "888");
			
			String sql = "select * from student where del_flag=0";
			ps = con.prepareStatement(sql);
			//时间
			//ps.setDate(1, new java.sql.Date(System.currentTimeMillis()));
			re = ps.executeQuery();
			while(re.next()) {
				System.out.println(re.getInt(1)+"--->"+re.getString(2));
			}
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
