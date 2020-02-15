/*Q:Write JDBC program that insert record in to database table ,
 * by talking records data as dynamic input? 
 */

package com.soft.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcApp05 {

	public static void main(String[] args) {

		// Declaring and initilizing local varibale
		BufferedReader br = null;
		Connection con = null;
		Statement st = null;

		try {
			// In type-4 Load and register driver is optional
			// Class.forName("oracle.jdbc.OracleDriver");

			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "durga");
			st = con.createStatement();

			br = new BufferedReader(new InputStreamReader(System.in));

			while (true) {
				System.out.print("Employee Number :");
				int eno = Integer.parseInt(br.readLine());

				System.out.print("Employee Name   :");
				String ename = br.readLine();

				System.out.print("Employe Salary  :");
				float esal = Float.parseFloat(br.readLine());

				System.out.print("Employee Address   :");
				String eaddr = br.readLine();

				// Note : Preparing Insert Query is little bit diffucelt.So Intention
				// insert into emp1 values(111,'AAA',5000,'Hyd')

				st.executeQuery("insert into emp1 values(" + eno + ",'" + ename + "'," + esal + ",'" + eaddr + "')");
				System.out.println("Employee " + eno + " Inserted Successfully");

				System.out.print("One More Employed ? [Yes/No] : ");
				String option = br.readLine();

				if (option.equalsIgnoreCase("yes")) {
					continue;
				} else {
					break;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				br.close();
				st.close();
				con.close();

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

}
