package com.soft.jdbc;

import java.io.FileWriter;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcApp51 {

	public static void main(String[] args) {
		Connection con  = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Reader  r  = null;
		FileWriter fw = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/durgadb","root","root");
			pst = con.prepareStatement("select * from webapps where APP_NAME = ?");
			pst.setString(1, "app1");
			rs = pst.executeQuery();
			rs.next();
			System.out.println("Application Name :"+rs.getString("APP_NAME"));
			
			fw = new FileWriter("C:/Users/Documents/note.xml");
			r = rs.getCharacterStream("DEPL_DESC");
			
			int val = r.read();
			while (val!=-1) {
				fw.write(val);
				val = r.read();
				
			}
			System.out.println("Application Deploment Discriptore retirver Successfully and sent to C:/Users/Documents/note.xml");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

}
