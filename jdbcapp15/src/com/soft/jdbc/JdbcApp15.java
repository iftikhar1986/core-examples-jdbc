// JDBC program that uses executeUpdate() method for Selection statment and return rowcount and resultset object .

package com.soft.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcApp15 {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","durga");
			st = con.createStatement(); 
			int rowCount = st.executeUpdate("select * from emp1"); 
			System.out.println("Row Count : "+rowCount);
			
			rs = st.getResultSet();
			
			System.out.println("ENO\tENAME\tESAL\tEADDR");
			System.out.println("-------------------------");
			while (rs.next()) {
				System.out.print(rs.getInt("ENO")+"\t");
				System.out.print(rs.getString("ENAME")+"\t");
				System.out.print(rs.getFloat("ESAL")+"\t");
				System.out.print(rs.getString("EADDR")+"\n");
				
			}
			
			
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
