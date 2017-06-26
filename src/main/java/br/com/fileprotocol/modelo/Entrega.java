package br.com.fileprotocol.modelo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Entrega implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigoEntrega;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "nfe_id")
	private Nfe nfe;

	@OneToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	@NotNull(message = "Fornecedor deve ser Selecionado")
	@OneToOne
	@JoinColumn(name = "fornecedor_id")
	private Fornecedor fornecedor;

	@NotNull(message = "Usuario destino deve ser Selecionado")
	@OneToOne
	@JoinColumn(name = "usuario_destino_id")
	private Usuario usuarioDestino;

	private String observacao;

	public Long getCodigoEntrega() {
		return codigoEntrega;
	}

	public void setCodigoEntrega(Long codigoEntrega) {
		this.codigoEntrega = codigoEntrega;
	}

	public Nfe getNfe() {
		return nfe;
	}

	public void setNfe(Nfe nfe) {
		this.nfe = nfe;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Usuario getUsuarioDestino() {
		return usuarioDestino;
	}

	public void setUsuarioDestino(Usuario usuarioDestino) {
		this.usuarioDestino = usuarioDestino;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoEntrega == null) ? 0 : codigoEntrega.hashCode());
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
		Entrega other = (Entrega) obj;
		if (codigoEntrega == null) {
			if (other.codigoEntrega != null)
				return false;
		} else if (!codigoEntrega.equals(other.codigoEntrega))
			return false;
		return true;
	}
}
