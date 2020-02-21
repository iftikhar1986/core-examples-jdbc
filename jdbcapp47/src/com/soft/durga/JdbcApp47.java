package com.soft.durga;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcApp47 {

	public static void main(String[] args) {
		Connection con =null;
		PreparedStatement pst = null;
		BufferedReader br = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/durgadb","root","root");
			
			pst = con.prepareStatement("select * from emp1 ",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs = pst.executeQuery();
			rs.moveToInsertRow();
			br = new BufferedReader(new InputStreamReader(System.in));
			while (true) {
				System.out.print("Employee Number : ");
				int eno = Integer.parseInt(br.readLine());
				
				System.out.print("Employee Name : ");
				String ename = br.readLine();
				
				System.out.print("Employee Salary : ");
				float esal = Float.parseFloat(br.readLine());
				
				System.out.print("Employee Address : ");
				String eaddr = br.readLine();
				
				rs.updateInt(1, eno);
				rs.updateString(2, ename);
				rs.updateFloat(3, esal);
				rs.updateString(4,eaddr);
				
				rs.insertRow();
				
				System.out.println("Employee "+eno+" Inserted Successfully");
				System.out.println("One More Employee[y/n : ");
				
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
