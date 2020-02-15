/* Delection of the recored from the Database by JDBC application*/

package com.soft.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

import oracle.jdbc.driver.OracleDriver;

public class JdbcApp07 {

	public static void main(String[] args) {
		Scanner scanner = null;
		Connection con = null;
		Statement st = null;
		try {
			DriverManager.registerDriver(new OracleDriver());
			
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","durga");
			st = con.createStatement();
			
			scanner = new Scanner(System.in);
			System.out.print("Salary Range : ");
			float sal_Range =  scanner.nextFloat();
			
			int rowCount = st.executeUpdate("delete from emp1 where ESAL < "+sal_Range);
			
			System.out.println("Records Deleted "+rowCount);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				scanner.close();
				st.close();
				con.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}

	}

}
