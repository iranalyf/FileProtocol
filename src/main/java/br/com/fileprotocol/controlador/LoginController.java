package br.com.fileprotocol.controlador;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.fileprotocol.DAO.UsuarioDAO;
import br.com.fileprotocol.modelo.Usuario;
import br.com.fileprotocol.util.UtilMensagens;

@ManagedBean
@SessionScoped
public class LoginController implements Serializable {

	private static final long serialVersionUID = 1L;

	private String email;
	private String senha;
	private Usuario usuario;
	private UtilMensagens messages;

	private UsuarioDAO usuarioDAO;

	public LoginController() {
		limpar();
	}

	public void limpar() {
		this.usuarioDAO = new UsuarioDAO();
		this.messages = new UtilMensagens();
	}

	public Usuario login() {
		usuario = this.usuarioDAO.login(email, senha);

		if (usuario != null) {
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("Home.xhtml");
			} catch (IOException e) {

				e.printStackTrace();
			}
		} else {
			this.messages.error("Usuario e/ou Senha Inválidos");
		}
		return null;
	}

	public void invalidateSession() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

}
