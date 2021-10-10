package br.com.libersoftt.entity;

import java.sql.Date;

import br.com.libersoftt.entity.Aluno;
import br.com.libersoftt.entity.Bibliotecario;
import br.com.libersoftt.entity.Livro;

public class EmprestimoLivro {

	private Integer id;
	private Date data_emprestimo;
	private Date data_renovacao;
	private Date data_devolucao;
	private String status;
	private Livro livros;
	private Aluno aluno;
	private Bibliotecario bibliotecario;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getData_emprestimo() {
		return data_emprestimo;
	}
	public void setData_emprestimo(Date data_emprestimo) {
		this.data_emprestimo = data_emprestimo;
	}
	public Date getData_renovacao() {
		return data_renovacao;
	}
	public void setData_renovacao(Date data_renovacao) {
		this.data_renovacao = data_renovacao;
	}
	public Date getData_devolucao() {
		return data_devolucao;
	}
	public void setData_devolucao(Date data_devolucao) {
		this.data_devolucao = data_devolucao;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Livro getLivros() {
		return livros;
	}
	public void setLivros(Livro livros) {
		this.livros = livros;
	}
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public Bibliotecario getBibliotecario() {
		return bibliotecario;
	}
	public void setBibliotecario(Bibliotecario bibliotecario) {
		this.bibliotecario = bibliotecario;
	}
	
	
}
