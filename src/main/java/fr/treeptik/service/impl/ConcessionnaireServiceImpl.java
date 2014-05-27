package fr.treeptik.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.treeptik.dao.ConcessionnaireDAO;
import fr.treeptik.exception.DAOException;
import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Concessionnaire;
import fr.treeptik.service.ConcessionnaireService;

//public class ConcessionnaireServiceImpl extends GenericService<ConcessionnaireDAO, Concessionnaire, Integer>{
@Service
public class ConcessionnaireServiceImpl implements ConcessionnaireService {

	@Autowired
	private ConcessionnaireDAO concessionnaireDAO;

	@Override
	@Transactional
	public Concessionnaire save(Concessionnaire concessionnaire)
			throws ServiceException {
		try {
			return concessionnaireDAO.save(concessionnaire);
		} catch (DAOException e) {
			throw new ServiceException("Erreur save concessionnaire", e);
		}
	}

	@Override
	@Transactional
	public Concessionnaire update(Concessionnaire concessionnaire)
			throws ServiceException {
		try {
			return concessionnaireDAO.update(concessionnaire);
		} catch (DAOException e) {
			throw new ServiceException("Erreur update concessionnaire", e);
		}
	}

	@Override
	@Transactional
	public void remove(Concessionnaire concessionnaire) throws ServiceException {
		try {
			concessionnaire = this.findById(concessionnaire.getId());
			concessionnaireDAO.remove(concessionnaire);
		} catch (DAOException e) {
			throw new ServiceException("Erreur remove concessionnaire", e);
		}
	}

	@Override
	public Concessionnaire findById(Integer id) throws ServiceException {
		try {
			return concessionnaireDAO.findById(id);
		} catch (DAOException e) {
			throw new ServiceException("Erreur findById concessionnaire", e);
		}
	}

	@Override
	public List<Concessionnaire> findAll() throws ServiceException {
		try {
			return (List<Concessionnaire>) concessionnaireDAO.findAll();
		} catch (DAOException e) {
			throw new ServiceException("Erreur findAll concessionnaire", e);
		}
	}

	public ConcessionnaireDAO getConcessionnaireDAO() {
		return concessionnaireDAO;
	}

	public void setConcessionnaireDAO(ConcessionnaireDAO concessionnaireDAO) {
		this.concessionnaireDAO = concessionnaireDAO;
	}

	@Override
	public List<String> findAllSiren() throws ServiceException {
		try {
			return concessionnaireDAO.findAllSiren();
		} catch (DAOException e) {
			throw new ServiceException("Erreur findAllSiren concessionnaire", e);
		}
	}

}
