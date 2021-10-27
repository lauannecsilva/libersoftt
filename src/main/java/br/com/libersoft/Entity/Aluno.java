package br.com.libersoft.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.libersoft.Entity.Bibliotecario;
import br.com.libersoft.Entity.Endereco;

//@Entity
//@Table(name = "aluno")
public class Aluno {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer idAluno;
	@Column(name = "nome")
	private String nome;
	@Column(name = "email")
	private String email;
	@Column(name = "senha")
	private String senha;
	@Column(name = "cpf")
	private String cpf;
	@Column(name = "telefone")
	private String telefone;

	public Aluno() {
	}

	public Aluno(Integer idAluno) {
		this.idAluno = idAluno;
	}

	public Aluno(Integer idAluno, String nome, String email, String senha, String cpf, String telefone,
			Endereco endereco, Bibliotecario bibliotecario) {
		this(nome, email, senha, cpf, telefone);
		this.idAluno = idAluno;
	}

	public Aluno(String nome, String email, String senha, String cpf, String telefone) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.cpf = cpf;
		this.telefone = telefone;
	}

	public Integer getId() {
		return idAluno;
	}

	public void setId(Integer id) {
		this.idAluno = id;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}