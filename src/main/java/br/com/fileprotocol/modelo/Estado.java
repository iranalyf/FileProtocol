package br.com.fileprotocol.modelo;

import java.io.Serializable;

public class Estado implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long codigoEstado;
	private String descEstado;
	
	
	public Long getCodigoEstado() {
		return codigoEstado;
	}
	public void setCodigoEstado(Long codigoEstado) {
		this.codigoEstado = codigoEstado;
	}
	public String getDescEstado() {
		return descEstado;
	}
	public void setDescEstado(String descEstado) {
		this.descEstado = descEstado;
	}
}
