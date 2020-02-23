package com.soft.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.MysqlDataSource;

public class JdbcApp63 {

	public static void main(String[] args) {
		//Get Connection Object from connection pooling provided by MysqlDataSource


		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			MysqlDataSource ds = new MysqlDataSource();
			
			ds.setURL("jdbc:mysql://localhost:3306/durgadb");
			ds.setUser("root");
			ds.setPassword("root");
	
			con = ds.getConnection();
			st  = con.createStatement();
			rs = st.executeQuery("select * from emp1");
		
		
			System.out.println("ENO\tENAME\tESAL\tEADDR");
			System.out.println("------------------------");
			
			while (rs.next()) {
				System.out.print(rs.getInt("ENO")+"\t");
				System.out.print(rs.getString("ENAME")+"\t");
				System.out.print(rs.getFloat("ESAL")+"\t");
				System.out.print(rs.getString("EADDR")+"\n");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}


	
		

	

	}

}
