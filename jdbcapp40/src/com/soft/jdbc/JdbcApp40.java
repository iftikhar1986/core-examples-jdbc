package com.soft.jdbc;

import java.io.BufferedReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JdbcApp40 {

	public static void main(String[] args) {
		Connection con  = null;
		PreparedStatement pst = null;
		BufferedReader br = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/durgadb","root","root");
			pst = con.prepareStatement("update emp1 set ESAL = ESAL + ? where ESAL < ?");
			
			pst.setInt(1, 500);
			pst.setFloat(2, 10000);
			int rowCount = pst.executeUpdate();
			System.out.println("Row Count : "+rowCount);
			
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
