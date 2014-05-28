package fr.treeptik.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.treeptik.dao.VehiculeDAO;
import fr.treeptik.exception.DAOException;
import fr.treeptik.model.Vehicule;

@Repository
public class VehiculeJPADAO extends GenericJPADAO<Vehicule, Integer> implements
		VehiculeDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public VehiculeJPADAO() {
		super(Vehicule.class);
	}

	@Override
	public void deleteById(Integer concessionnaire_id) throws DAOException {
		Query query = entityManager
				.createQuery("delete from Vehicule v where v.concessionnaire_id = :concessionnaire_id");
		query.setParameter("concessionnaire_id", concessionnaire_id);
		int deleted = query.executeUpdate();
	}
}
