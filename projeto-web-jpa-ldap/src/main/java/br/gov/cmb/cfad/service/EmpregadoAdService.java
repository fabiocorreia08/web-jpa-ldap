package br.gov.cmb.cfad.service;

import java.util.List;

import br.gov.cmb.cfad.model.EmpregadoAd;

public interface EmpregadoAdService {
	
	public List<EmpregadoAd> getAll();
	
	public EmpregadoAd getById(long id); 
	
	public void saveOrUpdate(EmpregadoAd empregadoAd); 
	
	public List<EmpregadoAd> getByMatricula(String matricula);
		
	public void delete(long id);


}
