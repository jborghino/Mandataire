package fr.treeptik.service;

import java.util.List;

import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Vehicule;



public interface VehiculeService {

	Vehicule save(Vehicule vehicule) throws ServiceException;

	Vehicule update(Vehicule vehicule) throws ServiceException;

	void remove(Vehicule vehicule) throws ServiceException;

	Vehicule findById(Integer id) throws ServiceException;

	List<Vehicule> findAll() throws ServiceException;
	
}
