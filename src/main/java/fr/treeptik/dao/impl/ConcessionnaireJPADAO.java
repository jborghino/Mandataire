package fr.treeptik.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import fr.treeptik.dao.ConcessionnaireDAO;
import fr.treeptik.exception.DAOException;
import fr.treeptik.model.Concessionnaire;

@Repository
public class ConcessionnaireJPADAO extends GenericJPADAO<Concessionnaire, Integer> implements ConcessionnaireDAO{

	@PersistenceContext
	private EntityManager entityManager;
	
	public ConcessionnaireJPADAO(){
		super(Concessionnaire.class);
	}

	@Override
	public List<String> findAllSiren() throws DAOException {
		TypedQuery<String> query3 = entityManager.createQuery(
				"select c.siren from Concessionnaire c", String.class);
		List<String> resultList = query3.getResultList();
		if (resultList != null) {
			return resultList;
		}
		return null;
	}
	
}
