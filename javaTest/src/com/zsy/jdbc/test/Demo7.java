package com.zsy.jdbc.test;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
/**
 * jdbc���ı�����
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo7 {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet re = null;
		try {
			//����������
			Class.forName("com.mysql.jdbc.Driver");
			//��������
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "888");
			
			ps = con.prepareStatement("insert into student (id,inf) values (?,?)");
			ps.setString(1, "7");
			try {
				ps.setClob(2, new FileReader(new File("H:\\java��Ƶ\\15_JDBC���ݿ����\\Դ��\\Դ��\\����JDBCԴ����\\����JDBCԴ����\\src\\com\\bjsxt\\jdbc\\Demo01.java")));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ps.execute();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//ResultSet ����> PregaredStatement����> connection
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
