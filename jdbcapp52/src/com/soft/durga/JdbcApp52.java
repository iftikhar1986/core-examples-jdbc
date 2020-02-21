package com.soft.durga;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcApp52 {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/durgadb","root","root");
			pst = con.prepareStatement("select * from emp1",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs = pst.executeQuery();
			
			while (rs.next()) {
				float esal = rs.getFloat("ESAL");
				if (esal < 10000) {
					float new_Sal = esal + 500;
					rs.updateFloat("ESAL", new_Sal);
					rs.updateRow();
					System.out.println("Employee "+rs.getInt("ENO")+"Updated Successfully");
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
