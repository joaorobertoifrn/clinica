package br.edu.ifrn.clinica.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

import br.edu.ifrn.clinica.dto.ProfissionalDTO;
import br.edu.ifrn.clinica.model.Cidade;
import br.edu.ifrn.clinica.model.Convenio;
import br.edu.ifrn.clinica.model.Especialidade;
import br.edu.ifrn.clinica.model.LocalAtendimento;
import br.edu.ifrn.clinica.model.Profissional;
import br.edu.ifrn.clinica.model.enums.Sexo;
import br.edu.ifrn.clinica.repository.CidadeRepository;
import br.edu.ifrn.clinica.repository.ConvenioRepository;
import br.edu.ifrn.clinica.repository.EspecialidadeRepository;
import br.edu.ifrn.clinica.repository.LocalAtendimentoRepository;
import br.edu.ifrn.clinica.repository.ProfissionalRepository;
import br.edu.ifrn.clinica.services.ProfissionalService;


@Controller
@RequestMapping(value="/profissional")
public class ProfissionalController {
	
	private static final String PROFISSIONAL_VIEW = "Profissional/Profissional";
	private static final String PROFISSIONAL_CADASTRO_VIEW = "Profissional/ProfissionalCadastro";
	
	@Autowired
	private ProfissionalService service;
	
	@Autowired
	private CidadeRepository cidades;
	
	@Autowired
	private ConvenioRepository convenios;
	
	@Autowired
	private EspecialidadeRepository especialidades;
	
	@Autowired
	private LocalAtendimentoRepository locaisAtendimentos;
	
	@Autowired
	private ProfissionalRepository profissionais;

	@GetMapping("/")
	public ModelAndView profissional() {
		List<Profissional> list = service.findAll();
		List<ProfissionalDTO> listDto = list.stream().map(obj -> new ProfissionalDTO(obj)).collect(Collectors.toList());
		ModelAndView mv = new ModelAndView(PROFISSIONAL_VIEW);
		mv.addObject("listaProfissionais", profissionais.count());
		mv.addObject("profissionais", listDto);
		return mv;
	}
	
	@RequestMapping("/novo")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView(PROFISSIONAL_CADASTRO_VIEW);
		mv.addObject(new Profissional());
		return mv;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Profissional> find(@PathVariable Long id) {
		Profissional obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.POST)
	@PreAuthorize("hasAnyRole('ADMIN')")
	public String salvar(@Validated Profissional profissional, Errors errors, RedirectAttributes attributes) {
		if (errors.hasErrors()) {
			return PROFISSIONAL_CADASTRO_VIEW;
		}
		try {
			service.salvar(profissional);
			attributes.addFlashAttribute("mensagem", "Profissional Salvo com sucesso!");
			return "redirect:/Profissional/novo";
		} catch (Exception e) {
			errors.rejectValue("Profissional", null, e.getMessage());
			return PROFISSIONAL_CADASTRO_VIEW;
		}
	}
	
	@RequestMapping(value="/editar/{id}")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ModelAndView edicao(@PathVariable("id") Profissional profissional) {
		ModelAndView mv = new ModelAndView(PROFISSIONAL_CADASTRO_VIEW); 
		mv.addObject(profissional);
		return mv;
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.DELETE)
	public String excluir(@PathVariable Long id, RedirectAttributes attributes) {
		service.delete(id);
		
		attributes.addFlashAttribute("mensagem", "Profissional Excluido com sucesso!");
		return "redirect:/profissional/";
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
	
	@ModelAttribute("listaEspecialidade")
	public List<Especialidade> listaEspecialidade() {
		List<Especialidade> list = especialidades.findAll();
		return list;
	}
	
	@ModelAttribute("listaLocaisAtendimentos")
	public List<LocalAtendimento> listaLocaisAtendimentos() {
		List<LocalAtendimento> list = locaisAtendimentos.findAll();
		return list;
	}	
	
}
