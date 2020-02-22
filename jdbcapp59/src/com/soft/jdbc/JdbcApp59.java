package com.soft.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcApp59 {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		BufferedReader br = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","durga");
			con.setAutoCommit(false);
			st = con.createStatement();
			br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("Source Account : ");
			String sourceAccount = br.readLine();
			
			System.out.println("Target Account : ");
			String targetAccount = br.readLine();
			
			System.out.println("Transfer Account : ");
			int transferAmmount = Integer.parseInt(br.readLine());
			
			int rowCount1 = st.executeUpdate("update accounts set BALANCE = BALANCE - "+transferAmmount+" where ACCNO = '"+sourceAccount+"'");
			
			int rowCount2 = st.executeUpdate("update accounts set BALANCE = BALANCE + "+transferAmmount+" where ACCNO = '"+targetAccount+"'");
			
			if (rowCount1 == 1 && rowCount2 == 1) {
				
				con.commit();
				System.out.println("Transaction Success");
				
			}else {
				con.rollback();
				System.out.println("Transaction Failed");
			}
			
			
		} catch (Exception e) {
			
			try {
				con.rollback();
				System.out.println("Transaction Failed in try");
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
