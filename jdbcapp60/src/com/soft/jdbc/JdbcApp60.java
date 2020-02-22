package com.soft.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JdbcApp60 {

	public static void main(String[] args) {
		Connection oracleCon = null;
		Connection mysqlCon = null;

		PreparedStatement oraclePst = null;
		PreparedStatement mysqlPst = null;

		BufferedReader br = null;

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Class.forName("com.mysql.cj.jdbc.Driver");

			oracleCon = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "durga");
			mysqlCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/durgadb", "root", "root");

			oracleCon.setAutoCommit(false);
			mysqlCon.setAutoCommit(false);

			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Source Account : ");
			String sourceAccount = br.readLine();

			System.out.println("Target Account : ");
			String targetAccount = br.readLine();

			System.out.println("Transfer Account : ");
			int transferAmount = Integer.parseInt(br.readLine());

			oraclePst = oracleCon.prepareStatement("update accounts set BALANCE = BALANCE - ? where ACCNO = ?");
			oraclePst.setInt(1, transferAmount);
			oraclePst.setString(2, sourceAccount);
			int oracleRowCount = oraclePst.executeUpdate();

			mysqlPst = mysqlCon.prepareStatement("update accounts set BALANCE = BALANCE + ? where ACCNO = ?");
			mysqlPst.setInt(1, transferAmount);
			mysqlPst.setString(2, targetAccount);
			int mysqlRowCount = mysqlPst.executeUpdate();

			if (oracleRowCount == 1 && mysqlRowCount == 1) {

				oracleCon.commit();
				mysqlCon.commit();
				System.out.println("Transaction Success");

			} else {
				oracleCon.rollback();
				mysqlCon.rollback();
				System.out.println("Transaction Failed");
			}
			// mysqlPst = mysqlCon.prepareStatement("");

		} catch (Exception e) {
			try {
				oracleCon.rollback();
				mysqlCon.rollback();
				System.out.println("Transaction Failed in try");
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				oracleCon.close();
				mysqlCon.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
