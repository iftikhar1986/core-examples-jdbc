package com.soft.jdbc;

import java.io.BufferedReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcApp35 {

	public static void main(String[] args) {
			Connection con = null;
			Statement st = null;
			ResultSet rs = null;
			BufferedReader br = null;
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/durgadb","root","root");
				st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				rs = st.executeQuery("select * from emp1");
				while (rs.next()) {
					float esal = rs.getFloat("ESAL");
					if (esal < 15000) {
						float new_Sal = esal+500;
						rs.updateFloat(3, new_Sal);
						rs.updateRow();
						System.out.println("Employee "+rs.getInt("ENO")+" Updated Succefully");
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
