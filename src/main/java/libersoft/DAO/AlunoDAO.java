package libersoft.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import libersoft.Model.Aluno;

public class AlunoDAO {
	 	private String jdbcURL;
	    private String jdbcUsuario;
	    private String jdbcSenha;
	    private Connection jdbcConnection;

    public AlunoDAO(String jdbcURL, String jdbcUsuario, String jdbcSenha) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsuario = jdbcUsuario;
        this.jdbcSenha = jdbcSenha;
    }
    
	protected void conexao() throws SQLException {
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

	public boolean inserirALuno(Aluno aluno) throws SQLException {
		String sql = "INSERT INTO aluno (nomeCompleto, email, senha, cpf, telefone, endereco) VALUES (?, ?, ?, ?, ?, ?)";
		conexao();

		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, aluno.getnomeCompleto());
		statement.setString(2, aluno.getEmail());
		statement.setString(3, aluno.getSenha());
		statement.setString(4, aluno.getCpf());
		statement.setString(5, aluno.getTelefone());
		statement.setString(6, aluno.getEndereco());

		boolean linhaInserida = statement.executeUpdate() > 0;
		statement.close();
		desconectar();
		return linhaInserida;
	}

	public List<Aluno> listarTodosOsAlunos() throws SQLException {
		List<Aluno> listaAluno = new ArrayList<>();

		String sql = "SELECT * FROM aluno";

		conexao();

		Statement statement = jdbcConnection.createStatement();
		ResultSet resultado = statement.executeQuery(sql);

		while (resultado.next()) {
			int id_aluno = resultado.getInt("id_aluno");
			String nomeCompleto = resultado.getString("nomeCompleto");
			String email = resultado.getString("email");
			String senha = resultado.getString("senha");
			String cpf = resultado.getString("cpf");
			String telefone = resultado.getString("telefone");
			String endereco = resultado.getString("endereco");

			Aluno aluno = new Aluno(id_aluno, nomeCompleto, email, senha, cpf, telefone, endereco);
			listaAluno.add(aluno);
		}

		resultado.close();
		statement.close();

		desconectar();

		return listaAluno;
	}

	public boolean excluirAluno(Aluno aluno) throws SQLException {
		String sql = "DELETE FROM aluno where id_aluno = ?";

		conexao();

		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1, aluno.getId_aluno());

		boolean linhaDeletada = statement.executeUpdate() > 0;
		statement.close();
		desconectar();
		return linhaDeletada;
	}

	public boolean atualizarAluno(Aluno aluno) throws SQLException {
		String sql = "UPDATE aluno SET nomeCompleto = ?, email = ?, senha = ?, telefone = ?, endereco = ?";
		sql += " WHERE id_aluno = ?";
		conexao();

		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, aluno.getnomeCompleto());
		statement.setString(2, aluno.getEmail());
		statement.setString(3, aluno.getSenha());
		statement.setString(4, aluno.getTelefone());
		statement.setString(5, aluno.getEndereco());
		statement.setInt(4, aluno.getId_aluno());

		boolean rowUpdated = statement.executeUpdate() > 0;
		statement.close();
		desconectar();
		return rowUpdated;
	}

	public Aluno pegarAluno(int id_aluno) throws SQLException {
		Aluno aluno = null;
		String sql = "SELECT * FROM aluno WHERE id_aluno = ?";

		conexao();

		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1, id_aluno);

		ResultSet resultado = statement.executeQuery();

		if (resultado.next()) {
			String nomeCompleto = resultado.getString("nomeCompleto");
			String email = resultado.getString("email");
			String senha = resultado.getString("senha");
			String cpf = resultado.getString("cpf");
			String telefone = resultado.getString("telefone");
			String endereco = resultado.getString("endereco");

			aluno = new Aluno(id_aluno, nomeCompleto, email, senha, cpf, telefone, endereco);
		}

		resultado.close();
		statement.close();
		return aluno;
	}
}