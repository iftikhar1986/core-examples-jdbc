package com.soft.jdbc;

import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JdbcApp50 {

	public static void main(String[] args) {
		Connection con  = null;
		PreparedStatement pst = null;
		FileReader fr = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con  = DriverManager.getConnection("jdbc:mysql://localhost:3306/durgadb","root","root");
			pst = con.prepareStatement("insert into webapps values(?,?)");
			pst.setString(1, "app1");
			File file = new File("C:/Users/Syed/Documents/note.xml");
			fr = new FileReader(file);
			pst.setCharacterStream(2, fr,file.length());
			pst.executeUpdate();
			System.out.println("Web Application Inserted Successflly ");
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
