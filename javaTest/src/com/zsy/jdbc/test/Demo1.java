package com.zsy.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo1 {
	public static void main(String[] args) {
		
		try {
			//����������
			Class.forName("com.mysql.jdbc.Driver");
			//��������
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "888");
			Statement stm = con.createStatement();
			String name ="����";
			//����ע��©��
			String sql = "insert into student values('2','"+name+"','0')";
			stm.execute(sql);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
