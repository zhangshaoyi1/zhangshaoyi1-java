package com.zsy.jdbc.test;
/**
 * jdbc����
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo2 {
	public static void main(String[] args) {
		
		try {
			//����������
			Class.forName("com.mysql.jdbc.Driver");
			//��������
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "888");
			
			String sql = "insert into student values(?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setObject(1, "4");
			ps.setString(2, "����");
			ps.setString(3,"0");
			//ʱ��
			//ps.setDate(1, new java.sql.Date(System.currentTimeMillis()));
			ps.execute();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
