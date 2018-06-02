package br.edu.ifrn.clinica.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.edu.ifrn.clinica.dto.PacienteDTO;
import br.edu.ifrn.clinica.model.Paciente;
import br.edu.ifrn.clinica.repository.PacienteRepository;
import br.edu.ifrn.clinica.services.exceptions.DataIntegrityException;
import br.edu.ifrn.clinica.services.exceptions.ObjectNotFoundException;

@Service
public class PacienteService {

	@Autowired
	private BCryptPasswordEncoder pe;
	
	@Autowired
	private PacienteRepository repo;
	
	public Paciente find(Long id) {
		Paciente obj = repo.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id
					+ ", Tipo: " + Paciente.class.getName());
		}
		return obj;
	}
	
	public void salvar(Paciente obj) {
		try {
			repo.save(obj);
		} catch (DataIntegrityViolationException e) {
			throw new IllegalArgumentException("Formato de data inválido");
		}
	}
	
	public void delete(Long id) {
		find(id);
		try {
			repo.delete(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir um Paciente");
		}
	}
	
	public List<Paciente> findAll() {
		return repo.findAll();
	}

	public Paciente fromDTO(PacienteDTO objDto) {
		return new Paciente(objDto.getId(), objDto.getNome());
	}
}
