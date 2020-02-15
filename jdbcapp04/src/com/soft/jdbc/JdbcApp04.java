/* Write a program , that get (table name, column name, there data type and size ) dynamically
 * by Using  Type-4 driver.
 * Example : create table emp1(ENO number(3),ENAME varchar2(10),
 * 							   ESAL float(5),EADDR varchar2(10),
 * 							   primary key(ENO));
 * */
package com.soft.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.zip.InflaterInputStream;

public class JdbcApp04 {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		BufferedReader br = null;

		try {
			// Load And Register a Driver
			Class.forName("oracle.jdbc.OracleDriver");

			// Get Connection
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "durga");

			// Create Statement
			st = con.createStatement();

			// For taking dynamic Input we should Declare BufferReader
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Table Name : ");
			String tname = br.readLine();

			String primary_key_Cols = "";

			/*
			 * Creating Query Example : create table emp1(ENO number(3),ENAME varchar2(10),
			 * ESAL float(5),EADDR varchar2(10), primary key(ENO,ENAME));
			 */
			String query = "";
			query = query + "create table " + tname + "(";
			int primary_key_Count = 0;
			while (true) {
				System.out.print("Column Name :");
				String col_name = br.readLine();
				System.out.print("Column DataType and Size :");
				String col_Type_size = br.readLine();
				System.out.print("Is it Primary key Colum[Yes/No] :");
				String primary_key_Option = br.readLine();

				if (primary_key_Option.equalsIgnoreCase("yes")) {
					primary_key_Count = primary_key_Count + 1;

					if (primary_key_Count == 1) {
						primary_key_Cols = primary_key_Cols + col_name;

					} else {
						primary_key_Cols = primary_key_Cols + "," + col_name;

					}
				}
				query = query + col_name + " " + col_Type_size;

				System.out.print("Do You Want To Add One More Coloum[Yes/No] :");
				String option = br.readLine();

				if (option.equalsIgnoreCase("yes")) {
					query = query + ",";
				} else {
					query = query + "," + "primary Key(" + primary_key_Cols + "))";
					break;
				}
			}
			//System.out.println(query);
			st.executeUpdate(query);
			System.out.println("Table "+tname+" is Created Successfully");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				st.close();
				con.close();	
			}catch(Exception e1){
				e1.printStackTrace();
			}
			
		}

	}

}
