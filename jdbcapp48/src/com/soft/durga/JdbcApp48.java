package com.soft.durga;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JdbcApp48 {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pst = null;
		FileInputStream fis = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/durgadb","root","root");
			pst = con.prepareStatement("insert into emp2 values(?,?)");
			pst.setInt(1, 111);
			File f = new File("Untitled.png");
			fis =  new FileInputStream(f);
			pst.setBinaryStream(2, fis,f.length());
			int rowCount = pst.executeUpdate();
			System.out.println("Employee 111 Inserted Seccussfully with an Image :"+rowCount);
			 
			
			
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
