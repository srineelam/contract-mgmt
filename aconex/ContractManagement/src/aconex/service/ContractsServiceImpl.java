package aconex.service;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import aconex.entities.Contract;


@Repository
@Transactional
public class ContractsServiceImpl implements ContractsService {
	
	@PersistenceContext
    private EntityManager em;
	
	public List<Contract> getContracts(BigInteger id) {
		TypedQuery<Contract> q = em.createNamedQuery("getContracts", Contract.class);
		q.setParameter("id", id);
		List<Contract> contracts = q.getResultList();
		return contracts;
	}
	
	public Contract findContractById(Integer id) {
		return em.find(Contract.class, id);
	}
	
	public void update(Contract c) {
		Contract ce = em.find(Contract.class, c.getId());
		ce.setCode(c.getCode());
		ce.setDescription(c.getDescription());
		ce.setVendor(c.getVendor());
		ce.setBudget(c.getBudget());
		ce.setCommittedCost(c.getCommittedCost());
		ce.setForecast(c.getForecast());
		ce.setPaid(c.getPaid());
		ce.setComplete(c.getComplete());
	}

}
