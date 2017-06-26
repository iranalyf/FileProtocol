package br.com.fileprotocol.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.fileprotocol.DAO.UsuarioDAO;
import br.com.fileprotocol.modelo.Usuario;

@FacesConverter(forClass = Usuario.class)
public class UsuarioConverter implements Converter {

	private UsuarioDAO repository;

	public UsuarioConverter() {
		this.repository = new UsuarioDAO();
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Usuario retorno = null;

		if (value != null) {
			Long id = new Long(value);
			retorno = repository.buscaporid(id);
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {

			Usuario usuario = (Usuario) value;
			return usuario.getCodigoUsuario() == null ? null : usuario.getCodigoUsuario().toString();
		}

		return "";
	}
}
