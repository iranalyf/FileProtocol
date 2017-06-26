package br.com.fileprotocol.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Fornecedor implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codigoFornecedor;
	
	@Column(nullable=false,length=30)
	private String descricaoFornecedor;
	
	
	public Long getCodigoFornecedor() {
		return codigoFornecedor;
	}
	public void setCodigoFornecedor(Long codigoFornecedor) {
		this.codigoFornecedor = codigoFornecedor;
	}
	public String getDescricaoFornecedor() {
		return descricaoFornecedor;
	}
	public void setDescricaoFornecedor(String descricaoFornecedor) {
		this.descricaoFornecedor = descricaoFornecedor;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoFornecedor == null) ? 0 : codigoFornecedor.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fornecedor other = (Fornecedor) obj;
		if (codigoFornecedor == null) {
			if (other.codigoFornecedor != null)
				return false;
		} else if (!codigoFornecedor.equals(other.codigoFornecedor))
			return false;
		return true;
	}
}
