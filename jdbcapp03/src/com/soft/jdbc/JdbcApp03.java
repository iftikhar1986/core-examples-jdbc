/*Write a JDBC Program to Create Table in DB by Taking table name,
 * table columns and their data types and sizes as dynamic input by using Type-4 Driver.
 * 
 */

package com.soft.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcApp03 {

	public static void main(String[] args) {
		
		Connection con = null;
		Statement st = null;
		BufferedReader br = null;
		
		try {
			//Step 1 : Load And Register The Connection
			Class.forName("oracle.jdbc.OracleDriver");
			
			//Step 2 : Get Connection
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "durga");
			
			//Step 3 : Create Statement
			st = con.createStatement();
			
			//Getting Input for Table name 
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter Table Name : ");
			String tname = br.readLine();
			
			
		    //Create table
			String query = "create table "+tname+"(ENO number(3) primary key,ENAME varchar2(10),ESAL float(5),EADDR varchar2(10))";
			
			//Step 4:Excute Query
			st.executeUpdate(query);
			
			//Confirmation that Table is create
			System.out.println("Table "+tname+" was created successfully");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				//Step 5 : close the resources
				st.close();
				br.close();
				con.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
		

	}

}
