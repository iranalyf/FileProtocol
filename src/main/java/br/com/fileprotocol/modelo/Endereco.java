package br.com.fileprotocol.modelo;

import java.io.Serializable;

public class Endereco implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long codigoEndereco;
	private Long numeroEndereco;
	private String complementoEndereco;
	private String logradouroEndereco;
	private String cepEndereco;
	private Cidade cidade;
	
	
	public Long getCodigoEndereco() {
		return codigoEndereco;
	}
	public void setCodigoEndereco(Long codigoEndereco) {
		this.codigoEndereco = codigoEndereco;
	}
	public Long getNumeroEndereco() {
		return numeroEndereco;
	}
	public void setNumeroEndereco(Long numeroEndereco) {
		this.numeroEndereco = numeroEndereco;
	}
	public String getComplementoEndereco() {
		return complementoEndereco;
	}
	public void setComplementoEndereco(String complementoEndereco) {
		this.complementoEndereco = complementoEndereco;
	}
	public String getLogradouroEndereco() {
		return logradouroEndereco;
	}
	public void setLogradouroEndereco(String logradouroEndereco) {
		this.logradouroEndereco = logradouroEndereco;
	}
	public String getCepEndereco() {
		return cepEndereco;
	}
	public void setCepEndereco(String cepEndereco) {
		this.cepEndereco = cepEndereco;
	}
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}	
}
