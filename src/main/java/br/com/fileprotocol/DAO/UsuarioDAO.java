package br.com.fileprotocol.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.fileprotocol.modelo.Usuario;

public class UsuarioDAO {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("FileProtocol");
	private EntityManager em = emf.createEntityManager();

	public void salvar(Usuario usuario) {
		this.em.getTransaction().begin();
		this.em.merge(usuario);
		this.em.getTransaction().commit();
	}

	public void excluir(Usuario usuario) {
		this.em.getTransaction().begin();
		this.em.remove(usuario);
		this.em.getTransaction().commit();
	}

	public List<Usuario> buscaTodos() {
		return this.em.createQuery("select u from Usuario u", Usuario.class).getResultList();
	}

	public Usuario buscaporid(Long id) {
		return this.em.find(Usuario.class, id);
	}

	@SuppressWarnings("unchecked")
	public Usuario login(String email, String senha) {

		Query q = this.em.createQuery("select u from Usuario u where u.email = :usuario and u.senhaUsuario = :senha",
				Usuario.class);
		q.setParameter("usuario", email);
		q.setParameter("senha", senha);

		List<Usuario> usuarios = q.getResultList();

		if (usuarios.isEmpty()) {
			return null;
		}

		return usuarios.get(0);
	}

}
