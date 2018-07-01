package br.edu.ifrn.clinica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifrn.clinica.dto.DashboardDTO;
import br.edu.ifrn.clinica.repository.ConvenioRepository;
import br.edu.ifrn.clinica.repository.PacienteRepository;
import br.edu.ifrn.clinica.repository.ProfissionalRepository;

@RestController
@RequestMapping(value="/dashboard")
public class DashboardController {
	
	@Autowired
	private PacienteRepository pacientes;	

	@Autowired
	private ProfissionalRepository profissionais;	

	@Autowired
	private ConvenioRepository convenios;	

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<DashboardDTO> dashboard() {
		
		DashboardDTO dash = new DashboardDTO();
		dash.setTotalConvenios(convenios.count());
		dash.setTotalPacientes(pacientes.count());
		dash.setTotalProfissionais(profissionais.count());
		
		return  ResponseEntity.ok().body(dash);
	}
	
}
