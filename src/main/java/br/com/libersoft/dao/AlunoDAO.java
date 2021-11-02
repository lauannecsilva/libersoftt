package br.com.libersoft.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;

import br.com.libersoft.factory.ConnectionFactory;
import br.com.libersoft.model.Aluno;

public class AlunoDAO {
	
	public void save(Aluno aluno) {
		
		String sql = "INSERT INTO aluno(nome, email, telefone, matricula, senha, fk_id_endereco, fk_id_bibli) VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, aluno.getNome());
			pstm.setString(2, aluno.getEmail());
			pstm.setString(3, aluno.getTelefone());
			pstm.setString(4, aluno.getMatricula());
			pstm.setString(5, aluno.getSenha());
			pstm.setInt(6, aluno.getIdEndereco());
			pstm.setInt(7, aluno.getIdBibliotecario());
			
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
