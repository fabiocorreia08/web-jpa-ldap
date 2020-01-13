package br.gov.cmb.cfad.service;

import java.util.List;

import br.gov.cmb.cfad.model.Person;

public interface PersonRepo {
	
	public List<Person> retrieve();
    public String create(Person p);
    public String update(Person p);
    public String remove(String userId);

}
