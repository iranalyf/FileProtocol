package br.com.fileprotocol.modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Nfe implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigoNfe;

	@NotEmpty(message = "Numero da NFe deve ser Informado")
	@Column(nullable = false, length = 20)
	private String numeroNfe;

	private LocalDate dataEmissaoNfe;

	@NotNull(message = "Data de Vencimento da Nfe deve ser Informado")
	private Date dataVencimentoNfe;

	public Long getCodigoNfe() {
		return codigoNfe;
	}

	public void setCodigoNfe(Long codigoNfe) {
		this.codigoNfe = codigoNfe;
	}

	public String getNumeroNfe() {
		return numeroNfe;
	}

	public void setNumeroNfe(String numeroNfe) {
		this.numeroNfe = numeroNfe;
	}

	public LocalDate getDataEmissaoNfe() {
		return dataEmissaoNfe;
	}

	public void setDataEmissaoNfe(LocalDate dataEmissaoNfe) {
		this.dataEmissaoNfe = dataEmissaoNfe;
	}

	public Date getDataVencimentoNfe() {
		return dataVencimentoNfe;
	}

	public void setDataVencimentoNfe(Date dataVencimentoNfe) {
		this.dataVencimentoNfe = dataVencimentoNfe;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoNfe == null) ? 0 : codigoNfe.hashCode());
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
		Nfe other = (Nfe) obj;
		if (codigoNfe == null) {
			if (other.codigoNfe != null)
				return false;
		} else if (!codigoNfe.equals(other.codigoNfe))
			return false;
		return true;
	}
}
