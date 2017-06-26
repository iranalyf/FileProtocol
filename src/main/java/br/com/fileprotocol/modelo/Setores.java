package br.com.fileprotocol.modelo;

public enum Setores {

	TI("Tecnologia da Informação"), CONTABILIDADE("Contabilidade"), FINANCEIRO("Financeiro"), ALMOXARIFADO(
			"Almoxarifado");

	private String descricao;

	Setores(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
