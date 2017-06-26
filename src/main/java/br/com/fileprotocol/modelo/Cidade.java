package br.com.fileprotocol.modelo;

import java.io.Serializable;

public class Cidade implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long codigoCidade;
	private String descCidade;
	private Estado estado;
	
	
	public Long getCodigoCidade() {
		return codigoCidade;
	}
	public void setCodigoCidade(Long codigoCidade) {
		this.codigoCidade = codigoCidade;
	}
	public String getDescCidade() {
		return descCidade;
	}
	public void setDescCidade(String descCidade) {
		this.descCidade = descCidade;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}	
}
