package br.edu.ifrn.clinica.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.ifrn.clinica.dto.PacienteDTO;
import br.edu.ifrn.clinica.model.Cidade;
import br.edu.ifrn.clinica.model.Convenio;
import br.edu.ifrn.clinica.model.Paciente;
import br.edu.ifrn.clinica.model.enums.Sexo;
import br.edu.ifrn.clinica.repository.CidadeRepository;
import br.edu.ifrn.clinica.repository.ConvenioRepository;
import br.edu.ifrn.clinica.repository.PacienteRepository;
import br.edu.ifrn.clinica.services.PacienteService;


@Controller
@RequestMapping(value="/Paciente")
public class PacienteController {
	
	private static final String PACIENTE_VIEW = "Paciente";
	private static final String PACIENTE_CADASTRO_VIEW = "PacienteCadastro";
	
	@Autowired
	private PacienteService service;
	
	@Autowired
	private PacienteRepository pacientes;
	
	@Autowired
	private CidadeRepository cidades;
	
	@Autowired
	private ConvenioRepository convenios;

	@GetMapping("/")
	public ModelAndView paciente() {
		List<Paciente> list = service.findAll();
		List<PacienteDTO> listDto = list.stream().map(obj -> new PacienteDTO(obj)).collect(Collectors.toList());
		ModelAndView mv = new ModelAndView(PACIENTE_VIEW);
		mv.addObject("listaPacientes", pacientes.count());
		mv.addObject("pacientes", listDto);
		return mv;
	}
	
	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView(PACIENTE_CADASTRO_VIEW);
		mv.addObject(new Paciente());
		return mv;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Paciente> find(@PathVariable Long id) {
		Paciente obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated Paciente paciente, Errors errors, RedirectAttributes attributes) {
		if (errors.hasErrors()) {
			return PACIENTE_CADASTRO_VIEW;
		}
		try {
			service.salvar(paciente);
			attributes.addFlashAttribute("mensagem", "Paciente Salvo com sucesso!");
			return "redirect:/Paciente/novo";
		} catch (Exception e) {
			errors.rejectValue("Paciente", null, e.getMessage());
			return PACIENTE_CADASTRO_VIEW;
		}
	}
	
	@RequestMapping(value="/Editar/{id}")
	public ModelAndView edicao(@PathVariable("id") Paciente paciente) {
		ModelAndView mv = new ModelAndView(PACIENTE_CADASTRO_VIEW); 
		mv.addObject(paciente);
		return mv;
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.DELETE)
	public String excluir(@PathVariable Long id, RedirectAttributes attributes) {
		service.delete(id);
		
		attributes.addFlashAttribute("mensagem", "Paciente Excluido com sucesso!");
		return "redirect:/Paciente/";
	}
	
	@ModelAttribute("listaCidades")
	public List<Cidade> listaCidades() {
		List<Cidade> list = cidades.findAll();
		return list;
	}	
	
	@ModelAttribute("listaSexo")
	public List<Sexo> listaSexo() {
		return Arrays.asList(Sexo.values());
	}
	
	@ModelAttribute("listaConvenio")
	public List<Convenio> listaConvenio() {
		List<Convenio> list = convenios.findAll();
		return list;
	}		
}
