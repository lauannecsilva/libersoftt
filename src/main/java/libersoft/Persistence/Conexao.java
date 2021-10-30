package libersoft.Persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	private String jdbcURL;
	private String jdbcUsuario;
	private String jdbcSenha;
	private Connection jdbcConnection;

	public Conexao(String jdbcURL, String jdbcUsuario, String jdbcSenha) {
		this.jdbcURL = jdbcURL;
		this.jdbcUsuario = jdbcUsuario;
		this.jdbcSenha = jdbcSenha;
	}

	public void conexao() throws SQLException {
		if (jdbcConnection == null || jdbcConnection.isClosed()) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				throw new SQLException(e);
			}
			jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsuario, jdbcSenha);
		}
	}

	protected void desconectar() throws SQLException {
		if (jdbcConnection != null && !jdbcConnection.isClosed()) {
			jdbcConnection.close();
		}
	}
}
