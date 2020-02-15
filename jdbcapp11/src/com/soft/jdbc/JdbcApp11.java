//A JDBC program  using execute() method for Non-Select Query and getting ResyltSet Object 
package com.soft.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcApp11 {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "durga");
			st = con.createStatement();
			
			boolean b = st.execute("update emp1 set ESAL = ESAL + 500 where  ESAL < 10000");
			System.out.println(b);
			
			int rowCount = st.getUpdateCount();
			System.out.println("Record update : "+rowCount);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				st.close();
				con.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

}
