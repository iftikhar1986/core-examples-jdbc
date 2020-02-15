package com.soft.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcApp02 {

	//Using Type-4 Driver 
	public static void main(String[] args) {
		
		Connection con = null;
		Statement st = null ;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "durga");
			st = con.createStatement();
			String query = "create table emp1(ENO number(3) primary key,ENAME varchar2(10),ESAL float(5),EADDR varchar2(10))";
			st.executeUpdate(query);
			System.out.println("Table emp1 created Successfully");
		}catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			try {
				st.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}
		
		

	}

}
