package libersoft.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


//@Entity
//@Table(name = "aluno")
public class Aluno {
	//@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	//@Column(name = "id_aluno")
	private int id_aluno;
	//@Column(name = "nomeCompleto")
	private String nomeCompleto;
	//@Column(name = "email")
	private String email;
	//@Column(name = "senha")
	private String senha;
	//@Column(name = "cpf")
	private String cpf;
	//@Column(name = "telefone")
	private String telefone;
	//@Column(name = "endereco")
	private String endereco;

	public Aluno() {
	}

	public Aluno(int id_aluno) {
		this.id_aluno = id_aluno;
	}

	public Aluno(int id_aluno, String nomeCompleto, String email, String senha, String cpf, String telefone,
			String endereco) {
		this(nomeCompleto, email, senha, cpf, telefone, endereco);
		this.id_aluno = id_aluno;
	}

	public Aluno(String nomeCompleto, String email, String senha, String cpf, String telefone, String endereco) {
		this.nomeCompleto = nomeCompleto;
		this.email = email;
		this.senha = senha;
		this.cpf = cpf;
		this.telefone = telefone;
		this.endereco = endereco;
	}

	public Integer getId_aluno() {
		return id_aluno;
	}

	public void setId_aluno(int id_aluno) {
		this.id_aluno = id_aluno;
	}

	public String getnomeCompleto() {
		return nomeCompleto;
	}

	public void setnomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
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
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
}