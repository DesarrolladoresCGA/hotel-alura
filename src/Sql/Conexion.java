package Sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Conexion {
	public static final String URL = "jdbc:mysql://localhost:3306/hotelalura";
	public static final String USERNAME = "root";
	public static final String PASSWORD = "";
	
	PreparedStatement ps;
	ResultSet rs;	
	
	public static Connection getConection() {
		
		Connection con = null;
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			
		} catch (Exception e) {
			System.out.println("Error al conectarse a la BBDD "+ e);
		}
		return con;
	}
}
