package fr.treeptik.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import fr.treeptik.dao.PubDAO;
import fr.treeptik.exception.DAOException;
import fr.treeptik.model.Pub;

@Repository
public class PubJPADAO extends GenericJPADAO<Pub, Integer> implements PubDAO{

	@PersistenceContext
	private EntityManager entityManager;
	
	public PubJPADAO(){
		super(Pub.class);
	}
	
	public Pub getPub(List<Pub> list) throws DAOException{
		TypedQuery<Pub> query3 = entityManager.createQuery(
				"select c from Concessionnaire c order by RANDOM", Pub.class);
		Pub singleResult = query3.getSingleResult();
	
		return singleResult;
	}
}
