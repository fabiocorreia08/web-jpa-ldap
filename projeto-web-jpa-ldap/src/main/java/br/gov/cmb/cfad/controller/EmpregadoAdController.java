package br.gov.cmb.cfad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.gov.cmb.cfad.model.EmpregadoAd;
import br.gov.cmb.cfad.service.EmpregadoAdService;

@Controller
@RequestMapping(value="/empregadoAd")
public class EmpregadoAdController {
	
	@Autowired
	EmpregadoAdService empregadoAdService;
		
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView model = new ModelAndView("empregado_ad_list");
		List<EmpregadoAd> empregadoAdList = empregadoAdService.getAll();
		model.addObject("empregadoAdList", empregadoAdList);
		return model;
	}	
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView model = new ModelAndView("empregado_ad_list");		
		EmpregadoAd empregadoAd = new EmpregadoAd();
		model.addObject("empregadoAdForm", empregadoAd);
		model.setViewName("empregado_ad_form");		
		return model;
	}	
	
	@RequestMapping(value="/update/{id}", method=RequestMethod.GET)
	public ModelAndView edit(@PathVariable long id) {
		ModelAndView model = new ModelAndView("empregado_ad_list");		
		EmpregadoAd empregadoAd = empregadoAdService.getById(id);
		model.addObject("empregadoAdForm", empregadoAd);
		model.setViewName("empregado_ad_form");		
		return model;
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("empregadoAdForm") EmpregadoAd empregadoAd) {			
		empregadoAdService.saveOrUpdate(empregadoAd);		
		return new ModelAndView("redirect:/empregadoAd/list");
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id") long id) {			
		empregadoAdService.delete(id);		
		return new ModelAndView("redirect:/empregadoAd/list");
	}
	
	@RequestMapping(value = "/listByMatricula", method = RequestMethod.GET)
    public ModelAndView listByMatricula(@RequestParam(name = "matricula") String matricula) {
		  ModelAndView model = new ModelAndView("empregado_ad_list");
          List<EmpregadoAd> empregadoAdList = empregadoAdService.getByMatricula(matricula);
          model.addObject("empregadoAdList", empregadoAdList);
          return model;
    } 
	

}
