package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String password = "root";
	private String nameDataBase = "db_insurances?useSSL=false&serverTimezone=UTC";

	// This can be wrong..
	public Conexion ()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}	
	
	public Connection getConection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(host + nameDataBase, this.user, this.password);
			return connection;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
