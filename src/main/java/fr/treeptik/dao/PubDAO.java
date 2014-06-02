package fr.treeptik.dao;

import java.util.List;

import fr.treeptik.exception.DAOException;
import fr.treeptik.model.Pub;

public interface PubDAO extends GenericDAO<Pub, Integer> {

	public Pub getPub(List<Pub> list) throws DAOException;
	
}
