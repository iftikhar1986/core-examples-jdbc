// A program that use getUpdateCount() explicitly . using executeQuery() with no select Query
package com.soft.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcApp13 {

	public static void main(String[] args) {
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "durga");
			st = con.createStatement();
			
			rs = st.executeQuery("update emp1 set ESAL = ESAL - 500 where ESAL < 10000");
			
			int rowCount = st.getUpdateCount();
			
			System.out.println("Rowcount : "+rowCount);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				st.close();
				con.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}

	}

}
