package com.soft.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JdbcApp39 {

	public static void main(String[] args) {

		Connection con  = null;
		PreparedStatement pst = null;
		BufferedReader br = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/durgadb","root","root");
			pst = con.prepareStatement("insert into emp1 values(?,?,?,?)");
			br = new BufferedReader(new InputStreamReader(System.in));
			
			while (true) {
				System.out.print("Employee Number : ");
				int eno = Integer.parseInt(br.readLine());
				
				System.out.print("Employee Name : ");
				String ename = br.readLine();
				
				System.out.print("Employee Salary : ");
				Float esal = Float.parseFloat(br.readLine());
				
				System.out.print("Employee Address : ");
				String eaddr = br.readLine();
				
				pst.setInt(1, eno);
				pst.setString(2, ename);
				pst.setFloat(3, esal);
				pst.setString(4, eaddr);
				
				pst.executeUpdate();
				
				System.out.println("Employee Inserted Successfully");
				
				System.out.print("One more Employeee[y/n] : ");
				
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
