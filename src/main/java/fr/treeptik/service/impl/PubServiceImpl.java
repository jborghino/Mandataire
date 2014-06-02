package fr.treeptik.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.treeptik.dao.PubDAO;
import fr.treeptik.exception.DAOException;
import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Pub;
import fr.treeptik.service.PubService;

//public class PubServiceImpl extends GenericService<PubDAO, Pub, Integer>{
@Service
public class PubServiceImpl implements PubService{
	
	@Autowired
	private PubDAO pubDAO;
	
//	@Override
//	protected PubDAO getDao() {
//		return pubDAO;
//	}


	@Override
	@Transactional
	public Pub save(Pub pub) throws ServiceException{
		try {
			return pubDAO.save(pub);
		} catch (DAOException e) {
			throw new ServiceException("Erreur save pub", e);
		}
	}
	
	@Override
	@Transactional
	public Pub update(Pub pub) throws ServiceException{
		try {
			return pubDAO.update(pub);
		} catch (DAOException e) {
			throw new ServiceException("Erreur update pub", e);
		}
	}
	
	@Override
	@Transactional
	public void remove(Pub pub) throws ServiceException{
		try {
			pub = this.findById(pub.getId());
			pubDAO.remove(pub);
		} catch (DAOException e) {
			throw new ServiceException("Erreur remove pub", e);
		}
	}
	
	@Override
	public Pub findById(Integer id) throws ServiceException{
		try {
			return pubDAO.findById(id);
		} catch (DAOException e) {
			throw new ServiceException("Erreur findById pub", e);
		}
	}
	
	@Override
	public List<Pub> findAll() throws ServiceException{
		try {
			return (List<Pub>) pubDAO.findAll();
		} catch (DAOException e) {
			throw new ServiceException("Erreur findAll pub", e);
		}
	}

	@Override
	public Pub getPub(List<Pub> list) throws ServiceException {
		try {
			return pubDAO.getPub(list);
		} catch (DAOException e) {
			throw new ServiceException("Erreur getPub pub", e);
		}
	}
	
	
	
}
