package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class DAO {
	Connection conexao;
	PreparedStatement stmt;
	ResultSet rs;
	
	public void open() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/libersoft", "root", "1311");
	}
	public void close() throws Exception{
		conexao.close();
	}

}
