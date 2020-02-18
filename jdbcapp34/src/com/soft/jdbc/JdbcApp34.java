package com.soft.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcApp34 {

	public static void main(String[] args) {
		
		Connection con = null;
		Statement st  = null;
		ResultSet rs = null;
		BufferedReader br = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/durgadb","root","root");
			st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs = st.executeQuery("select * from emp1");
			rs.moveToInsertRow();
			br = new BufferedReader(new InputStreamReader(System.in));
			while (true) {
				System.out.println("Employee Number : ");
				int eno = Integer.parseInt(br.readLine());
				System.out.println("Employee Name : ");
				String ename = br.readLine();
				System.out.println("Employee Salary : ");
				float esal = Float.parseFloat(br.readLine());
				System.out.println("Employee Address : ");
				String eaddr = br.readLine();
				
				rs.updateInt(1, eno);
				rs.updateString(2,ename);
				rs.updateFloat(3,esal);
				rs.updateString(4, eaddr);
				
				rs.insertRow();
				
				System.out.println("Employe "+eno+" Inserted Successfully");
				System.out.println("One More Employee?[y/n]");
				String option = br.readLine();
				if (option.equalsIgnoreCase("y")) {
					continue;
				}else {
					break;
				}
				
			}
			
			
		} catch (Exception e) {
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
