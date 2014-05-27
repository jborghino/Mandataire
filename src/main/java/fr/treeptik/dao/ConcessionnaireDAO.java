package fr.treeptik.dao;

import java.util.List;

import fr.treeptik.exception.DAOException;
import fr.treeptik.model.Concessionnaire;



public interface ConcessionnaireDAO extends GenericDAO<Concessionnaire, Integer> {

	
	public List<String> findAllSiren() throws DAOException;
	
}
