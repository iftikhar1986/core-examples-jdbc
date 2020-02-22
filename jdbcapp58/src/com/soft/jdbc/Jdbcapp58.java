package com.soft.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Jdbcapp58 {

	public static void main(String[] args) {

		Connection con = null;
		Statement st = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","durga");
			con.setAutoCommit(false);
			st = con.createStatement();
			st.executeUpdate("insert into student values('S111','AAA',88)");
			st.executeUpdate("insert into student values('S222','BBB',77)");
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
