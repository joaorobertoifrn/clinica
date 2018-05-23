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

import br.edu.ifrn.clinica.dto.PacienteDTO;
import br.edu.ifrn.clinica.model.Paciente;
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

	@GetMapping("/")
	public ModelAndView paciente() {
		ModelAndView mv = new ModelAndView(PACIENTE_VIEW);
		mv.addObject("listaPacientes", pacientes.count());
		
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
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<PacienteDTO>> findAll() {
		List<Paciente> list = service.findAll();
		List<PacienteDTO> listDto = list.stream().map(obj -> new PacienteDTO(obj)).collect(Collectors.toList());  
		return ResponseEntity.ok().body(listDto);
	}

	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated Paciente paciente, Errors errors, RedirectAttributes attributes) {
		if (errors.hasErrors()) {
			return PACIENTE_CADASTRO_VIEW;
		}
		
		try {
			service.insert(paciente);
			attributes.addFlashAttribute("mensagem", "Paciente Salvo com sucesso!");
			return "redirect:/Paciente/novo";
		} catch (Exception e) {
			errors.rejectValue("Paciente", null, e.getMessage());
			return PACIENTE_CADASTRO_VIEW;
		}
	}
	
	@RequestMapping("{codigo}")
	public ModelAndView edicao(@PathVariable("codigo") Paciente paciente) {
		ModelAndView mv = new ModelAndView(PACIENTE_CADASTRO_VIEW); 
		mv.addObject(paciente);
		return mv;
	}
	
	@RequestMapping(value="{codigo}", method = RequestMethod.DELETE)
	public String excluir(@PathVariable Long id, RedirectAttributes attributes) {
		service.delete(id);
		
		attributes.addFlashAttribute("mensagem", "Paciente Excluido com sucesso!");
		return "redirect:/Paciente/novo";
	}
	
	
/*	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody PacienteDTO objDto) {
		Paciente obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody PacienteDTO objDto, @PathVariable Long id) {
		Paciente obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<PacienteDTO>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		Page<Paciente> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<PacienteDTO> listDto = list.map(obj -> new PacienteDTO(obj));  
		return ResponseEntity.ok().body(listDto);
	}		
*/
}
