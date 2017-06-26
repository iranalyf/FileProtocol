package br.com.fileprotocol.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fileprotocol.modelo.Entrega;

public class EntregaDAO {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("FileProtocol");
	private EntityManager em = emf.createEntityManager();

	public void salvar(Entrega entrega) {
		this.em.getTransaction().begin();
		this.em.merge(entrega);
		this.em.getTransaction().commit();
	}

	public void excluir(Entrega entrega) {
		this.em.getTransaction().begin();
		this.em.remove(entrega);
		this.em.getTransaction().commit();
	}

	public List<Entrega> buscaTodos() {
		return this.em.createQuery("select u from Entrega u", Entrega.class).getResultList();
	}

	public Entrega buscaporid(Long id) {
		return this.em.find(Entrega.class, id);

	}
}
