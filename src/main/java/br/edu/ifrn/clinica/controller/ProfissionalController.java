package br.edu.ifrn.clinica.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.edu.ifrn.clinica.dto.ProfissionalDTO;
import br.edu.ifrn.clinica.model.Profissional;
import br.edu.ifrn.clinica.services.ProfissionalService;


@RestController
@RequestMapping(value="/profissional")
public class ProfissionalController {
	
	@Autowired
	private ProfissionalService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<ProfissionalDTO>> findAll() {
		List<Profissional> list = service.findAll();
		List<ProfissionalDTO> listDto = list.stream().map(obj -> new ProfissionalDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

	@RequestMapping(method = RequestMethod.POST)
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<Void> salvar(@Valid @RequestBody Profissional profissional) {
		service.salvar(profissional);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}").buildAndExpand(profissional.getId()).toUri();
			return ResponseEntity.created(uri).build();
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Profissional> find(@PathVariable Long id) {
		Profissional obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
