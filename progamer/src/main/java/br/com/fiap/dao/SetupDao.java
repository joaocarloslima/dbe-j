package br.com.fiap.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.model.Setup;

public class SetupDao {

	@Inject
	private EntityManager manager;
	
	public void create(Setup setup) {
		
		manager.getTransaction().begin();
		manager.persist(setup);
		manager.getTransaction().commit();
		
		manager.clear();
	}
	
	public List<Setup> listAll() {
		
		TypedQuery<Setup> query = 
				manager.createQuery("SELECT s FROM Setup s", Setup.class);
		
		return query.getResultList();
		
	}

	public void remove(Setup setup) {	
		manager.getTransaction().begin();
		manager.remove(setup);
		manager.getTransaction().commit();
	}

	public void update(Setup setup) {
		manager.getTransaction().begin();
		setup = manager.merge(setup);
		manager.getTransaction().commit();
	}

}
