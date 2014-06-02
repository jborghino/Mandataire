package fr.treeptik.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import fr.treeptik.dao.RoleDAO;
import fr.treeptik.model.Role;

@Repository
public class RoleJPADAO extends GenericJPADAO<Role, Integer> implements RoleDAO{

	@PersistenceContext
	private EntityManager entityManager;
	
	public RoleJPADAO(){
		super(Role.class);
	}
	
}
