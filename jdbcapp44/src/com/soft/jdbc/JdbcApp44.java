package com.soft.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcApp44 {

	public static void main(String[] args) {
		Connection con  = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con  = DriverManager.getConnection("jdbc:mysql://localhost:3306/durgadb","root","root");
			pst = con.prepareStatement("select * from emp2 where ENO = ?");
			pst.setInt(1, 111);
			rs = pst.executeQuery();
			rs.next();
			System.out.println("Employee Details");
			System.out.println("--------------------");
			System.out.println("Employee Number : "+rs.getInt("ENO"));
			System.out.println("Employee Name : "+rs.getString("ENAME"));
			System.out.println("Employee DOB : "+rs.getDate("DOB"));
			System.out.println("Employee DOJ : "+rs.getDate("DOJ"));
			
			
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
