package br.edu.ifrn.clinica.dto;

import java.io.Serializable;

import br.edu.ifrn.clinica.model.Especialidade;

public class EspecialidadeDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private String nome;
	
    public EspecialidadeDTO(){
    	
    }  
    
    public EspecialidadeDTO(Especialidade obj) {
    	id = obj.getId();
    	nome = obj.getNome();
	}
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}