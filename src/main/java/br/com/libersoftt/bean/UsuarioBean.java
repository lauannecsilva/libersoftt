package br.com.libersoftt.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "usuarioBean")
public class UsuarioBean {

	private String email;
	private String senha;
	
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
	
	
	
}
