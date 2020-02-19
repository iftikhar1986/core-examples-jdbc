package com.soft.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcApp38 {

	public static void main(String[] args) {
		
		Connection con = null;
		Statement st = null;
		//ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/durgadb","root","root");
			st = con.createStatement();
			st.addBatch("insert into emp1 values(666,'GGG',5000,'Hud')");
			st.addBatch("update emp1 set ESAL = ESAL +500 where ESAL < 15000");
			st.addBatch("delete from emp1 where ENO = 111");
			
			int[] rowCounts = st.executeBatch();
			
			for (int i = 0; i < rowCounts.length; i++) {
				System.out.println("RowCount : "+rowCounts[i]);
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
