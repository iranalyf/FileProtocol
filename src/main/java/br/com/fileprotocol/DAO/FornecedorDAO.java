package br.com.fileprotocol.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fileprotocol.modelo.Fornecedor;

public class FornecedorDAO {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("FileProtocol");
	private EntityManager em = emf.createEntityManager();

	public void salvar(Fornecedor fornecedor) {
		this.em.getTransaction().begin();
		this.em.merge(fornecedor);
		this.em.getTransaction().commit();
	}

	public void excluir(Fornecedor fornecedor) {
		this.em.getTransaction().begin();
		this.em.remove(fornecedor);
		this.em.getTransaction().commit();
	}

	public List<Fornecedor> buscaTodos() {
		return this.em.createQuery("select f from Fornecedor f", Fornecedor.class).getResultList();
	}

	public Fornecedor buscaporid(Long id) {
		return this.em.find(Fornecedor.class, id);
	}

}
