package com.soft.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JdbcApp43 {

	public static void main(String[] args) {
		
		Connection con  = null;
		PreparedStatement pst = null;
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/durgadb","root","root");
			pst = con.prepareStatement("insert into emp2 values(?,?,?,?)");
			pst.setInt(1, 111);
			pst.setString(2, "AAA");
			
			java.util.Date date1 = new java.util.Date();
			long time = date1.getTime();
			java.sql.Date dob = new java.sql.Date(time);
			pst.setDate(3, dob);
			
			java.sql.Date doj = java.sql.Date.valueOf("2019-09-11");
			pst.setDate(4, doj);
			
			pst.executeUpdate();
			System.out.println("Employee Insterted Successfully");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
