package com.soft.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

/*
 create or replace procedure getSal(no IN number,sal OUT float)
 AS
 BEGIN
 select ESAL into sal from emp1 where eno = no;
 END getSal;
 /
 */
public class JdbcApp54 {

	public static void main(String[] args) {
		
		Connection con = null;
		CallableStatement cst = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","durga");
			cst = con.prepareCall("{call getSal(?,?)}");
			cst.setInt(1, 111);
			cst.registerOutParameter(2, Types.FLOAT);
			cst.execute();
			
			System.out.println("111 Employe Salary : "+cst.getFloat(2));
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
