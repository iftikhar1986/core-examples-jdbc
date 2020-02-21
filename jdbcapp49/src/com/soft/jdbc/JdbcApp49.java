package com.soft.jdbc;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcApp49 {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		InputStream is = null;
		FileOutputStream fos = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/durgadb","root","root");
			pst = con.prepareStatement("select * from emp2 where ENO = ?");
			pst.setInt(1, 111);
			rs = pst.executeQuery();
			rs.next();
			System.out.println("Enployee Number : "+rs.getInt("ENO"));
			
			fos = new FileOutputStream("Nagoor.png");
			is = rs.getBinaryStream("EMP_IMAGE");
			
			int val = is.read();
			while (val!=-1) {
				fos.write(val);
				val = is.read();
				
			}
			System.out.println("Employee Image is Retriver Successfully, and sent to Current file as name Nagoor.png");
			
			
			
			
			
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
