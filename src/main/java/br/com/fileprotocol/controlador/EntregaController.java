package br.com.fileprotocol.controlador;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.fileprotocol.DAO.EntregaDAO;
import br.com.fileprotocol.DAO.FornecedorDAO;
import br.com.fileprotocol.DAO.UsuarioDAO;
import br.com.fileprotocol.modelo.Entrega;
import br.com.fileprotocol.modelo.Fornecedor;
import br.com.fileprotocol.modelo.Nfe;
import br.com.fileprotocol.modelo.Usuario;
import br.com.fileprotocol.util.UtilMensagens;

@ManagedBean
@ViewScoped
public class EntregaController implements Serializable {

	private static final long serialVersionUID = 1L;

	private Entrega entrega;
	private UtilMensagens utilMensagens;

	private EntregaDAO entregaDAO;
	private FornecedorDAO fornecedoresDAO;
	private UsuarioDAO usuarioDAO;

	private List<Entrega> entregas;
	private List<Fornecedor> fornecedors;
	private List<Usuario> usuarios;

	private Entrega entregaSelecionada;

	public EntregaController() {
		injecaoDependencias();
	}

	public void injecaoDependencias() {
		this.entrega = new Entrega();
		this.entregaDAO = new EntregaDAO();
		this.utilMensagens = new UtilMensagens();
		this.fornecedoresDAO = new FornecedorDAO();
		this.usuarioDAO = new UsuarioDAO();
		this.entrega.setNfe(new Nfe());
	}

	public void salvar() {
		HttpSession http = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		LoginController login = (LoginController) http.getAttribute("loginController");
		entrega.setUsuario(login.getUsuario());
		entrega.getNfe().setDataEmissaoNfe(LocalDate.now());
		this.entregaDAO.salvar(entrega);
		this.utilMensagens.info("Entrega cadastrada com Sucesso!!");
	}

	public void excluir() {
		this.entregaDAO.excluir(entregaSelecionada);
		this.utilMensagens.info("Entrega excluída com Sucesso");
	}

	public void inicializaFornecedores() {
		this.fornecedors = this.fornecedoresDAO.buscaTodos();
	}

	public void inicializarUsuarios() {
		this.usuarios = this.usuarioDAO.buscaTodos();
	}

	public void inicializaEntregas() {
		this.entregas = this.entregaDAO.buscaTodos();
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Fornecedor> getFornecedors() {
		return fornecedors;
	}

	public void setFornecedors(List<Fornecedor> fornecedors) {
		this.fornecedors = fornecedors;
	}

	public Entrega getEntrega() {
		return entrega;
	}

	public void setEntrega(Entrega entrega) {
		this.entrega = entrega;
	}

	public List<Entrega> getEntregas() {
		return entregas;
	}

	public void setEntregas(List<Entrega> entregas) {
		this.entregas = entregas;
	}

	public Entrega getEntregaSelecionada() {
		return entregaSelecionada;
	}

	public void setEntregaSelecionada(Entrega entregaSelecionada) {
		this.entregaSelecionada = entregaSelecionada;
	}

}
