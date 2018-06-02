package br.edu.ifrn.clinica.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.edu.ifrn.clinica.dto.ProfissionalDTO;
import br.edu.ifrn.clinica.model.Profissional;
import br.edu.ifrn.clinica.repository.ProfissionalRepository;
import br.edu.ifrn.clinica.services.exceptions.DataIntegrityException;
import br.edu.ifrn.clinica.services.exceptions.ObjectNotFoundException;

@Service
public class ProfissionalService {

	@Autowired
	private BCryptPasswordEncoder pe;
	
	@Autowired
	private ProfissionalRepository repo;
	
	public Profissional find(Long id) {
		Profissional obj = repo.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id
					+ ", Tipo: " + Profissional.class.getName());
		}
		return obj;
	}
	
	public void salvar(Profissional obj) {
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
	
	public List<Profissional> findAll() {
		return repo.findAll();
	}

	public Profissional fromDTO(ProfissionalDTO objDto) {
		return new Profissional(objDto.getId(), objDto.getNome(), objDto.getConselhoProfissional(), objDto.getEstadoConselho(), objDto.getNumeroConselho());
	}
}
