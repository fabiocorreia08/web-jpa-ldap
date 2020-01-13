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

import br.gov.cmb.cfad.model.EmpregadoErp;
import br.gov.cmb.cfad.service.EmpregadoErpService;

@Controller
@RequestMapping(value="/empregadoErp")
public class EmpregadoErpController {
	
	@Autowired
	EmpregadoErpService empregadoErpService;
		
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView model = new ModelAndView("empregado_erp_list");
		List<EmpregadoErp> empregadoErpList = empregadoErpService.getAll();
		model.addObject("empregadoErpList", empregadoErpList);
		return model;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView model = new ModelAndView("empregado_erp_list");		
		EmpregadoErp empregadoErp = new EmpregadoErp();
		model.addObject("empregadoErpForm", empregadoErp);
		model.setViewName("empregado_erp_form");		
		return model;
	}	
	
	@RequestMapping(value="/update/{id}", method=RequestMethod.GET)
	public ModelAndView edit(@PathVariable long id) {
		ModelAndView model = new ModelAndView("empregado_erp_list");		
		EmpregadoErp empregadoErp = empregadoErpService.getById(id);
		model.addObject("empregadoErpForm", empregadoErp);
		model.setViewName("empregado_erp_form");		
		return model;
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("empregadoErpForm") EmpregadoErp empregadoErp) {			
		empregadoErpService.saveOrUpdate(empregadoErp);		
		return new ModelAndView("redirect:/empregadoErp/list");
	}
		
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id") long id) {			
		empregadoErpService.getById(id);		
		return new ModelAndView("redirect:/empregadoErp/list");
	}	
	
	@RequestMapping(value = "/listByNome/{nome}", method = RequestMethod.GET)
    public ModelAndView listByNome(@PathVariable("nome") String nome) {
		  ModelAndView model = new ModelAndView("empregado_erp_list");
          List<EmpregadoErp> empregadoErpList = empregadoErpService.getByNome(nome);
          model.addObject("empregadoErpList", empregadoErpList);
          return model;
    }	
	
	@RequestMapping(value = "/listByMatricula", method = RequestMethod.GET)
    public ModelAndView listByMatricula(@RequestParam(name = "matricula") String matricula) {
		  ModelAndView model = new ModelAndView("empregado_erp_list");
          List<EmpregadoErp> empregadoErpList = empregadoErpService.getByMatricula(matricula);
          model.addObject("empregadoErpList", empregadoErpList);
          return model;
    } 
	

}
