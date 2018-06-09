package br.edu.ifrn.clinica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifrn.clinica.repository.PacienteRepository;

@Controller
public class DashboardController {
	
	private static final String DASHBOARD_VIEW = "Dashboard/Dashboard";
	
	@Autowired
	private PacienteRepository pacientes;	
	
	@GetMapping("/dashboard")
	public ModelAndView dashboard() {
		ModelAndView mv = new ModelAndView(DASHBOARD_VIEW);
		
		mv.addObject("totalAgendamento", 50);
		mv.addObject("totalAtendimentos", 100);
		mv.addObject("totalPacientes", pacientes.count());
		
		return mv;
	}
}
