package br.com.fileprotocol.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.fileprotocol.DAO.FornecedorDAO;
import br.com.fileprotocol.modelo.Fornecedor;

@FacesConverter(forClass = Fornecedor.class)
public class FornecedorConverter implements Converter {

	private FornecedorDAO repository;

	public FornecedorConverter() {
		this.repository = new FornecedorDAO();
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Fornecedor retorno = null;

		if (value != null) {
			Long id = new Long(value);
			retorno = repository.buscaporid(id);
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {

			Fornecedor fornecedor = (Fornecedor) value;
			return fornecedor.getCodigoFornecedor() == null ? null : fornecedor.getCodigoFornecedor().toString();
		}

		return "";
	}
}
