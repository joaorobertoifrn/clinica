package br.edu.ifrn.clinica.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.edu.ifrn.clinica.dto.ConvenioDTO;
import br.edu.ifrn.clinica.model.Convenio;
import br.edu.ifrn.clinica.model.Paciente;
import br.edu.ifrn.clinica.repository.ConvenioRepository;
import br.edu.ifrn.clinica.services.exceptions.DataIntegrityException;
import br.edu.ifrn.clinica.services.exceptions.ObjectNotFoundException;

@Service
public class ConvenioService {
	
	@Autowired
	private ConvenioRepository repo;
	
	public Convenio find(Long id) {
		Convenio obj = repo.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id
					+ ", Tipo: " + Paciente.class.getName());
		}
		return obj;
	}
	
	public void salvar(Convenio obj) {
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
			throw new DataIntegrityException("Não é possível excluir um Convenio");
		}
	}
	
	public List<Convenio> findAll() {
		return repo.findAll();
	}

	public Paciente fromDTO(ConvenioDTO objDto) {
		return new Paciente(objDto.getId(), objDto.getNome());
	}
}
