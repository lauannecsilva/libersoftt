/*package br.com.libersoft.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.libersoft.Entity.Aluno;


public class AlunoDAO {
	private String url = "jdbc:mysql://localhost:3306/demo?useSSL=false";
	private String nomeUsuario = "root";
	private String senha = "";
	private Connection conexao;
	
	public AlunoDAO(String url, String nomeUsuario, String senha) {
		this.url = url;
		this.nomeUsuario = nomeUsuario;
		this.senha = senha;
	}
	protected void conectar() throws SQLException{
		if(conexao == null || conexao.isClosed()) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			}catch (ClassNotFoundException e) {
				throw new SQLException(e);
			}
			conexao = DriverManager.getConnection(url, nomeUsuario, senha);
		}
	}
	public void desconectar() throws SQLException{
		if(conexao != null && !conexao.isClosed()) {
			conexao.close();
		}
	}

	public boolean inserirAluno(Aluno aluno) throws SQLException{
		String sql = "INSERT INTO aluno (idAluno, nome, email, senha, cpf, telefone) VALUES (?,?,?,?,?,?)";
		conectar();
		
		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setInt(1, aluno.getId());
		statement.setString(2, aluno.getNome());
		statement.setString(3, aluno.getEmail());
		statement.setString(4, aluno.getSenha());
		statement.setString(5, aluno.getCpf());
		statement.setString(6, aluno.getTelefone());
		
		boolean inserido = statement.executeUpdate() > 0;
		statement.close();
		return inserido;
	}
	public List<Aluno> listaDeTodosOsAlunos() throws SQLException{
		List<Aluno> listaAlunos = new ArrayList<>();
		String sql = "SELECT * FROM aluno";
		
		conectar();
		
		Statement statement = conexao.createStatement();
		ResultSet resultado = statement.executeQuery(sql);
		
		while(resultado.next()) {
			int idAluno = resultado.getInt("idAluno");
			String nome = resultado.getString("nome");
			String email = resultado.getString("email");
			String senha = resultado.getString("senha");
			String cpf = resultado.getString("cpf");
			String telefone = resultado.getString("telefone");
			
			Aluno aluno = new Aluno(idAluno, nome, email, senha, cpf, telefone, null, null);
			listaAlunos.add(aluno);
		}
		resultado.close();
		statement.close();
		
		desconectar();
		
		return listaAlunos;
	}
	public boolean deletarAluno(Aluno aluno) throws SQLException{
		String sql = "DELETE FROM aluno where idAluno = ?";
		
		conectar();
		
		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setInt(1, aluno.getId());
		
		boolean deletado = statement.executeUpdate() > 0;
		statement.close();
		desconectar();
		return deletado;
	}
	
	public boolean atualizarAluno(Aluno aluno) throws SQLException{
		String sql = "UPDATE aluno SET email = ?, senha = ?, telefone = ?";
		sql += "WHERE idAluno = ?";
		conectar();
		
		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setString(1, aluno.getEmail());
		statement.setString(2, aluno.getSenha());
		statement.setString(3, aluno.getTelefone());
		
		boolean atualizado = statement.executeUpdate() > 0;
		statement.close();
		desconectar();
		return atualizado;
	}
	public Aluno exibirAluno(int idAluno) throws SQLException{
		Aluno aluno = null;
		String sql = "SELECT * FROM aluno WHERE idAluno = ?";
		
		conectar();
		
		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setInt(1, idAluno);
		
		ResultSet resultado = statement.executeQuery();
		
		if(resultado.next()) {
			String nome = resultado.getString("nome");
			String email = resultado.getString("email");
			String senha = resultado.getString("senha");
			String cpf = resultado.getString("cpf");
			String telefone = resultado.getString("telefone");
			
			aluno = new Aluno(idAluno, nome, email, senha, cpf, telefone, null, null);
		}
		resultado.close();
		statement.close();
		
		return aluno;
	}
}*/