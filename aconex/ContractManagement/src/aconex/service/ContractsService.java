package aconex.service;

import java.math.BigInteger;
import java.util.List;

import aconex.entities.Contract;

public interface ContractsService {
	
	public List<Contract> getContracts(BigInteger projectId);
	
	public Contract findContractById(Integer id);
	
	public void update(Contract c);

}
