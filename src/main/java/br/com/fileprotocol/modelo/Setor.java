package br.com.fileprotocol.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Setor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigoSetor;

	@Enumerated(EnumType.STRING)
	private Setores setor;

	public Long getCodigoSetor() {
		return codigoSetor;
	}

	public void setCodigoSetor(Long codigoSetor) {
		this.codigoSetor = codigoSetor;
	}

	public Setores getSetor() {
		return setor;
	}

	public void setSetor(Setores setor) {
		this.setor = setor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoSetor == null) ? 0 : codigoSetor.hashCode());
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
		Setor other = (Setor) obj;
		if (codigoSetor == null) {
			if (other.codigoSetor != null)
				return false;
		} else if (!codigoSetor.equals(other.codigoSetor))
			return false;
		return true;
	}
}
