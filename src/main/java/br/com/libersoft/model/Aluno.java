package br.com.libersoft.model;

import java.io.Serializable;

public class Aluno implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String nome;
	private String email;
	private String matricula;
	private String telefone;
	private String senha;
	private int idEndereco;
	private int idBibliotecario;
	
	public Aluno() {
		this.nome = "";
		this.email = "";
		this.matricula = "";
		this.telefone = "";
		this.senha = "";
		this.idEndereco = 0;
		this.idBibliotecario = 0;
	}
	
	public Aluno(String nome, String email, String matricula, String telefone, 
			String senha, int idEndereco, int idBibliotecario) {
		this.setNome(nome);
		this.setEmail(email);
		this.setMatricula(matricula);
		this.setTelefone(telefone);
		this.setSenha(senha);
		this.setIdEndereco(idEndereco);
		this.setIdBibliotecario(idBibliotecario);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public int getIdEndereco() {
		return idEndereco;
	}
	public void setIdEndereco(int idEndereco) {
		this.idEndereco = idEndereco;
	}
	public int getIdBibliotecario() {
		return idBibliotecario;
	}
	public void setIdBibliotecario(int idBibliotecario) {
		this.idBibliotecario = idBibliotecario;
	}
}
