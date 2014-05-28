package fr.treeptik.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.treeptik.dao.VehiculeDAO;
import fr.treeptik.exception.DAOException;
import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Vehicule;
import fr.treeptik.service.VehiculeService;

//public class VehiculeServiceImpl extends GenericService<VehiculeDAO, Vehicule, Integer>{
@Service
public class VehiculeServiceImpl implements VehiculeService{
	
	@Autowired
	private VehiculeDAO vehiculeDAO;
	
//	@Override
//	protected VehiculeDAO getDao() {
//		return vehiculeDAO;
//	}


	@Override
	@Transactional
	public Vehicule save(Vehicule vehicule) throws ServiceException{
		try {
			return vehiculeDAO.save(vehicule);
		} catch (DAOException e) {
			throw new ServiceException("Erreur save vehicule", e);
		}
	}
	
	@Override
	@Transactional
	public Vehicule update(Vehicule vehicule) throws ServiceException{
		try {
			return vehiculeDAO.update(vehicule);
		} catch (DAOException e) {
			throw new ServiceException("Erreur update vehicule", e);
		}
	}
	
	@Override
	@Transactional
	public void remove(Vehicule vehicule) throws ServiceException{
		try {
			vehicule = this.findById(vehicule.getId());
			vehiculeDAO.remove(vehicule);
		} catch (DAOException e) {
			throw new ServiceException("Erreur remove vehicule", e);
		}
	}
	
	@Override
	public Vehicule findById(Integer id) throws ServiceException{
		try {
			return vehiculeDAO.findById(id);
		} catch (DAOException e) {
			throw new ServiceException("Erreur findById vehicule", e);
		}
	}
	
	@Override
	public List<Vehicule> findAll() throws ServiceException{
		try {
			return (List<Vehicule>) vehiculeDAO.findAll();
		} catch (DAOException e) {
			throw new ServiceException("Erreur findAll vehicule", e);
		}
	}
	
	@Override
	@Transactional
	public void deleteById(Integer concessionnaire_id) throws ServiceException{
		try {
			vehiculeDAO.deleteById(concessionnaire_id);
		} catch (DAOException e) {
			throw new ServiceException("Erreur deleteById vehicule", e);
		}
	}
	
}
