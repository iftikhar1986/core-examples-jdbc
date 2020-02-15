/* Updation of bones and salary, records in Tables*/

package com.soft.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

import oracle.jdbc.driver.OracleDriver;

public class JdbcApp06 {

	public static void main(String[] args) {

		Scanner scanner = null;
		Connection con = null;
		Statement st = null;

		try {
			DriverManager.registerDriver(new OracleDriver());
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "durga");
			st = con.createStatement();

			scanner = new Scanner(System.in);

			System.out.print("Salary Range : ");
			float sal_Range = scanner.nextFloat();

			System.out.print("Bonus Amount : ");
			int bonus_Amt = scanner.nextInt();

			int rowCount = st.executeUpdate("update emp1 set ESAL = ESAL + " + bonus_Amt + "where ESAL < " + sal_Range);
			System.out.println("Records Updated : " + rowCount);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				scanner.close();
				con.close();
				st.close();

			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}

	}

}
