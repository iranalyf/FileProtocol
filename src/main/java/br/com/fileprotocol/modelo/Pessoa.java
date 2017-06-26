package br.com.fileprotocol.modelo;

import java.io.Serializable;

import org.apache.poi.ss.usermodel.DateUtil;

public class Pessoa implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long codigoPessoa;
	private String nomePessoa;
	private DateUtil dataNascimentoPessoa;
	private String cpfPessoa;
	private Endereco endereco;
	
	
	public Long getCodigoPessoa() {
		return codigoPessoa;
	}
	public void setCodigoPessoa(Long codigoPessoa) {
		this.codigoPessoa = codigoPessoa;
	}
	public String getNomePessoa() {
		return nomePessoa;
	}
	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}
	public DateUtil getDataNascimentoPessoa() {
		return dataNascimentoPessoa;
	}
	public void setDataNascimentoPessoa(DateUtil dataNascimentoPessoa) {
		this.dataNascimentoPessoa = dataNascimentoPessoa;
	}
	public String getCpfPessoa() {
		return cpfPessoa;
	}
	public void setCpfPessoa(String cpfPessoa) {
		this.cpfPessoa = cpfPessoa;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}	
}
