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

import br.edu.ifrn.clinica.dto.PacienteDTO;
import br.edu.ifrn.clinica.model.Paciente;
import br.edu.ifrn.clinica.services.PacienteService;


@RestController
@RequestMapping(value="/paciente")
public class PacienteController {
	
	@Autowired
	private PacienteService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<PacienteDTO>> findAll() {
		List<Paciente> list = service.findAll();
		List<PacienteDTO> listDto = list.stream().map(obj -> new PacienteDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Paciente> find(@PathVariable Long id) {
		Paciente obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.POST)
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<Void> salvar(@Valid @RequestBody Paciente paciente) {
		service.salvar(paciente);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}").buildAndExpand(paciente.getId()).toUri();
			return ResponseEntity.created(uri).build();
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
