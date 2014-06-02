package fr.treeptik.service;

import java.util.List;

import fr.treeptik.exception.DAOException;
import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Pub;



public interface PubService {

	Pub save(Pub pub) throws ServiceException;

	Pub update(Pub pub) throws ServiceException;

	void remove(Pub pub) throws ServiceException;

	Pub findById(Integer id) throws ServiceException;

	List<Pub> findAll() throws ServiceException;
	
	public Pub getPub(List<Pub> list) throws ServiceException;
}
