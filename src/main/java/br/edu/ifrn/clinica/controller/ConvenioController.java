package br.edu.ifrn.clinica.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.edu.ifrn.clinica.dto.ConvenioDTO;
import br.edu.ifrn.clinica.model.Convenio;
import br.edu.ifrn.clinica.services.ConvenioService;


@RestController
@RequestMapping(value="/convenio")
public class ConvenioController {
	
	@Autowired
	private ConvenioService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<ConvenioDTO>> findAll() {
		List<Convenio> list = service.findAll();
		List<ConvenioDTO> listDto = list.stream().map(obj -> new ConvenioDTO(obj)).collect(Collectors.toList());
		return  ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Convenio> find(@PathVariable Long id) {
		Convenio obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.POST)
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<Void> salvar(@Valid @RequestBody Convenio convenio) {
		service.salvar(convenio);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}").buildAndExpand(convenio.getId()).toUri();
			return ResponseEntity.created(uri).build();
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
