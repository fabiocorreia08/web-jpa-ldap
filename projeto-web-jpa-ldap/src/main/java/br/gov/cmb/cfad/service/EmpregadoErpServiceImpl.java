package br.gov.cmb.cfad.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.cmb.cfad.model.EmpregadoErp;
import br.gov.cmb.cfad.repository.EmpregadoErpRepository;

@Service
@Transactional
public class EmpregadoErpServiceImpl implements EmpregadoErpService{
	
	@Autowired
	EmpregadoErpRepository empregadoErpRepository;

	@Override
	public List<EmpregadoErp> getAll() {
		return (List<EmpregadoErp>) empregadoErpRepository.findAll();
	}

	@Override
	public EmpregadoErp getById(long id) {
		return empregadoErpRepository.findById(id).get();
	}	
	
	@Override
	public List<EmpregadoErp> getByNome(String nome) {
		return empregadoErpRepository.findByNome(nome);
	}
	
	@Override
	public List<EmpregadoErp> getByMatricula(String matricula) {
		return empregadoErpRepository.findByMatricula(matricula);
	}

	@Override
	public void saveOrUpdate(EmpregadoErp empregadoErp) {
		empregadoErpRepository.save(empregadoErp);		
	}

	@Override
	public void delete(long id) {
		empregadoErpRepository.deleteById(id);		
	}

}