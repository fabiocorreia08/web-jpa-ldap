package br.gov.cmb.cfad.service;

import java.util.List;

import br.gov.cmb.cfad.model.EmpregadoErp;

public interface EmpregadoErpService {
	
	public List<EmpregadoErp> getAll();
	
	public EmpregadoErp getById(long id);	
	
	public List<EmpregadoErp> getByNome(String nome);
	
	public List<EmpregadoErp> getByMatricula(String matricula);
	
	public void saveOrUpdate(EmpregadoErp empregadoErp); 
		
	public void delete(long id);


}
