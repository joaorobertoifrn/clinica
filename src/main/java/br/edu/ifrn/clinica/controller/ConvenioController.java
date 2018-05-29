package br.edu.ifrn.clinica.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.ifrn.clinica.dto.ConvenioDTO;
import br.edu.ifrn.clinica.model.Convenio;
import br.edu.ifrn.clinica.repository.ConvenioRepository;
import br.edu.ifrn.clinica.services.ConvenioService;


@Controller
@RequestMapping(value="/Convenio")
public class ConvenioController {
	
	private static final String CONVENIO_VIEW = "Convenio/Convenio";
	private static final String CONVENIO_CADASTRO_VIEW = "Convenio/ConvenioCadastro";
	
	@Autowired
	private ConvenioService service;
	
	@Autowired
	private ConvenioRepository convenios;

	@GetMapping("/")
	public ModelAndView paciente() {
		List<Convenio> list = service.findAll();
		List<ConvenioDTO> listDto = list.stream().map(obj -> new ConvenioDTO(obj)).collect(Collectors.toList());
		ModelAndView mv = new ModelAndView(CONVENIO_VIEW);
		mv.addObject("listaConvenios", convenios.count());
		mv.addObject("convenios", listDto);
		return mv;
	}
	
	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView(CONVENIO_CADASTRO_VIEW);
		mv.addObject(new Convenio());
		return mv;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Convenio> find(@PathVariable Long id) {
		Convenio obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated Convenio convenio, Errors errors, RedirectAttributes attributes) {
		if (errors.hasErrors()) {
			return CONVENIO_CADASTRO_VIEW;
		}
		try {
			service.salvar(convenio);
			attributes.addFlashAttribute("mensagem", "Convenio Salvo com sucesso!");
			return "redirect:/Convenio/novo";
		} catch (Exception e) {
			errors.rejectValue("Convenio", null, e.getMessage());
			return CONVENIO_CADASTRO_VIEW;
		}
	}
	
	@RequestMapping(value="/Editar/{id}")
	public ModelAndView edicao(@PathVariable("id") Convenio convenio) {
		ModelAndView mv = new ModelAndView(CONVENIO_CADASTRO_VIEW); 
		mv.addObject(convenio);
		return mv;
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.DELETE)
	public String excluir(@PathVariable Long id, RedirectAttributes attributes) {
		service.delete(id);
		
		attributes.addFlashAttribute("mensagem", "Convenio Excluido com sucesso!");
		return "redirect:/Convenio/";
	}
	
}
