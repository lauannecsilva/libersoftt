package br.com.libersoft.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	private static final String USERNAME = "root";
	private static final String PASSWORD = "123@start";
	private static final String DATABASE_URL = "jdbc:mysql://localhost/libersoft?useJDBCCompliantTimezoneShift=true, useLegacyDatetimeCode=false&serverTimezone=UTC";
	
	public static Connection createConnectionToMySQL() throws Exception {
		// classe será carregada pela JVM
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		
		return connection;
	}
	
	public static void main(String[] args) throws Exception {
		Connection con = createConnectionToMySQL();
		
		if (con != null) {
			System.out.println("Conexão obtida com sucesso.");
			con.close();
		}
	}
}
