package com.soft.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class JdbcApp23 {

	public static void main(String[] args) {
		try(
				
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","durga");
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("select * from customer");
		) {
			ResultSetMetaData md = rs.getMetaData();
			int column_Count = md.getColumnCount();
			for (int i = 1; i <= column_Count; i++) {
				System.out.print(md.getColumnName(i)+"\t");
			}
			System.out.println();
			System.out.println("============================");
			while (rs.next()) {
				for (int j = 1; j < column_Count; j++) {
					System.out.print(rs.getString(j)+"\t");
				}
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
