package br.com.libersoft.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import br.com.libersoft.Entity.Aluno;

public class AlunoDAO {
	private String url = "jdbc:mysql://localhost:3306/demo?useSSL=false";
	private String usuario = "root";
	private String senha = "";

	private static final String INSERT_ALUNOS_SQL = "INSERT INTO alunos" + "  (nome, email, senha, cpf, telefone) VALUES "
			+ " (?, ?, ?, ?, ?);";

	private static final String SELECIONAR_ALUNO_POR_ID = "select id, nome, email, telefone, cpf from aluno where id =?";
	private static final String SELECIONAR_TODOS_OS_ALUNOS = "select * from aluno";
	private static final String DELETETAR_ALUNO_POR_ID = "delete from aluno where id = ?;";
	private static final String ATUALIZAR_ALUNOS_SQL = "update aluno set nome = ?,email= ?, senha =?, telefone =? where id = ?;";

	public AlunoDAO() {}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, usuario, senha);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public void inserirAluno(Aluno aluno) throws SQLException {
		System.out.println(INSERT_ALUNOS_SQL);
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ALUNOS_SQL)) {
			preparedStatement.setString(1, aluno.getNome());
			preparedStatement.setString(2, aluno.getEmail());
			preparedStatement.setString(3, aluno.getSenha());
			preparedStatement.setString(4, aluno.getCpf());
			preparedStatement.setString(5, aluno.getTelefone());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public Aluno selecionarAluno(int id) {
		Aluno aluno = null;
		
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECIONAR_ALUNO_POR_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String nome = rs.getString("nome");
				String email = rs.getString("email");
				String senha = rs.getString("senha");
				String cpf = rs.getString("cpf");
				String telefone = rs.getString("telefone");
				aluno = new Aluno(id,nome, email, senha, cpf, telefone, null, null);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return aluno;
	}

	public List<Aluno> selectAlunos() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Aluno> alunos = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECIONAR_TODOS_OS_ALUNOS);) {
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				String email = rs.getString("email");
				String senha = rs.getString("senha");
				String cpf = rs.getString("cpf");
				String telefone = rs.getString("telefone");
				alunos.add(new Aluno(id,nome, email, senha, cpf, telefone, null, null));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return alunos;
	}

	public boolean deleteUser(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETETAR_ALUNO_POR_ID);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean editarAluno(Aluno aluno) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(ATUALIZAR_ALUNOS_SQL);) {
			statement.setString(1, aluno.getNome());
			statement.setString(2, aluno.getEmail());
			statement.setString(3, aluno.getSenha());
			statement.setString(4, aluno.getTelefone());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

}