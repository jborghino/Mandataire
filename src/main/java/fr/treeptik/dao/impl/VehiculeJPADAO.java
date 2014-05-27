package fr.treeptik.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import fr.treeptik.dao.VehiculeDAO;
import fr.treeptik.model.Vehicule;

@Repository
public class VehiculeJPADAO extends GenericJPADAO<Vehicule, Integer> implements VehiculeDAO{

	@PersistenceContext
	private EntityManager entityManager;
	
	public VehiculeJPADAO(){
		super(Vehicule.class);
	}
	
}
