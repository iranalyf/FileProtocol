package br.com.fileprotocol.controlador;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.fileprotocol.DAO.FornecedorDAO;
import br.com.fileprotocol.modelo.Fornecedor;
import br.com.fileprotocol.util.UtilMensagens;

@ManagedBean
@ViewScoped
public class FornecedorController implements Serializable {

	private static final long serialVersionUID = 1L;

	private Fornecedor fornecedor;
	private FornecedorDAO fornecedorDAO;
	private UtilMensagens mensagens;
	private List<Fornecedor> fornecedores;
	private Fornecedor fornecedorSelecionado;

	public FornecedorController() {
		this.fornecedorDAO = new FornecedorDAO();
		this.mensagens = new UtilMensagens();
		this.fornecedor = new Fornecedor();
	}

	public void salvar() {
		this.fornecedorDAO.salvar(fornecedor);
		this.mensagens
				.info(String.format("Fornecedor %s Cadastrado com sucesso!", fornecedor.getDescricaoFornecedor()));
	}

	public void excluir() {
		this.fornecedorDAO.excluir(fornecedorSelecionado);
		this.mensagens.info(
				String.format("Fornecedor %s excluído com sucesso.", fornecedorSelecionado.getDescricaoFornecedor()));
	}

	public void inicializaFornecedores() {
		this.fornecedores = this.fornecedorDAO.buscaTodos();
	}

	public Fornecedor getFornecedorSelecionado() {
		return fornecedorSelecionado;
	}

	public void setFornecedorSelecionado(Fornecedor fornecedorSelecionado) {
		this.fornecedorSelecionado = fornecedorSelecionado;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public List<Fornecedor> getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}

}
