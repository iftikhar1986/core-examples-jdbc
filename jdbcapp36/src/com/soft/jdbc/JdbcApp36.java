package com.soft.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcApp36 {

	public static void main(String[] args) {
		Connection con  = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/durgadb","root","root");
			st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs = st.executeQuery("select * from emp1");
			while (rs.next()) {
				float esal = rs.getFloat("ESAL");
				int eno = rs.getInt("ENO");
				if (esal < 15000) {
					rs.deleteRow();
					System.out.println("Employee "+eno+" Deleted Successfuly");
				}
				
			}
			
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
