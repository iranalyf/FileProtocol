package br.com.fileprotocol.controlador;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.fileprotocol.DAO.UsuarioDAO;
import br.com.fileprotocol.modelo.Setor;
import br.com.fileprotocol.modelo.Setores;
import br.com.fileprotocol.modelo.Usuario;
import br.com.fileprotocol.util.UtilMensagens;

@ManagedBean
@ViewScoped
public class UsuarioController implements Serializable {

	private static final long serialVersionUID = 1L;

	private Usuario usuario;
	private UsuarioDAO usuarioDAO;
	private UtilMensagens utilMensagens;
	private List<Usuario> usuarios;
	private Usuario usuarioSelecionado;

	public UsuarioController() {
		this.usuario = new Usuario();
		this.usuarioDAO = new UsuarioDAO();
		this.utilMensagens = new UtilMensagens();
		this.usuario.setSetor(new Setor());
	}

	public void salvar() {
		this.usuarioDAO.salvar(usuario);
		this.utilMensagens.info(String.format("Usuario %s cadastrado p/ o setor %s com Sucesso.", usuario.getNome(),
				usuario.getSetor().getSetor().getDescricao()));
	}

	public void excluir() {
		this.usuarioDAO.excluir(usuarioSelecionado);
		this.utilMensagens.info(String.format("Usuário %s excluído com Sucesso", this.usuarioSelecionado.getNome()));
	}

	public void inicializaUsuarios() {
		this.usuarios = this.usuarioDAO.buscaTodos();
	}

	public Usuario getUsuarioSelecionado() {
		return usuarioSelecionado;
	}

	public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
		this.usuarioSelecionado = usuarioSelecionado;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Setores[] getSetores() {
		return Setores.values();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
