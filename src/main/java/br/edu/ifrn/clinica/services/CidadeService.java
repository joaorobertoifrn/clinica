package br.edu.ifrn.clinica.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.edu.ifrn.clinica.dto.CidadeDTO;
import br.edu.ifrn.clinica.model.Cidade;
import br.edu.ifrn.clinica.repository.CidadeRepository;
import br.edu.ifrn.clinica.services.exceptions.DataIntegrityException;
import br.edu.ifrn.clinica.services.exceptions.ObjectNotFoundException;

@Service
public class CidadeService {
	
	@Autowired
	private CidadeRepository repo;
	
	public Cidade find(Long id) {
		Cidade obj = repo.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id
					+ ", Tipo: " + Cidade.class.getName());
		}
		return obj;
	}
	
	public void salvar(Cidade obj) {
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
			throw new DataIntegrityException("Não é possível excluir um Cidade");
		}
	}
	
	public List<Cidade> findAll() {
		return repo.findAll();
	}

	public Cidade fromDTO(CidadeDTO objDto) {
		return new Cidade( objDto.getId(), objDto.getNome());
	}
}
