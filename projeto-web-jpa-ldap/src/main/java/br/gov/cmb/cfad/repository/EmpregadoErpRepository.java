package br.gov.cmb.cfad.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.gov.cmb.cfad.model.EmpregadoErp;

public interface EmpregadoErpRepository extends CrudRepository<EmpregadoErp, Long>{
	
	List<EmpregadoErp> findByNome(String nome);
	List<EmpregadoErp> findByMatricula(String matricula);
	
	

}
