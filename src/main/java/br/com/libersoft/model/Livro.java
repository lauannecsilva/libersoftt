package br.com.libersoft.model;

public class Livro {

	
	private int id;
	private String categoria;
	private String titulo;
	private String volume;
	private String autor;
	private int quantidade;
	private String resumo;
	private int idBibliotecario;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getVolume() {
		return volume;
	}
	public void setVolume(String volume) {
		this.volume = volume;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public String getResumo() {
		return resumo;
	}
	public void setResumo(String resumo) {
		this.resumo = resumo;
	}
	public int getIdBibliotecario() {
		return idBibliotecario;
	}
	public void setIdBibliotecario(int idBibliotecario) {
		this.idBibliotecario = idBibliotecario;
	}
}
