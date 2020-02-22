package com.soft.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

/*
 create or repalce function getAVG(no1 IN number,no2 IN number)return float
 AS
 sal1 Float;
 sal2 Float;
 BEGIN
 	select ESAL into sal1 from emp1 where ENO = no1;
 	select ESAL into sal2 from emp2 where ENO = no2;
 	return(sal1+sal2)/2;
 
 END getAVG;
 /

 * */
public class JdbcApp55 {
public static void main(String[] args) {
		
		Connection con = null;
		CallableStatement cst = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","durga");
			cst = con.prepareCall("{? = call getAVG(?,?)}");
			cst.setInt(2, 111);
			cst.setInt(3, 222);
			cst.registerOutParameter(2, Types.FLOAT);
			cst.execute();
			
			System.out.println("Average Employe Salary : "+cst.getFloat(2));
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
