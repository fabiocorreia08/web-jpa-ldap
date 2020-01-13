package br.gov.cmb.cfad.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.gov.cmb.cfad.model.Person;
import br.gov.cmb.cfad.service.PersonRepo;

//@RestController
@Controller
@RequestMapping(value="/person")
public class PersonController {
	
	@Autowired
    private PersonRepo personRepo;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
    public ModelAndView retrieve() {
		ModelAndView model = new ModelAndView("person_list");
		List<Person> personList = personRepo.retrieve();
		model.addObject("personList", personList);
		return model;
    }
	
	@RequestMapping(value="/update/{nome}", method=RequestMethod.GET)
	public ModelAndView edit(@PathVariable String nome) {
		ModelAndView model = new ModelAndView("person_list");		
		List<Person> personList = new ArrayList<Person>();
		model.addObject("personForm", personList);
		model.setViewName("person_form");		
		return model;
	}
 
    @PostMapping("/add-user")
    public ResponseEntity<String> bindLdapPerson(@RequestBody Person person) {
        String result = personRepo.create(person);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }   
 
    @PutMapping("/update-user")
    public ResponseEntity<String> rebindLdapPerson(@RequestBody Person person) {
        String result = personRepo.update(person);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }    
 
    @GetMapping("/remove-user")
    public ResponseEntity<String> unbindLdapPerson(@RequestParam(name = "userId") String userId) {
        String result = personRepo.remove(userId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
