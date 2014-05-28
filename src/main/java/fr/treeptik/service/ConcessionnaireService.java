package fr.treeptik.service;

import java.util.List;

import fr.treeptik.exception.DAOException;
import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Concessionnaire;



public interface ConcessionnaireService {

	Concessionnaire save(Concessionnaire concessionnaire) throws ServiceException;

	Concessionnaire update(Concessionnaire concessionnaire) throws ServiceException;

	void remove(Concessionnaire concessionnaire) throws ServiceException;

	Concessionnaire findById(Integer id) throws ServiceException;

	List<Concessionnaire> findAll() throws ServiceException;
	
	public List<String> findAllSiren() throws ServiceException;
	
	public Concessionnaire findBySiren(String siren) throws ServiceException;
	
}
