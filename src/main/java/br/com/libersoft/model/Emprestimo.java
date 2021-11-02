package br.com.libersoft.model;

import java.util.Date;

public class Emprestimo {
	
	private int id;
	private int idLivro;
	private int idAluno;
	private int idBibliotecario;
	private Date dataEmprestimo;
	private Date dataRenovacao;
	private Date davaDevolucao;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdLivro() {
		return idLivro;
	}
	public void setIdLivro(int idLivro) {
		this.idLivro = idLivro;
	}
	public int getIdAluno() {
		return idAluno;
	}
	public void setIdAluno(int idAluno) {
		this.idAluno = idAluno;
	}
	public int getIdBibliotecario() {
		return idBibliotecario;
	}
	public void setIdBibliotecario(int idBibliotecario) {
		this.idBibliotecario = idBibliotecario;
	}
	public Date getDataEmprestimo() {
		return dataEmprestimo;
	}
	public void setDataEmprestimo(Date dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}
	public Date getDataRenovacao() {
		return dataRenovacao;
	}
	public void setDataRenovacao(Date dataRenovacao) {
		this.dataRenovacao = dataRenovacao;
	}
	public Date getDavaDevolucao() {
		return davaDevolucao;
	}
	public void setDavaDevolucao(Date davaDevolucao) {
		this.davaDevolucao = davaDevolucao;
	}
}
