package br.com.fileprotocol.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.fileprotocol.DAO.EntregaDAO;
import br.com.fileprotocol.modelo.Entrega;

@FacesConverter(forClass = Entrega.class)
public class EntregaConverter implements Converter {

	private EntregaDAO repository;

	public EntregaConverter() {
		this.repository = new EntregaDAO();
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Entrega retorno = null;

		if (value != null) {
			Long id = new Long(value);
			retorno = repository.buscaporid(id);
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {

			Entrega entrega = (Entrega) value;
			return entrega.getCodigoEntrega() == null ? null : entrega.getCodigoEntrega().toString();
		}

		return "";
	}
}
