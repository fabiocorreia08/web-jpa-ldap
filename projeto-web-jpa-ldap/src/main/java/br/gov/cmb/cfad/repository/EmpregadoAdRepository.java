package br.gov.cmb.cfad.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.gov.cmb.cfad.model.EmpregadoAd;

public interface EmpregadoAdRepository extends CrudRepository<EmpregadoAd, Long>{

	List<EmpregadoAd> findByMatricula(String matricula);
	
}
