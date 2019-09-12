package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.Auditoria;

@Stateless
public class AuditoriaDAO {
	
	@PersistenceContext(unitName = "auditoria_pu")
	private EntityManager em;
	
	public void insert(Auditoria auditoria) {
		em.persist(auditoria);
	}

}
