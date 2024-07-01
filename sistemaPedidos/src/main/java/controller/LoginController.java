package controller;

import java.io.Serializable;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import model.Usuario;
import services.UsuarioService;

@SuppressWarnings("deprecation")
@Named
@RequestScoped
public class LoginController implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String email;
	private String senha;
	private Usuario usuario;

	@Inject
	private UsuarioService usuarioService;

	public String login() {
		usuario = usuarioService.buscarPorEmailSenha(email, senha);
		if (usuario != null) {
			// Login successful, redirect to home page
			return "home.xhtml?faces-redirect=true";
		} else {
			// Login failed
			return "login.xhtml";
		}
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
}
