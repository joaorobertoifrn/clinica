package br.edu.ifrn.clinica.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.edu.ifrn.clinica.dto.EspecialidadeDTO;
import br.edu.ifrn.clinica.model.Especialidade;
import br.edu.ifrn.clinica.repository.EspecialidadeRepository;
import br.edu.ifrn.clinica.services.exceptions.DataIntegrityException;
import br.edu.ifrn.clinica.services.exceptions.ObjectNotFoundException;

@Service
public class EspecialidadeService {
	
	@Autowired
	private EspecialidadeRepository repo;
	
	public Especialidade find(Long id) {
		Especialidade obj = repo.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id
					+ ", Tipo: " + Especialidade.class.getName());
		}
		return obj;
	}
	
	public void salvar(Especialidade obj) {
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
			throw new DataIntegrityException("Não é possível excluir um Especialidade");
		}
	}
	
	public List<Especialidade> findAll() {
		return repo.findAll();
	}

	public Especialidade fromDTO(EspecialidadeDTO objDto) {
		return new Especialidade(objDto.getId(), objDto.getNome());
	}
}
