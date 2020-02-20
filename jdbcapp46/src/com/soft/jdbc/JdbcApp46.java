package com.soft.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcApp46 {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/durgadb","root","root"); 
			pst = con.prepareStatement("Select * from emp1", ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs = pst.executeQuery();
			System.out.println("Employee Details in forward Direction");
			System.out.println("ENO\tENAME\tESAL\tEADDR");
			System.out.println("-------------------------------------------");
			while (rs.next()) {
				System.out.print(rs.getInt("ENO")+"\t");
				System.out.print(rs.getString("ENAME")+"\t");
				System.out.print(rs.getFloat("ESAL")+"\t");
				System.out.print(rs.getString("EADDR")+"\n");
				
			}
			
			System.out.println();
			
			System.out.println("Employee Details in Backward Direction");
			System.out.println("ENO\tENAME\tESAL\tEADDR");
			System.out.println("-------------------------------------------");
			while (rs.previous()){
				System.out.print(rs.getInt("ENO")+"\t");
				System.out.print(rs.getString("ENAME")+"\t");
				System.out.print(rs.getFloat("ESAL")+"\t");
				System.out.print(rs.getString("EADDR")+"\n");
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				con.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

	}

}
