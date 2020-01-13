package br.gov.cmb.cfad.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.cmb.cfad.model.EmpregadoAd;
import br.gov.cmb.cfad.repository.EmpregadoAdRepository;

@Service
@Transactional
public class EmpregadoAdServiceImpl implements EmpregadoAdService{
	
	@Autowired
	EmpregadoAdRepository empregadoAdRepository;

	@Override
	public List<EmpregadoAd> getAll() {
		return (List<EmpregadoAd>) empregadoAdRepository.findAll();
	}

	@Override
	public EmpregadoAd getById(long id) {
		return empregadoAdRepository.findById(id).get();
	}

	@Override
	public void saveOrUpdate(EmpregadoAd empregadoAd) {
		empregadoAdRepository.save(empregadoAd);		
	}

	@Override
	public void delete(long id) {
		empregadoAdRepository.deleteById(id);		
	}
	
	@Override
	public List<EmpregadoAd> getByMatricula(String matricula) {
		return empregadoAdRepository.findByMatricula(matricula);
	}

}