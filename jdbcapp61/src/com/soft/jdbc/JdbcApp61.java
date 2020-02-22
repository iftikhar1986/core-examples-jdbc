package com.soft.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Savepoint;
import java.sql.Statement;

public class JdbcApp61 {

	public static void main(String[] args) {


		Connection con = null;
		Statement st = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/durgadb", "root", "root");

			con.setAutoCommit(false);
			st = con.createStatement();
			
			st.executeUpdate("insert into student values('S111','AAA',88)");
			Savepoint sp  = con.setSavepoint();
			st.executeUpdate("insert into student values('S222','BBB',77)");
			con.rollback(sp);
			//con.releaseSavepoint(sp); //Not Supported by Oracle:Xe database
			st.executeUpdate("insert into student values('S333','CCC',99)");
			con.commit();
			
			System.out.println("Transcation Success");
		} catch (Exception e) {
			
			try {
				con.rollback();
				System.out.println("Transcation Faliure");
			} catch (Exception e2) {
				e2.printStackTrace();
			}
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
