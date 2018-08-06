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

import br.edu.ifrn.clinica.dto.EspecialidadeDTO;
import br.edu.ifrn.clinica.model.Especialidade;
import br.edu.ifrn.clinica.services.EspecialidadeService;


@RestController
@RequestMapping(value="/especialidade")
public class EspecialidadeController {
	
	@Autowired
	private EspecialidadeService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<EspecialidadeDTO>> findAll() {
		List<Especialidade> list = service.findAll();
		List<EspecialidadeDTO> listDto = list.stream().map(obj -> new EspecialidadeDTO(obj)).collect(Collectors.toList());
		return  ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Especialidade> find(@PathVariable Long id) {
		Especialidade obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.POST)
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<Void> salvar(@Valid @RequestBody Especialidade especialidade) {
		service.salvar(especialidade);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}").buildAndExpand(especialidade.getId()).toUri();
			return ResponseEntity.created(uri).build();
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
