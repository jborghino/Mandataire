package fr.treeptik.dao;

import fr.treeptik.exception.DAOException;
import fr.treeptik.model.Vehicule;

public interface VehiculeDAO extends GenericDAO<Vehicule, Integer> {

	public void deleteById(Integer concessionnaire_id) throws DAOException;
	
}
